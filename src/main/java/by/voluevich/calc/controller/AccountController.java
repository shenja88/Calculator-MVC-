package by.voluevich.calc.controller;

import by.voluevich.calc.entity.User;
import by.voluevich.calc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {
    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String regForms() {
        return "registration";
    }

    @PostMapping("/reg")
    public String getReg(User user, Model model) {
        if (userService.saveUser(user)) {
            model.addAttribute("message_reg", "Registration successful!");
        } else {
            model.addAttribute("message_reg", "Registration failed!");
        }
        return "main";
    }

    @GetMapping("/signIn")
    public String signInForm() {
        return "sign_in";
    }

    @PostMapping("/signIn")
    public String getSignIn(User user, Model model, HttpSession httpSession) {
        if (userService.isExistUser(user)) {
            User userForSession = userService.getByLogin(user.getLogin());
            model.addAttribute("message_auth", "Successful authorization!");
            httpSession.setAttribute("user", userForSession);
        } else {
            model.addAttribute("message_auth", "Authorization failed!");
        }
        return "main";
    }

    @GetMapping("/updateName")
    public String updateNameForm() {
        return "update_name";
    }

    @PostMapping("/updateName")
    public String updateName(String newName, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (userService.updateName(newName, user)) {
            model.addAttribute("message_upd_name", "Successful operation!");
        } else {
            model.addAttribute("message_upd_name", "Operation failed!");
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
            model.addAttribute("message_upd_pass", "Successful operation!");
        }else{
            model.addAttribute("message_upd_pass", "Operation failed!");
        }
        return "update_pass";
    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/main";
    }
}
