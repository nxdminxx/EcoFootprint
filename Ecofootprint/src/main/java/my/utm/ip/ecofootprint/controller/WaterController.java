package my.utm.ip.ecofootprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.utm.ip.ecofootprint.Service.WaterService;
import my.utm.ip.ecofootprint.model.Water;
import my.utm.ip.ecofootprint.model.DAO.WaterDAO;

@Controller
@RequestMapping("/waterForm")
public class WaterController {

    @Autowired
    private WaterService waterService;
    
    @RequestMapping("/listWater")
    public String listWater(Model model) {
    	
        List<Water> waterList = waterService.getAllWater();
        model.addAttribute("waterList", waterList);
        
        return "water/water";
    }

    @RequestMapping("/formAddWater")
    public String viewAddWaterForm(Model model) {
    	
        model.addAttribute("mode", "add");
        model.addAttribute("water", new Water(0, 0, 0, 0, null, null, null, 0, null,0));
        
        return "water/formWater";
    }

    @RequestMapping("/addWater")
    public String addWater(
            @RequestParam("waterNumOfDays") String WaterNumOfDays,
            @RequestParam("waterUsageRM") String WaterUsageRM,
            @RequestParam("waterUsageM3") String WaterUsageM3,
            @RequestParam("waterMethods") String WaterMethods,
            @RequestParam("waterPractices") String WaterPractices,
            @RequestParam("waterMonth") String WaterMonth,
            @RequestParam("waterPropFactor") String WaterPropFactor,
            @RequestParam("waterBill") String WaterBill) {

        try {
            // Convert user input to appropriate data types
            int WaterNumOfDaysData = Integer.parseInt(WaterNumOfDays);
            double WaterUsageRMData = Double.parseDouble(WaterUsageRM);
            double WaterUsageM3Data = Double.parseDouble(WaterUsageM3);
            long WaterPropFactorData = Long.parseLong(WaterPropFactor);
            byte[] WaterBillData = WaterBill.getBytes();

            // Create Water object
            Water water = new Water(0, WaterNumOfDaysData, WaterUsageRMData, WaterUsageM3Data, WaterMethods, WaterPractices, WaterMonth, WaterPropFactorData, WaterBillData, 0);

            // Add water data
            waterService.addWater(water);

            // Redirect to the list page
            return "redirect:/MyCarbonData";
        } catch (NumberFormatException e) {
            // Handle invalid number format
            // You might want to redirect to an error page or show a validation message to the user
            return "/water/error";
        }
    }
    
    	//user cannot edit or update the data   
//    @RequestMapping("/formEditWater")
//    public String viewEditForm(@RequestParam int WaterId, Model model) {
//        Water water = waterService.getWaterById(WaterId);
//        model.addAttribute("water", water);
//        model.addAttribute("mode", "edit");
//        return "water/editWater";
//    }
//
//    @RequestMapping("/editWater")
//    public String editWater(
//            @RequestParam int waterId,
//            @RequestParam String numOfDays,
//            @RequestParam String usageRM,
//            @RequestParam String usageM3,
//            @RequestParam String methods,
//            @RequestParam String practices,
//            @RequestParam String month,
//            @RequestParam String propFactor,
//            @RequestParam String bill) {
//
//        // Retrieve the current Water object from the service
//        Water existingWater = waterService.getWaterById(waterId);
//
//        // Update the fields with the new values
//        existingWater.setWaterNumOfDays(Integer.parseInt(numOfDays));
//        existingWater.setWaterUsageRM(Double.parseDouble(usageRM));
//        existingWater.setWaterUsageM3(Double.parseDouble(usageM3));
//        existingWater.setWaterMethods(methods);
//        existingWater.setWaterPractices(practices);
//        existingWater.setWaterMonth(month);
//        existingWater.setWaterPropFactor(Long.parseLong(propFactor));
//        existingWater.setWaterBill(bill.getBytes());
//
//        // Update the Water object in the service
//        waterService.updateWater(existingWater);
//
//        return "redirect:/MyCarbonData/list";
//    }

    @RequestMapping("/viewWaterDetail")
    public String viewWaterDetail(@RequestParam int waterId, Model model) {
        Water water = waterService.getWaterById(waterId);

        if (water != null) {
            // Retrieve carbon result without recalculating
            double carbonResult = water.getCarbonResult();

            model.addAttribute("water", water);
            model.addAttribute("carbonResult", carbonResult);

            return "water/viewWaterDetail";
        } else {
            // if waterId not found
            model.addAttribute("errorMessage", "Water data not found");
            return "/error";
        }
    }
    
    @RequestMapping("/deleteWater")
    public String deleteWater(@RequestParam int waterId, Model model) {
        try {
            boolean success = waterService.deleteWater(waterId);

            if (success) {
                return "redirect:/MyCarbonData/list";
            } else {
                model.addAttribute("errorMessage", "Deletion Failed! The data doesn't exist");
                return "/water/error";
            }
        } catch (Exception e) {
            return "/water/error";
        }
    }
    
    @RequestMapping("/calculateWaterCarbonFootprint")
    public String calculateWaterCarbonFootprint(@RequestParam int waterId, Model model) {
        double waterCarbonFootprint = waterService.calculateWater(waterId);
        model.addAttribute("waterCarbonFootprint", waterCarbonFootprint);

        return "water/calculateResult";
    }
}
