package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Speciality;
import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.model.ValueEntity;
import net.proselyte.springsecurityapp.service.SecurityService;
import net.proselyte.springsecurityapp.service.SpecialityService;
import net.proselyte.springsecurityapp.service.UserService;
import net.proselyte.springsecurityapp.validator.UserInfoValidator;
import net.proselyte.springsecurityapp.validator.UserResultValidator;
import net.proselyte.springsecurityapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserInfoValidator userInfoValidator;

    @Autowired
    private UserResultValidator userResultValidator;

    @Autowired
    private SpecialityService specialityService;

//////////////////////////////////////////////////////////////////////////////////////


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {

        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {

        return "admin";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String selectRoleForAdmin(Model model) {

        return "selectAdminRole";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String redirectToUserMode(Model model) {
        return "main";
    }

    @RequestMapping(value = "/goToRegistration", method = RequestMethod.GET)
    public String goToRegistration(ModelMap modelMap, @RequestParam("username") String username) {
        modelMap.addAttribute("newUserFirstRegistration", userService.findByUsername(username));
        return "secondRegistration";
    }

    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public String registeredFirst(@ModelAttribute("newUserFirstRegistration") User newUserFirstRegistration, BindingResult bindingResult, Model model) {

        userInfoValidator.validate(newUserFirstRegistration, bindingResult);
        if (bindingResult.hasErrors()) {
            return "secondRegistration";
        }
        userService.editUserInfo(newUserFirstRegistration.getUsername(), newUserFirstRegistration);
        model.addAttribute("newUserSecondRegistration", newUserFirstRegistration);
        return "lastRegistration";
    }

    @RequestMapping(value = "/registeredLast", method = RequestMethod.POST)
    public String registeredSecond(@ModelAttribute("newUserSecondRegistration") User newUserSecondRegistration, BindingResult bindingResult, Model model) {

        userResultValidator.validate(newUserSecondRegistration, bindingResult);
        if (bindingResult.hasErrors()) {
            return "lastRegistration";
        }
        userService.editUserResult(newUserSecondRegistration.getUsername(), newUserSecondRegistration);
        return "main";
    }

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public String goToRequestPage(ModelMap modelMap){
            modelMap.addAttribute("specialityValue", new ValueEntity());
            modelMap.addAttribute("specialities", specialityService.getAll());
        return "sendRequest";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(ModelMap modelMap, @RequestParam("username") String username,
                           @RequestParam("specialityValue") String specialityID){
        int ID = Integer.parseInt(specialityID);
        User user = userService.findByUsername(username);
        Speciality speciality = specialityService.findByID(ID);
        user.setSpeciality(speciality);
        userService.editUserInfo(username, user);
        return "main";
    }

}
