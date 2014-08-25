package com.xebia.assetManagement.controller;

import com.xebia.assetManagement.form.UserForm;
import com.xebia.assetManagement.model.Asset;
import com.xebia.assetManagement.model.User;
import com.xebia.assetManagement.service.AssetService;
import com.xebia.assetManagement.service.UserService;
import com.xebia.assetManagement.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by anirudh on 25/08/14.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/createuser", method = RequestMethod.GET)
    public String showCreateUserPage(Model model) {
        UserForm user = new UserForm();
        model.addAttribute("user", user);
        return "createUser";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") UserForm user,
                             BindingResult errors, Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("user");

        userValidator.validate(user, errors);

        System.out.println("***** CREATING USER ***** ");
        if (!errors.hasErrors()) {
            userService.createUser(populateUserFromForm(user));
            model.addAttribute("sucessmsg", "User was created Successfully");
            model.addAttribute("user", loggedInUser);
            return "home";
        } else {
            return "createUser";
        }
    }

    private User populateUserFromForm(UserForm user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setEmployeeId(user.getEmployeeId());
        newUser.setIsAdmin(user.getIsAdmin());
        newUser.setMobileNum(user.getMobileNum());
        return newUser;
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserDetails(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Asset> assets = assetService.getAllAssets(user);
        System.out.println("********* number of assets found for user " + user.getEmail() + " " + assets.size());
        model.addAttribute("assets", assets);
        return "viewUserAssets";
    }

}
