package net.proselyte.springsecurityapp.controller;


import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap){

        modelMap.addAttribute("users", userService.getAll());

        return "userList";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUserByUsername(ModelMap modelMap, @RequestParam("selectedEntitySingleId") String username){
        System.out.println(username);
        userService.delete(userService.findByUsername(username));
        getUsers(modelMap);
        return "userList";
    }

}
