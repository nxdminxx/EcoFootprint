package my.utm.ip.ecofootprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import my.utm.ip.ecofootprint.model.Electricity;
import my.utm.ip.ecofootprint.Service.ElectricityService;



@Controller
@RequestMapping("/electricityForm")

public class ElectricityController {

    @Autowired
    private ElectricityService electricityService;

    @RequestMapping("/listElectricity")

    public String Electricity(Model model) {

        List<Electricity> electricityList = electricityService.getAllElectricity();
        model.addAttribute("electricityList", electricityList);

        return "electricity/electricity";

    }

    @RequestMapping("/formAddElectricity")

    public String viewAddElectricityForm(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("electricity", new Electricity(0, 0, 0, 0, null, null, null, 0, null, 0));
        return "electricity/formElectricity";

    }

    @RequestMapping("/addElectricity")

    public String addElectricity(
            @RequestParam("electricityNumOfDays") String ElectricityNumOfDays,
            @RequestParam("electricityUsageRM") String ElectricityUsageRM,
            @RequestParam("electricityUsageKWH") String ElectricityUsageKWH,
            @RequestParam("electricityMethods") String ElectricityMethods,
    		@RequestParam("electricityPractices") String ElectricityPractices,
			@RequestParam("electricityMonth") String ElectricityMonth,
			@RequestParam("electricityPropFactor") String ElectricityPropFactor,
			@RequestParam("electricityBill") String ElectricityBill)
    
    {
    try {
    	int ElectricityNumOfDaysData = Integer.parseInt(ElectricityNumOfDays);
    	double ElectricityUsageRMData = Double.parseDouble(ElectricityUsageRM);
    	double ElectricityUsageKWHData = Double.parseDouble(ElectricityUsageKWH);
    	long ElectricityPropFactorData = Long.parseLong(ElectricityPropFactor);
    	byte[] ElectricityBillData = ElectricityBill.getBytes();
    	
    	
        Electricity electricity = new Electricity (0,ElectricityNumOfDaysData, ElectricityUsageRMData, ElectricityUsageKWHData,ElectricityMethods, ElectricityPractices, ElectricityMonth, ElectricityPropFactorData, ElectricityBillData, 0);
   
        electricityService.addElectricity(electricity);

        return "redirect:/MyCarbonData";
    }catch(NumberFormatException e) {
    	return "/water/error";
    }
    	
    }

//    @RequestMapping("/editElectricity")
//
//    public String editElectricity(
//            @RequestParam String electricityId,
//            @RequestParam String electrictyNumOfDays,
//            @RequestParam String electricityUsageRM,
//            @RequestParam String electricityUsageKWH,
//            @RequestParam String electricityMethods,
//            @RequestParam String electricityPractices,
//            @RequestParam String electricityMonth,
//            @RequestParam String electricityPropFactor,
//            @RequestParam String electricityBill
//            
//            ) {
//    	int electricityId = Integer.parseInt(electricityId);
//    	int electricityNumOfDays = Integer.parseInt(electricityNumOfDays);
//    	double electricityUsageRM = Double.parseDouble(electricityUsageRM);
//    	double electricityUsageKWH = Double.parseDouble(electricityUsageKWH);
//    	long electricityPropFactor = Long.parseLong(electricityPropFactor);
//    	byte electricityBill = Byte.parseByte(electricityBill);
//    	
//    	Electricity electricity = new Electricity("",electricityNumOfDays, electricityUsageRM, electricityUsageKWH,electricityMethods, electricityPractices, electricityMonth, electricityPropFactor, electricityBill);
//        electricityService.updateService(electricity);
//
//        return "redirect:/product/list";
//    }
    
    @RequestMapping("/viewElectricityDetail")
    public String viewWaterDetail(@RequestParam int electricityId, Model model) {
        Electricity electricity = electricityService.getElectricityById(electricityId);

        if (electricity != null) {
            double carbonResult = electricityService.calculateElectricity(electricityId);  //electricity.getCarbonResult() piwitttt
            model.addAttribute("electricity", electricity);
            model.addAttribute("carbonResult", carbonResult);

            return "electricity/viewElectricityDetail"; 
        } else {
            // if waterId not found
            model.addAttribute("errorMessage", "Electricity data not found");
            return "/error"; 
        }
    }

    @RequestMapping("/deleteElectricity")

    public String deleteProduct(@RequestParam int electricityId, Model model) {

        boolean success = electricityService.deleteElectricity(electricityId);

        if (success) {

            return "redirect:/MyCarbonData";
        }

        model.addAttribute("errorMessage", "Deletion Failed!. The data doesn't exist");
        return "/electricity/error";

    }
    
    @RequestMapping("/calculateElectricityCarbonFootprint")
    public String calculateElectricityCarbonFootprint(@RequestParam int electricityId, Model model) {
        double electricityCarbonFootprint = electricityService.calculateElectricity(electricityId); //calculateElectricity
        model.addAttribute("waterCarbonFootprint", electricityCarbonFootprint);

        return "electricity/calculateResult";
    }

}
