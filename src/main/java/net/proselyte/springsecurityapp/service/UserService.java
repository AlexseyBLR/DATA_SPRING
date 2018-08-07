package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.User;

import java.util.List;


public interface UserService {

    void save(User user);
    User findByUsername(String username);
    void delete(User user);
    void editUserInfo(String username, User user);
    void editUserResult(String username, User user);
    List<User> getAll();
}
