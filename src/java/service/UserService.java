/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.User;
import daos.UserDao;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Mobile Apps
 */
public class UserService {

    @Inject
    UserDao dao;

    public List<User> users() {
        return dao.getUsers();
    }
}
