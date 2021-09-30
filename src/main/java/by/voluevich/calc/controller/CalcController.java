package by.voluevich.calc.controller;

import by.voluevich.calc.dto.MathOperationDTO;
import by.voluevich.calc.entity.MathOperation;
import by.voluevich.calc.entity.User;
import by.voluevich.calc.service.CalcService;
import by.voluevich.calc.service.OperationManager;
import by.voluevich.calc.utils.DTOConverter;
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
    private final OperationManager operationManager;

    public CalcController(CalcService calcService, OperationManager operationManager) {
        this.calcService = calcService;
        this.operationManager = operationManager;
    }

    @GetMapping
    public String calcForm(Model model){
        model.addAttribute("operations", operationManager.getNameOperations());
        model.addAttribute("mathOperation", new MathOperationDTO());
        return "calc";
    }

    @PostMapping
    public String calc(@Valid @ModelAttribute("mathOperation") MathOperationDTO mathOperationDTO, BindingResult bindingResult, Model model, HttpSession session){
        if(!bindingResult.hasErrors()) {
            MathOperation operation = DTOConverter.getMathOperationNumAndTypeOp(mathOperationDTO);
            User user = (User) session.getAttribute("user");
            MathOperation result = calcService.getResult(operation, user);
            model.addAttribute("result_operation", result);
            model.addAttribute("operations", operationManager.getNameOperations());
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
