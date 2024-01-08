package my.ip.ecofootprint.controller;

@Controller
public class FootprintController {
	
	@GetMapping("/footprintForm")
    public String showFootprintForm(Model model) {
        // You can add any necessary data to the model
        return "footprintForm";
    }
}
