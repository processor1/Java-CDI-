package rests;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mobile Apps
 */

@javax.ws.rs.Path("/users")
public class UserJsonRest {
    
     public java.util.List<UserJson> getUsers() {

        UserJson us1 = new UserJson("kwame109", "hotjava22", "Admin");
        UserJson us2 = new UserJson("yellow_browb", "browncat", "Guest");
        UserJson us3 = new UserJson("Mimi", "mimihotred", "Guest");
        UserJson us4 = new UserJson("Mak100", "mak100gema", "Admin");
        UserJson us5 = new UserJson("Mipc", "pchotlinux", "User");

        java.util.List<UserJson> users = new java.util.ArrayList<>();
        users.add(us1);
        users.add(us2);
        users.add(us3);
        users.add(us4);
        users.add(us5);

        return users;
    }

    @GET
    @Produces("application/json")
    public Response users() {
        return Response.ok().entity(getUsers()).build();
    }
    
    
}
