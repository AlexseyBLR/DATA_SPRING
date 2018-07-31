package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.User;

import java.util.List;

/**
 * Service class for {@link net.proselyte.springsecurityapp.model.User}
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public interface UserService {

    void save(User user);
    User findByUsername(String username);
    void delete(User user);
    void editUserInfo(String username, User user);
    void editUserResult(String username, User user);
    List<User> getAll();
}
