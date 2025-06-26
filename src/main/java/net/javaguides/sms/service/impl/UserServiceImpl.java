// net.javaguides.sms.service.impl.UserServiceImpl.java
package net.javaguides.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.sms.entity.User;
import net.javaguides.sms.repository.UserRepository;
import net.javaguides.sms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
 // net.javaguides.sms.service.impl.UserServiceImpl.java
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
