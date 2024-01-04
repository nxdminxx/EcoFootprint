package my.ip.ecofootprint.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.ip.ecofootprint.model.User;
import my.ip.ecofootprint.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/form")
    public String loginForm() {
        return "login/login";
    }

    @RequestMapping("/authenticate")
    public String authenticate(@RequestParam int userId, @RequestParam String password, Model model) {
        User user = userService.getUserById(userId);

        if (user != null && user.getPassword().equals(password)) {
            // Authentication successful
            model.addAttribute("user", user);
            return "redirect:" + user.redirectToDashboard();
        } else {
            // Authentication failed
            model.addAttribute("errorMessage", "Invalid userId or password");
            return "login/login";
        }
    }
}
