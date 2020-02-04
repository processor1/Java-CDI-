/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rests;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 *
 * @author Mobile Apps
 */
@javax.ws.rs.Path("/userxml")
public class UserXmlRest {

    public java.util.List<UserXML> getUsers() {

        UserXML us1 = new UserXML("kwame109", "hotjava22", "Admin");
        UserXML us2 = new UserXML("yellow_browb", "browncat", "Guest");
        UserXML us3 = new UserXML("Mimi", "mimihotred", "Guest");
        UserXML us4 = new UserXML("Mak100", "mak100gema", "Admin");
        UserXML us5 = new UserXML("Mipc", "pchotlinux", "User");

        java.util.List<UserXML> users = new java.util.ArrayList<>();
        users.add(us1);
        users.add(us2);
        users.add(us3);
        users.add(us4);
        users.add(us5);
        
        return users;
    }

    
    @GET
    @Produces("application/xml")
    public java.util.List<UserXML> users(){
        return getUsers();
    }
}
