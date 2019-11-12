package com.my.resource;

import javax.ws.rs.Path;

import static com.my.resource.UserResource.BASE_PATH;

/**
 * @author akarande
 **/

@Path(BASE_PATH)
public class UserResource {
    public static final String BASE_PATH = "/user";
}
