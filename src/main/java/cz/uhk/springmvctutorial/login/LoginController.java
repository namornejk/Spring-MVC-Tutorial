package cz.uhk.springmvctutorial.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@RequestParam String name, @RequestParam String password, ModelMap model){
        if(loginService.validateUser(name,password)){
            model.addAttribute("name", name);
            return "welcome";
        } else {
            model.addAttribute("errorMessage", "Invalid Credentials!!");
            return "login";
        }


    }
}
