package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.RoleDao;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Role;
import net.proselyte.springsecurityapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void editUserInfo(String username, User oldUser) {
        User userForUpdate = userDao.findUserByUsername(username);
        userForUpdate.setFirstname(oldUser.getFirstname());
        userForUpdate.setLastname(oldUser.getLastname());
        userForUpdate.setPatronymic(oldUser.getPatronymic());
        userForUpdate.setAge(oldUser.getAge());
        userForUpdate.setSex(oldUser.getSex());
        userDao.saveAndFlush(userForUpdate);
    }

    @Override
    public void editUserResult(String username, User oldUser) {
        User userForUpdate = userDao.findUserByUsername(username);
        userForUpdate.setProfile(oldUser.getProfile());
        userForUpdate.setCertResult(oldUser.getCertResult());
        userForUpdate.setMathResult(oldUser.getMathResult());
        userForUpdate.setPhysResult(oldUser.getPhysResult());
        userForUpdate.setLangResult(oldUser.getLangResult());
        userForUpdate.setHimResult(oldUser.getHimResult());
        userForUpdate.setBiolResult(oldUser.getBiolResult());
        userForUpdate.setEnglResult(oldUser.getEnglResult());
        userDao.saveAndFlush(userForUpdate);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }



}
