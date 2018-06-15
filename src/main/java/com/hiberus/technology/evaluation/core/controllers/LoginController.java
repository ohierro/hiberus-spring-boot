package com.hiberus.technology.evaluation.core.controllers;

import com.hiberus.technology.evaluation.core.config.AppProperties;
import com.hiberus.technology.evaluation.core.controllers.params.SortParams;
import com.hiberus.technology.evaluation.core.db.UserRepository;
import com.hiberus.technology.evaluation.core.db.entity.UserEntity;
import com.hiberus.technology.evaluation.core.providers.UserProvider;
import com.hiberus.technology.evaluation.core.providers.models.UserDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class LoginController {
    private UserProvider userProvider;

    private AppProperties properties;

    public LoginController(@Autowired AppProperties properties,
                           @Autowired UserProvider userProvider) {
        this.userProvider = userProvider;
        this.properties = properties;
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("index");
        return "index";
    }

    int logControl = 3;
    @RequestMapping(value = {"/login"}, method = {RequestMethod.GET})
    public ModelAndView login() {
    	ModelAndView model;
    	if(logControl > 0) {
    		model = new ModelAndView("login");
    		model.addObject("logControl", "Intentos restantes: " + logControl);
    		logControl--;
    	} else {
    		model = new ModelAndView("error");
    	}
        return model;
    }

//    http://url/login?email=123&passwd=123
    @PostMapping(value = {"/login"})
    public ModelAndView submitAdmissionLogin (@RequestParam("email") String email, @RequestParam("passwd") String passwd) {
    	return userProvider.checkPassword(email, passwd) ? new ModelAndView("home") : login();
    }


    //    http://url/var/23/?sort=email&order=desc
    @RequestMapping("/var/{id}")
    public ModelAndView getVar(@PathVariable("id") Integer id, @RequestParam(value = "sort", required = false) String sort,  @RequestParam("order") String order) {
        String exampleVar = properties.getExampleVar();

        ModelAndView model = new ModelAndView("variables");
        model.addObject("varValue", exampleVar);
        return model;
    }

    @RequestMapping("/var_with_params/{id}")
    public ModelAndView getVar(@PathVariable("id") Integer id, SortParams params) {
        String exampleVar = properties.getExampleVar();

        ModelAndView model = new ModelAndView("variables");
        model.addObject("varValue", exampleVar);
        return model;
    }


}
