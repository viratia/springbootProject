// net.javaguides.sms.controller.LoginController.java
package net.javaguides.sms.controller;

import jakarta.servlet.http.HttpSession;
import net.javaguides.sms.entity.User;
import net.javaguides.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//net.javaguides.sms.controller.LoginController.java
@Controller
public class LoginController {

 private final UserService userService;

 public LoginController(UserService userService) {
     this.userService = userService;
 }

 // ✅ Show homepage
 @GetMapping("/")
 public String showHomePage() {
     return "home";
 }

 // ✅ Show login form
 @GetMapping("/login")
 public String showLoginPage(Model model) {
     model.addAttribute("user", new User());
     return "login";
 }

 // ✅ Perform login
 @PostMapping("/login")
 public String login(@ModelAttribute("user") User user, HttpSession session, Model model) {
     User authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());
     if (authenticatedUser != null) {
         session.setAttribute("loggedInUser", authenticatedUser);
         return "redirect:/students";
     } else {
         model.addAttribute("error", "Invalid credentials");
         return "login";
     }
 }

 @GetMapping("/logout")
 public String logout(HttpSession session) {
     session.invalidate();
     return "redirect:/";
 }

 @GetMapping("/signup")
 public String showSignupForm(Model model) {
     model.addAttribute("user", new User());
     return "signup";
 }

 @PostMapping("/signup")
 public String registerUser(@ModelAttribute("user") User user, Model model) {
     if (userService.authenticate(user.getUsername(), user.getPassword()) != null) {
         model.addAttribute("error", "Username already exists");
         return "signup";
     }
     userService.saveUser(user);
     return "redirect:/login?signupSuccess";
 }
}
