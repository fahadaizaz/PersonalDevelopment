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

    /*
     * The better way is to use the container trigger bean validation. To do this
     * 1. The bean must be managed by container.
     * 2. In case of JPA, entity is managed by container and therefore JPA takes care of bean validation (trigger)
     * 3. The below is an example using builder pattern where builder is container managed
     * 4. Interceptors can also be used for bean validate (in that case we must do validation using Validation/ValidationFactory instances)
     */
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

    /*
     * As user is not a container managed bean (new User()), the bean validation framework cannot be triggered.
     * In such a case bean validation must be triggered manually which can be done using Validation/ValidationFactory instances
     */
    @Path("/test")
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public User getTestUser() {
        return new User(null, null, null, 0);
    }
}
