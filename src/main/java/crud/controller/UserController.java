package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String start(){
        return "index";
    }

    @GetMapping(value = "/users")
    public String viewAllUsers(ModelMap modelMap){
        List<User>userList= userService.listUsers();
        modelMap.addAttribute("user",userList);
        return "users";
    }

    @GetMapping(value = "/new")
    public String newUser() {
        return "new";
    }

    @PostMapping(value = "/new")
    public String addUser(@RequestParam("name")String name, @RequestParam("age") int age) {
        User user = new User(name,age);
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(@PathVariable("id") int id, ModelMap modelMap) {
        User user = userService.getById(id);
        modelMap.addAttribute("user",user);
        return "update";
    }

    @PostMapping(value = "/edit")
    public String updateUser(@RequestParam("id") int id,
                             @RequestParam("name")String name,
                             @RequestParam("age") int age) {
        User user = new User(name,age);
        user.setId(id);
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id")int id){
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/users";
    }
}
