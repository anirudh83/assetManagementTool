package com.xebia.assetManagement.controller;

import com.xebia.assetManagement.model.Asset;
import com.xebia.assetManagement.model.User;
import com.xebia.assetManagement.service.AssetService;
import com.xebia.assetManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by anirudh on 22/08/14.
 */

@Controller
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateAssetPage(Model model) {
        model.addAttribute("asset",new Asset());
        return "createAsset";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String createAsset(@ModelAttribute("asset") Asset asset, BindingResult errors,
                              Model model,@RequestParam(value="userId",required=false)String userId,HttpSession session) {
        Long userIdInt = Long.valueOf(userId);
        User user = (User)session.getAttribute("user");
        User assignedUser = userService.getUserById(userIdInt);
        if(userIdInt==0){
            assignedUser=user;
        }
        asset.setAssignedTo(assignedUser);
        if (!errors.hasErrors()) {
            assetService.createAsset(asset);
            model.addAttribute("sucessmsg", "Asset was created and assigned Successfully");
            return "home";
        } else {
            return "createAsset";
        }
    }

    @ModelAttribute
    public void populateUsers(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
    }


}
