/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import java.util.ArrayList;
import beans.User;

/**
 *
 * @author Mobile Apps
 */
public class UserDao {

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        User us1 = new User("kwame109", "hotjava22", "Admin");
        User us2 = new User("yellow_browb", "browncat", "Guest");
        User us3 = new User("Mimi", "mimihotred", "Guest");
        User us4 = new User("Mak100", "mak100gema", "Admin");
        User us = new User("Mipc", "pchotlinux", "User");

        users.add(us1);
        users.add(us2);
        users.add(us3);
        users.add(us4);
        users.add(us);

        return users;
    }
}
