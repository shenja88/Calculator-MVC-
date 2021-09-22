package by.voluevich.calc.controller;

import by.voluevich.calc.entity.MathOperation;
import by.voluevich.calc.entity.User;
import by.voluevich.calc.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/calc")
public class CalcController {
    private final CalcService calcService;

    @Autowired
    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping
    public String calcForm(){
        return "calc";
    }

    @PostMapping
    public String calc(MathOperation operation, Model model, HttpSession httpSession){
        operation.setUser((User) httpSession.getAttribute("user"));
        calcService.getResult(operation);
        model.addAttribute("result", operation.getResult());
        return "calc";
    }

    @GetMapping("/history")
    public String getHistory(Model model){
        List<MathOperation> mathOperationList = calcService.getMathOperationList();
        model.addAttribute("history_list", mathOperationList);
        return "history";
    }
}
