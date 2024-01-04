package my.ip.ecofootprint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import my.ip.ecofootprint.service.WaterService;
import my.ip.ecofootprint.model.User;
import my.ip.ecofootprint.service.ElectricityService;
import my.ip.ecofootprint.service.RecycleService;

@Controller
public class DashboardController {
	 @Autowired
	 private WaterService waterService;

	 @Autowired
	 private ElectricityService electricityService;

	 @Autowired
	 private RecycleService recycleService;

	 @Autowired
	 private UserService userService;

	 @RequestMapping("/dashboard")
	 public String showDashboard(Model model, @RequestParam int userId) {
		 // Retrieve necessary data for the dashboard based on the user ID
	     int waterId = waterService.getWaterIdByUserId(userId);
	     int electricityId = electricityService.getElectricityIdByUserId(userId);
	     int recycleId = recycleService.getRecycleIdByUserId(userId);

	     // Retrieve necessary data for the dashboard
	     double waterCarbonResult = waterService.calculateWater(waterId);
	     double electricityCarbonResult = electricityService.calculateElectricity(electricityId);
	     double recycleCarbonResult = recycleService.calculateRecycle(recycleId);
	     double CarbonScore = calculateOverallCarbonScore(waterCarbonResult, electricityCarbonResult, recycleCarbonResult);

	     // Retrieve user details based on the role
	     User user = userService.getUserByUserId(userId);

	     if (user.getRole().equals("admin")) {
	    	 // Redirect to the admin dashboard
	         return "AdminDashboard";         
	     } else if (user.getRole().equals("participant")) {
	         // Continue with participant dashboard
	         handleParticipantDashboard(model, user, waterCarbonResult, electricityCarbonResult, recycleCarbonResult, CarbonScore);
	         return "UserDashboard";
	     } else if (user.getRole().equals("guest")) {
	    	 // Continue with guest dashboard
	    	 handleGuestDashboard(model, user);vf 
	         return "GuestDashboard";
	     } else {
	         // Handle other roles or show an error page
	    	 return "error";
	     }
	 }

	 private void handleParticipantDashboard(Model model, User user, double waterCarbonResult,
	                                         double electricityCarbonResult, double recycleCarbonResult, double CarbonScore) {
		 // Add user details to the model
	     model.addAttribute("userId", user.getId());
	     model.addAttribute("userName", user.getName());

	     // Add data to the model
	     model.addAttribute("waterCarbonResult", waterCarbonResult);
	     model.addAttribute("electricityCarbonResult", electricityCarbonResult);
	     model.addAttribute("recycleCarbonResult", recycleCarbonResult);
	     model.addAttribute("overallCarbonScore", CarbonScore);
	    }

	 private void handleGuestDashboard(Model model, User user) {
		 // Add user details to the model
	     model.addAttribute("userId", user.getId());
	     model.addAttribute("userName", user.getName());

	     // Add guest-specific data to the model
	     model.addAttribute("guestData", someGuestData);
	 }

	 private double calculateOverallCarbonScore(double waterCarbonResult, double electricityCarbonResult, double recycleCarbonResult) {
		 return (waterCarbonResult + electricityCarbonResult + recycleCarbonResult) / 3.0;
	 }
}