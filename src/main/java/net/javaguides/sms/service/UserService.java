// net.javaguides.sms.service.UserService.java
package net.javaguides.sms.service;

import net.javaguides.sms.entity.User;

public interface UserService {
    User authenticate(String username, String password);
    User saveUser(User user); // ✅ New method
}
