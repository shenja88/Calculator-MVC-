package by.voluevich.calc.controller;

import by.voluevich.calc.entity.MathOperation;
import by.voluevich.calc.entity.User;
import by.voluevich.calc.service.CalcService;
import by.voluevich.calc.service.OperationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/calc")
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping
    public String calcForm(Model model){
        model.addAttribute("operations", OperationManager.getNameOperations());
        model.addAttribute("mathOperation", new MathOperation());
        return "calc";
    }

    @PostMapping
    public String calc(@Valid @ModelAttribute("mathOperation") MathOperation operation, BindingResult bindingResult, Model model, HttpSession session){
        if(!bindingResult.hasErrors()) {
            User user = (User) session.getAttribute("user");
            MathOperation mathOperation = calcService.getResult(operation, user);
            model.addAttribute("result_operation", mathOperation);
            model.addAttribute("operations", OperationManager.getNameOperations());
        }
        return "calc";
    }

    @GetMapping("/history")
    public String getHistory(Model model, HttpSession httpSession){
        User user  = (User) httpSession.getAttribute("user");
        List<MathOperation> mathOperationList = calcService.getHistory(user);
        model.addAttribute("history_list", mathOperationList);
        return "history";
    }
}
