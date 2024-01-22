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
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/submit")
    public String registerUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            @RequestParam("email") String email,
            @RequestParam("idCard") String idCard,
            @RequestParam("name") String name,
            @RequestParam("contact") String contact,
            @RequestParam("status") String status,
            @RequestParam("address") String address,
            @RequestParam("category") String category,
            Model model) {

        // Assuming you have a method in UserService to check if the username is already taken
        if (userService.isUsernameTaken(username)) {
            model.addAttribute("errorMessage", "Username already taken. Please choose another.");
            return "registerForm"; // Redirect to the registration form with an error message
        }

        // Assuming you have additional validation logic based on your requirements

        User newUser = new User(0, username, password, role, email, idCard, name, contact, status, address, category, 0, 0, 0);
        userService.addUser(newUser);

        return "login"; // Redirect to the login page after successful registration
    }
}
