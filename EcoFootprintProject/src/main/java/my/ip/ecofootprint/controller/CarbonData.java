package my.ip.ecofootprint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarbonDataController {

    @GetMapping("/myCarbonData")
    public String showMyCarbonData(Model model) {
        // You can add any necessary data to the model
        return "myCarbonData";
    }

}
