/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rests;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Mobile Apps
 */
@Path("/")
public class Rest {

    @GET
    @Produces("text/html")
    public String welcome() {
        return "<center><a href=\"http://localhost:8080/CDI_Injections/resources/users\"> Json</a> | <a href=\"http://localhost:8080/CDI_Injections/resources/userxml\">Xml</></center>";
    }
}
