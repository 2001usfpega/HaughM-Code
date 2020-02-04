package com.revature.bankapp;

import java.util.List;

public interface UserDAO {

    List<User> findAll();
    List<User> findById(int ... id);
    List<User> findByName(String ... names);
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);

}
