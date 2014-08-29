package com.xebia.assetManagement.controller;

import com.xebia.assetManagement.model.Asset;
import com.xebia.assetManagement.model.User;
import com.xebia.assetManagement.service.AssetService;
import com.xebia.assetManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/showCreate", method = RequestMethod.GET)
    public String showCreateAssetPage(Model model) {
        model.addAttribute("asset", new Asset());
        return "createAsset";
    }


    @RequestMapping(value="/showEdit/{id}",method=RequestMethod.GET)
    public String showEditAssetPage(@PathVariable("id") String id,Model model){
        Asset asset = assetService.findById(Long.decode(id));
        asset.getAssignedTo();
        model.addAttribute("asset",asset);
        return "createAsset";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createAsset(@ModelAttribute("asset") Asset asset, BindingResult errors,
                              Model model, @RequestParam(value = "userId", required = false) String userId, HttpSession session) {
        Long userIdInt = Long.valueOf(userId);
        User user = (User) session.getAttribute("user");
        User assignedUser = userService.getUserById(userIdInt);
        if (userIdInt == 0) {
            assignedUser = user;
        }
        asset.setAssignedTo(assignedUser);
        if (!errors.hasErrors()) {
            assetService.createAsset(asset);
            model.addAttribute("sucessmsg", "Asset was created and assigned Successfully");
            User assignedTo = asset.getAssignedTo();
            assignedTo.getFirstName();
            model.addAttribute("asset", asset);
            model.addAttribute("assignedUser", assignedTo);
            return "reviewAsset";
        } else {
            return "createAsset";
        }
    }

    @ModelAttribute
    public void populateUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
    }


}
