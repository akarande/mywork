package com.my.server;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.my.modules.ResourceConfigModule;
import com.my.resource.PingResource;
import io.swagger.jaxrs.config.DefaultJaxrsConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @author akarande
 **/
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final String HTTP_PROTOCOL = "http/1.1";
    private static final String HTTP_CONNECTION_NAME = "unsecured";
    private static final String HTTPS_CONNECTION_NAME = "secured";

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        logger.info("Starting webserver....");

        Set<Module> modules = ImmutableSet.of(new ResourceConfigModule());

        // Initialize Guice dependency injection.
        final Injector injector = Guice.createInjector(modules);

        // Initialize Jetty server
        Server server = new Server();

        // Initialize connectors for the server
        List<ServerConnector> connectors = new LinkedList<>();

        // Setup the servlet
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");
        server.setHandler(contextHandler);

        // Setup the http configuration
        ServerConnector httpConnector = new ServerConnector(server);
        httpConnector.setPort(50001);
        httpConnector.setName(HTTP_CONNECTION_NAME);
        connectors.add(httpConnector);
        server.setConnectors(connectors.toArray(new ServerConnector[0]));

        // Setup CORS Filters
        FilterHolder cors = contextHandler.addFilter(CrossOriginFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");

        /** Swagger Setup **/
        // Setting up Swagger Packages
        ServletHolder swaggerHolder = contextHandler.addServlet(ServletContainer.class, "/api/*");
        swaggerHolder.setInitOrder(1);
        swaggerHolder.setInitParameter(ServerProperties.PROVIDER_PACKAGES,
                "com.api.resources, io.swagger.jaxrs.json, io.swagger.jaxrs.listing, " + PingResource.class.getPackage().getName());

        // Setting up Swagger Core
        ServletHolder swaggerCore = contextHandler.addServlet(DefaultJaxrsConfig.class, "/swagger-core");
        swaggerCore.setInitOrder(2);
        swaggerCore.setInitParameter("api.version", "1.0.0");
        swaggerCore.setInitParameter("swagger.api.title", "Alerting API");

        // Initialize Jersey
        ServletContainer container = new ServletContainer(injector.getInstance(ResourceConfig.class));
        ServletHolder holder = new ServletHolder(container);
        contextHandler.addServlet(holder, "/*");

        // Setup Swagger-UI (uses static resources)
        ResourceHandler resourceHandler = new ResourceHandler();
        String resourceBasePath = Main.class.getResource("/webapp/").toExternalForm();
        resourceHandler.setResourceBase(resourceBasePath);
        ContextHandler handler = new ContextHandler("/docs");
        handler.setHandler(resourceHandler);

        // Add Handlers
        HandlerList handlers = new HandlerList();
        handlers.addHandler(handler);


        handlers.addHandler(contextHandler);
        server.setHandler(handlers);


        // Start the Jetty server.
        try {
            server.start();

            logger.info("Finished initialization in {} milliseconds.", TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));

            server.join();
        } catch (Exception excp) {
            logger.error("Failed to initialize webserver, service will shutdown.", excp);
        } finally {
            logger.info("Shutting down servlet context and webserver if necessary.");

            if (!contextHandler.isStopped()) {
                logger.info("Shutting down servlet context...");
                try {
                    server.stop();
                } catch(Exception e) {
                    logger.info("Exception thrown while stopping the server " + e);
                }
            } else {
                logger.info("Servlet context already stopped.");
            }

            if (!server.isStopped()) {
                logger.info("Shutting down webserver...");
                try {
                    server.stop();
                } catch(Exception e) {
                    logger.info("Exception thrown while stopping the server " + e);
                }
            } else {
                logger.info("Webserver server already stopped.");
            }
        }
    }
}
