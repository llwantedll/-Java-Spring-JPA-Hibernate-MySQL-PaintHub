package com.llwantedll.service;

import com.llwantedll.dao.RoleDAO;
import com.llwantedll.dao.UserDAO;
import com.llwantedll.model.entities.Role;
import com.llwantedll.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(2L));
        user.setRoles(roles);
        setDefaultAvatarIfNull(user);
        userDAO.save(user);
    }


    //SETS DEFAULT AVATAR IF USER DIDN'T UPLOAD HIS AVATAR
    private void setDefaultAvatarIfNull(User user) {
        if(user.getAvatar().length == 0) {
            ClassLoader classLoader = getClass().getClassLoader();
            URL url = classLoader.getResource("images/noavatar.png");
            File file;
            if (url != null) {
                file = new File(url.getFile());
                try {
                    user.setAvatar(Files.readAllBytes(file.toPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Default avatar set error");
                }
            }
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

    public User getUser(Long id){
        return userDAO.getOne(id);
    }

    public void deleteUser(Long id){
        userDAO.deleteById(id);
    }

    public User getUserByLogin(String login){
        return userDAO.findByLogin(login);
    }

}
