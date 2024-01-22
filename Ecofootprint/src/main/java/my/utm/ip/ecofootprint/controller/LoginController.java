package my.utm.ip.ecofootprint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.utm.ip.ecofootprint.Service.UserService;
import my.utm.ip.ecofootprint.model.User;
import my.utm.ip.ecofootprint.model.DAO.UserDAO;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        return "login";
    }
    
    @RequestMapping("/login")
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
