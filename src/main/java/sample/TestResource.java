/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.Set;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

/**
 *
 * @author alfonso
 */
@Path("/test")
@Produces("application/json")
@Consumes("application/json")
@DenyAll
public class TestResource {

    @Inject
    @Claim(standard = Claims.groups)
    private Set<String> groups;

    @Inject
    @Claim(standard = Claims.upn)
    private String principal;


    @GET
    @Path("all")
    @PermitAll
    public String all() {
        return String.format("accesso consentito a tutti... pricipal: %s , gruppi: %s", principal, groups);
    }

    @GET
    @Path("admin")
    @RolesAllowed("admins")
    public String admin() {
        return String.format("accesso consentito ad admin... pricipal: %s , gruppi: %s", principal, groups);
    }


    @GET
    @Path("user")
    @RolesAllowed("users")
    public String user() {
        return String.format("accesso consentito a user... pricipal: %s , gruppi: %s", principal, groups);
    }
    
    
}
