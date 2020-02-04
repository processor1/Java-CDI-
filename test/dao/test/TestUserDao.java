/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.test;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Mobile Apps
 */
public class TestUserDao {

    daos.UserDao dao = new daos.UserDao();

    @Test
    public boolean testUser() {
        assertEquals(dao.getUsers().size(), 5);
        if (dao.getUsers().size() == 5) {
            return true;
        }

        return false;
    }
}
