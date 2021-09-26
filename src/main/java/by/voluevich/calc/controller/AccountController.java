package by.voluevich.calc.controller;

import by.voluevich.calc.entity.User;
import by.voluevich.calc.service.UserService;
import by.voluevich.calc.utils.ControllerMessageManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {
    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String regForms(Model model) {
        model.addAttribute("newUser", new User());
        return "registration";
    }

    @PostMapping("/reg")
    public String getReg(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, Model model) {
        if(!bindingResult.hasErrors()){
            if (userService.saveUser(user)) {
                model.addAttribute("message_reg", ControllerMessageManager.REG_DONE);
                return "registration";
            }else {
                model.addAttribute("message_reg", ControllerMessageManager.REG_FAIL);
            }
        }

        return "registration";
    }

    @GetMapping("/signIn")
    public String signInForm(Model model) {
        model.addAttribute("newUser", new User());
        return "sign_in";
    }

    @PostMapping("/signIn")
    public String getSignIn(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, Model model, HttpSession session) {
        if(!bindingResult.hasErrors()) {
            if (userService.signIn(user)) {
                User userForSession = userService.getByLogin(user.getEmail());
                model.addAttribute("message_auth", ControllerMessageManager.AUTH_DONE);
                session.setAttribute("user", userForSession);
                return "sign_in";
            } else {
                model.addAttribute("message_auth", ControllerMessageManager.AUTH_FAIL);
            }
        }
        return "sign_in";
    }

    @GetMapping("/updateName")
    public String updateNameForm() {
        return "update_name";
    }

    @PostMapping("/updateName")
    public String updateName(String newName, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (userService.updateName(newName, user)) {
            model.addAttribute("message_upd_name", ControllerMessageManager.OPERATION_DONE);
        } else {
            model.addAttribute("message_upd_name", ControllerMessageManager.OPERATION_FAIL);
        }
        return "update_name";
    }

    @GetMapping("/updatePass")
    public String updatePassForm() {
        return "update_pass";
    }

    @PostMapping("/updatePass")
    public String updatePass(String oldPass, String newPass, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(userService.updatePass(oldPass, newPass, user)){
            model.addAttribute("message_upd_pass", ControllerMessageManager.OPERATION_DONE);
        }else{
            model.addAttribute("message_upd_pass", ControllerMessageManager.OPERATION_FAIL);
        }
        return "update_pass";
    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/main";
    }
}
