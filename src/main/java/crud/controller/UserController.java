package crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @GetMapping(value = "/")
    public String start(){
        return "index";
    }

    @GetMapping(value = "/users")
    public String viewAllUsers(ModelMap modelMap){
        return "user";
    }
}
