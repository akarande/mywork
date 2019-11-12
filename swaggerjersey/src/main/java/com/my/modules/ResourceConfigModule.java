package com.my.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.multibindings.MultibindingsScanner;
import com.google.inject.multibindings.ProvidesIntoSet;
import com.my.annotations.ResourceAnnotations;
import com.my.resource.PingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.Set;

/**
 * @author akarande
 **/
public class ResourceConfigModule extends AbstractModule {

    @Override
    protected void configure() {
        install(MultibindingsScanner.asModule());
    }

    @ProvidesIntoSet
    @ResourceAnnotations
    Class<?> providesJackson() {
        // Features.
        return JacksonFeature.class;
    }

    @ProvidesIntoSet
    @ResourceAnnotations
    Class<?> providesPing() {
        return PingResource.class;
    }

    @ProvidesIntoSet
    @ResourceAnnotations
    Class<?> providesSwaggerSerializer() {
        return SwaggerSerializers.class;
    }

    @Provides
    @Singleton
    @Inject
    ResourceConfig providesJerseyResources(@ResourceAnnotations Set<Class<?>> resources, Injector injector) {
        ResourceConfig resourceConfig = new ResourceConfig();
        resources.stream().map(injector::getInstance).forEach(resourceConfig::register);
        return resourceConfig;
    }
}