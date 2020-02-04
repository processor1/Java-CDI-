/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rests;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mobile Apps
 */


@XmlRootElement
public class UserXML implements java.io.Serializable{
    
    private String username;
    private String userpassword;
    private String role;

    public UserXML() {
    }

    public UserXML(String username, String userpassword, String role) {
        this.username = username;
        this.userpassword = userpassword;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
}
