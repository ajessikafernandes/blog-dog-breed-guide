package br.com.blogdogbreedguide.controller;

import br.com.blogdogbreedguide.entity.User;
import br.com.blogdogbreedguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value="/posts", method= RequestMethod.POST)
    public String savePost(@Valid User user, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("message", "Check that the mandatory fields have been completed!");
            return "redirect:/newpost";
        }
        service.createNewUser(user);
        return "redirect:/posts";
    }
}
