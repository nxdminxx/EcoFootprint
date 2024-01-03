package my.ip.ecofootprint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import my.ip.ecofootprint.model.Water;
import my.ip.ecofootprint.service.WaterService;

@Controller
@RequestMapping("/waterForm")
public class WaterController {

    @Autowired
    private WaterService waterService;
    
    pprivate static AtomicInteger waterIdCounter = new AtomicInteger(1);
    
    @RequestMapping("/listWater")
    public String listWater(Model model) {
    	
        List<Water> waterList = waterService.getAllWater();
        model.addAttribute("waterList", waterList);
        
        return "water/water";
    }

    @RequestMapping("/formAddWater")
    public String viewAddWaterForm(Model model) {
    	
        model.addAttribute("mode", "add");
        model.addAttribute("water", new Water(0, 0, 0, 0, null, null, null, 0, null));
        
        return "water/formWater";
    }

    @RequestMapping("/formEditWater")
    public String viewEditForm(@RequestParam int WaterId, Model model) {
        Water water = waterService.getWaterById(WaterId);
        model.addAttribute("water", water);
        model.addAttribute("mode", "edit");
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

            // Generate a unique water ID
            int waterId = waterIdCounter.getAndIncrement();

            // Create Water object
            Water water = new Water(waterId, WaterNumOfDaysData, WaterUsageRMData, WaterUsageM3Data, WaterMethods, WaterPractices, WaterMonth, WaterPropFactorData, WaterBillData);

            // Add water data
            waterService.addWater(water);

            // Redirect to the list page
            return "redirect:/MyCarbonData/list";
        } catch (NumberFormatException e) {
            // Handle invalid number format
            // You might want to redirect to an error page or show a validation message to the user
            return "/water/error";
        }
    }

    @RequestMapping("/editWater")
    public String editWater(
            @RequestParam int waterId,
            @RequestParam String numOfDays,
            @RequestParam String usageRM,
            @RequestParam String usageM3,
            @RequestParam String methods,
            @RequestParam String practices,
            @RequestParam String month,
            @RequestParam String propFactor,
            @RequestParam String bill) {

        // Retrieve the current Water object from the service
        Water existingWater = waterService.getWaterById(waterId);

        // Update the fields with the new values
        existingWater.setWaterNumOfDays(Integer.parseInt(numOfDays));
        existingWater.setWaterUsageRM(Double.parseDouble(usageRM));
        existingWater.setWaterUsageM3(Double.parseDouble(usageM3));
        existingWater.setWaterMethods(methods);
        existingWater.setWaterPractices(practices);
        existingWater.setWaterMonth(month);
        existingWater.setWaterPropFactor(Long.parseLong(propFactor));
        existingWater.setWaterBill(bill.getBytes());

        // Update the Water object in the service
        waterService.updateWater(existingWater);

        return "redirect:/MyCarbonData/list";
    }

    @RequestMapping("/deleteWater")
    public String deleteWater(@RequestParam int waterId, Model model) {
    	
        boolean success = waterService.deleteWater(waterId);

        if (success) {
            return "redirect:/MyCarbonData/list";
        }

        model.addAttribute("errorMessage", "Deletion Failed! The data doesn't exist");
        return "/water/error";
    }

    private int createWaterId() {
        // Incrementing the counter to get a unique ID
        return waterIdCounter.getAndIncrement();
    }
}
