/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rests;

/**
 *
 * @author Mobile Apps
 */
public class UserJson {
     
    private String username;
    private String userpassword;
    private String role;

    public UserJson() {
    }

    public UserJson(String username, String userpassword, String role) {
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
