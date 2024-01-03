package my.ip.ecofootprint.controller;

package my.utm.ip.springmvcmaven.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.ip.ecofootprint.model.Electricity;
import my.utm.ip.springmvcmaven.models.product.Product;
import my.utm.ip.springmvcmaven.services.product.ProductService;

@Controller
@RequestMapping("/electricity")

public class ElectricityController {

    @Autowired
    private electricityService elecricityService;

    @RequestMapping("/form")

    public String Electricity(Model model) {

        List<Electricity> electricity = elecricityService.getAllProducts();
        model.addAttribute("electricity", electricity);

        return "electricity/electricity";

    }

    @RequestMapping("/formAddElectricity")

    public String viewAddElectricityForm(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("electricity", new Electricity());
        return "electricity/formElectricity";

    }

    @RequestMapping("/formEditProduct")

    public String viewEditProductForm(@RequestParam String id, Model model) {
        Electricity electricity = electricityService.getProductById(id);
        model.addAttribute("electricity", electricity);
        model.addAttribute("mode", "edit");
        return "electricity/formElectricity";

    }

    @RequestMapping("/addElectricity")

    public String addElectricity(
            @RequestParam("electricityNumOfDays") String electricityNumOfDays,
            @RequestParam("electricityUsageRM") String electricityUsageRM,
            @RequestParam("electricityUsageKWH") String electricityUsageKWH,
            @RequestParam("electricityMethods") String electricityMethods,
    		@RequestParam("electricityPractices") String electricityPractices,
			@RequestParam("electricityMonth") String electricityMonth,
			@RequestParam("electricityPropFactor") String electricityPropFactor,
			@RequestParam("electricityBill") String electricityBill)
    
    {
    	int electricityNumOfDays = Integer.parseInt(electricityNumOfDays);
    	double electricityUsageRM = Double.parseDouble(electricityUsageRM);
    	double electricityUsageKWH = Double.parseDouble(electricityUsageKWH);
    	long electricityPropFactor = Long.parseLong(electricityPropFactor);
    	byte electricityBill = Byte.parseByte(electricityBill);
    	
        Electricity electricity = new Electricity("",electricityNumOfDays, electricityUsageRM, electricityUsageKWH,electricityMethods, electricityPractices, electricityMonth, electricityPropFactor, electricityBill);
   
        electricityService.addElectricity(elecrticity);

        return "redirect:/product/list";
    }

    @RequestMapping("/editElectricity")

    public String editElectricity(
            @RequestParam String electricityId,
            @RequestParam String electrictyNumOfDays,
            @RequestParam String electricityUsageRM,
            @RequestParam String electricityUsageKWH,
            @RequestParam String electricityMethods,
            @RequestParam String electricityPractices,
            @RequestParam String electricityMonth,
            @RequestParam String electricityPropFactor,
            @RequestParam String electricityBill
            
            ) {
    	int electricityId = Integer.parseInt(electricityId);
    	int electricityNumOfDays = Integer.parseInt(electricityNumOfDays);
    	double electricityUsageRM = Double.parseDouble(electricityUsageRM);
    	double electricityUsageKWH = Double.parseDouble(electricityUsageKWH);
    	long electricityPropFactor = Long.parseLong(electricityPropFactor);
    	byte electricityBill = Byte.parseByte(electricityBill);
    	
    	Electricity electricity = new Electricity("",electricityNumOfDays, electricityUsageRM, electricityUsageKWH,electricityMethods, electricityPractices, electricityMonth, electricityPropFactor, electricityBill);
        electricityService.updateService(electricity);

        return "redirect:/product/list";
    }

    @RequestMapping("/deleteElectricity")

    public String deleteProduct(@RequestParam String electricityId, Model model) {

        boolean success = electricityService.deleteElectricity(electricityId);

        if (success) {

            return "redirect:/product/list";
        }

        model.addAttribute("errorMessage", "Deletion Failed!. The product doesn't exist");
        return "/electricity/error";

    }

}