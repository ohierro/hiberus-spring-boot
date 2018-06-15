package com.hiberus.technology.evaluation.core.controllers;

import com.hiberus.technology.evaluation.core.db.UserRepository;
import com.hiberus.technology.evaluation.core.db.entity.UserEntity;
import com.hiberus.technology.evaluation.core.providers.UserProvider;
import com.hiberus.technology.evaluation.core.providers.models.UserDto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private ViewResolver viewResolver;

    @Autowired
    private UserProvider userProvider;
    
    @RequestMapping("/users")
    public ModelAndView getUsers(@RequestParam(value = "search", required = false) String search) {
        List<UserDto> users = userProvider.getUsers(0, 0, 0, search);
        ModelAndView model = new ModelAndView("users/list");
        model.addObject("users", users);
        return model; 
    }

    @RequestMapping("/users/add")
    public String add() {
        return "users/add";
    }

    @RequestMapping(value = "/users/{id}/edit")
    public ModelAndView edit(@PathVariable Integer id) {
        UserDto dto = userProvider.getUserById(0,0,0,id);
        ModelAndView result = new ModelAndView("users/edit");
        result.addObject("user",dto);

        return result;
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable String userId) {

        Integer valueUserId;

        try {
            valueUserId = Integer.parseInt(userId);
        } catch (NumberFormatException e) {
            return new ModelAndView("error");
        }

        UserDto user = userProvider.getUserById(0, 0, 0, valueUserId);
        ModelAndView model ;
        if (user == null){
            model = new ModelAndView("error");
        } else {
            model = new ModelAndView("usermodify");
            model.addObject("user", user);
            model.addObject("path", "/users/" + user.getId_user());
        }

        return model;
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public ModelAndView deleteUser(@PathVariable String userId) {

        Integer valueUserId;

        try {
            valueUserId = Integer.parseInt(userId);
        } catch (NumberFormatException e) {
            return new ModelAndView("error");
        }

        return new ModelAndView("redirect:/users");
//        return userProvider.deleteUser(valueUserId) ? getUsers("") : new ModelAndView("error");
    }



    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute(value = "user") UserDto user, BindingResult validator, Model model){
        user.setId_user(null);
        return userProvider.createUser(user) ? getUsers("") : new ModelAndView("error");
    }


    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public ModelAndView modifyUser(@ModelAttribute(value = "user") UserDto user, BindingResult validator) {

        return userProvider.modifyUser(user) ? getUsers("") : new ModelAndView("error");
    }


    @RequestMapping(value = "/createuser")
    public ModelAndView formUser() {

        return new ModelAndView("userform");
    }

}