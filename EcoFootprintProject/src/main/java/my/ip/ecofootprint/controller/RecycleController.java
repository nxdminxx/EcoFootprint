package my.ip.ecofootprint.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.ip.ecofootprint.model.Recycle;
import my.ip.ecofootprint.service.RecycleService;

@Controller
@RequestMapping("/recycle")
public class RecycleController {

    @Autowired
    private RecycleService recycleService;

    @RequestMapping("/list")
    public String home(Model model) {
        List<Recycle> recycles = recycleService.getAllProducts();
        model.addAttribute("recycles", recycles);
        return "recycle/recycles";
    }

    @RequestMapping("/formAddRecycle")
    public String viewAddRecycleForm(Model model) {
        model.addAttribute("mode", "add");
        model.addAttribute("recycle", new Recycle());
        return "recycle/formRecycle";
    }

    @RequestMapping("/formEditRecycle")
    public String viewEditRecycleForm(@RequestParam String recycleId, Model model) {
        Recycle recycle = recycleService.getRecycleById(recycleId);
        model.addAttribute("recycle", recycle);
        model.addAttribute("mode", "edit");
        return "recycle/formRecycle";
    }

    @RequestMapping("/addRecycle")
    public String addRecycle(
            @RequestParam("recycleStartDate") Date recycleStartDate,
            @RequestParam("recycleEndDate") Date recycleEndDate,
            @RequestParam("recycleType") String recycleType,
            @RequestParam("recycleTotalInKG") String recycleTotalInKG,
            @RequestParam("recycleDescribeMethod") String recycleDescribeMethod,
            @RequestParam("recycleHabits") String[] recycleHabits,
            @RequestParam("recycelAccumulatedTotalInRM") String recycelAccumulatedTotalInRM,
            @RequestParam("recycleChallengePractice InRM") String recycleChallengePractice,
            @RequestParam("recycleProofrecycleProof InRM") byte[] recycleProof) {

        double recycleTotal = Double.parseDouble(recycleTotalInKG);
        double recycleAccumulated = Double.parseDouble(recycelAccumulatedTotalInRM);

        Recycle recycle = new Recycle(0, recycleStartDate, recycleEndDate, recycleType, recycleTotalInKG,
                recycleDescribeMethod, recycleHabits, recycelAccumulatedTotalInRM, recycleChallengePractice,
                recycleProof);

        recycleService.addRecycle(recycle);

        return "redirect:/recycle/list";
    }

    @RequestMapping("/editRecycle")
    public String editRecycle(
            @RequestParam int recycleId,
            @RequestParam("recycleStartDate") Date recycleStartDate,
            @RequestParam("recycleEndDate") Date recycleEndDate,
            @RequestParam("recycleType") String recycleType,
            @RequestParam("recycleTotalInKG") String recycleTotalInKG,
            @RequestParam("recycleDescribeMethod") String recycleDescribeMethod,
            @RequestParam("recycleHabits") String[] recycleHabits,
            @RequestParam("recycelAccumulatedTotalInRM") String recycelAccumulatedTotalInRM,
            @RequestParam("recycleChallengePractice InRM") String recycleChallengePractice,
            @RequestParam("recycleProofrecycleProof InRM") byte[] recycleProof) {
        double recycleTotal = Double.parseDouble(recycleTotalInKG);
        double recycleAccumulated = Double.parseDouble(recycelAccumulatedTotalInRM);

        Recycle recycle = new Recycle(recycleId, recycleStartDate, recycleEndDate, recycleType, recycleTotalInKG,
                recycleDescribeMethod, recycleHabits, recycelAccumulatedTotalInRM, recycleChallengePractice,
                recycleProof);

        recycleService.updateRecycle(recycle);

        return "redirect:/recycle/list";
    }

    @RequestMapping("/deleteRecycle")
    public String deleteRecycle(@RequestParam int recycleId, Model model) {
        boolean success = recycleService.deleteRecycle(recycleId);

        if (success) {
            return "redirect:/recycle/list";
        }

        model.addAttribute("errorMessage", "Deletion Failed!. The product doesn't exist");
        return "/recycle/error";
    }
}
