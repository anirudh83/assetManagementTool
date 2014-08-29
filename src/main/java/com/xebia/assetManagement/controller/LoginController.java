package com.xebia.assetManagement.controller;

import com.xebia.assetManagement.model.User;
import com.xebia.assetManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * Created by anirudh on 22/08/14.
 */

@Controller
@RequestMapping
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public String loginUser(@RequestParam("emailAddress") String email,
                            @RequestParam("password") String password,Model model,HttpSession session){

        User persistedUser = userService.getUserByEmail(email);
        if(persistedUser!=null && persistedUser.getPassword().equals(password)){
            session.setAttribute("user", persistedUser);
            return "home";
        }else{
            model.addAttribute("error", "Incorrect username or password, Please try again!");
            LOGGER.info("**** USER NOT LOGGED IN ***");
            return "login";
        }

    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logoutUser(HttpSession session){
        if(session.getAttribute("user")!=null){
            session.invalidate();
        }
        return "index";
    }

    @RequestMapping(value="/showlogin",method=RequestMethod.GET)
    public String showloginPage(){
        return "login";
    }

    @RequestMapping(value="/showContact", method=RequestMethod.GET)
    public String showContactPage(){
        return "contact";
    }
}
