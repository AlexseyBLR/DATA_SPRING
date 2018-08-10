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
    public void editUserInfo(String username, User newUser) {
        User userForUpdate = userDao.findUserByUsername(username);
        userForUpdate.setFirstname(newUser.getFirstname());
        userForUpdate.setLastname(newUser.getLastname());
        userForUpdate.setPatronymic(newUser.getPatronymic());
        userForUpdate.setAge(newUser.getAge());
        userForUpdate.setSex(newUser.getSex());
        userForUpdate.setSpeciality(newUser.getSpeciality());
        userDao.saveAndFlush(userForUpdate);
    }

    @Override
    public void editUserResult(String username, User newUser) {
        User userForUpdate = userDao.findUserByUsername(username);
        userForUpdate.setProfile(newUser.getProfile());
        userForUpdate.setCertResult(newUser.getCertResult());
        userForUpdate.setMathResult(newUser.getMathResult());
        userForUpdate.setPhysResult(newUser.getPhysResult());
        userForUpdate.setLangResult(newUser.getLangResult());
        userForUpdate.setHimResult(newUser.getHimResult());
        userForUpdate.setBiolResult(newUser.getBiolResult());
        userForUpdate.setEnglResult(newUser.getEnglResult());
        userDao.saveAndFlush(userForUpdate);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }



}
