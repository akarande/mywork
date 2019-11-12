package com.my.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.my.resource.PingResource.BASE_PATH;

/**
 * @author akarande
 **/
@Path(BASE_PATH)
@Api(value = "/ping")
public class PingResource {
    public static final String BASE_PATH = "/ping";

    @GET
    @ApiOperation(value = "Return status of the host", notes = "Returns ALIVE if the host is up", response = String.class)
    @Produces(MediaType.TEXT_PLAIN)
    public String getPing() {
        return "ALIVE";
    }
}
