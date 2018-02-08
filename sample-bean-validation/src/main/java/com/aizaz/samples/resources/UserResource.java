package com.aizaz.samples.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aizaz.samples.builder.UserBuilder;
import com.aizaz.samples.dto.User;

@Path("/user")
public class UserResource {

    @Inject
    UserBuilder userBuilder;

    @Path("/valid")
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public User getValidUser() {
        return userBuilder.setFirstName("Fahad").setLastName("Aizaz").setGender("Male").setAge(33).build();
    }

    @Path("/invalid")
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public User getInvalidUser() {
        return userBuilder.setFirstName("Fahad").setGender("Male").setAge(33).build();
    }
}
