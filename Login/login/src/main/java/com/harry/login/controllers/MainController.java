package com.harry.login.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harry.login.models.LoginUser;
import com.harry.login.models.User;
import com.harry.login.services.UserService;


@Controller
public class MainController {
    
    // Add once service is implemented:
    @Autowired
    private UserService userServ;
    
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.register(newUser, result);
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session,
        session.setAttribute("userId", user.getId());
        session.setAttribute("userName", user.getUserName()); 
        // in other words, log them in.
    
        return "redirect:/welcome";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session,
        session.setAttribute("userId", user.getId());
        session.setAttribute("userName", user.getUserName());
        // in other words, log them in.
    
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session){
         if(session.getAttribute("userId") != null){
            return "welcome.jsp";
         }
         return "redirect:/";

    }

    @RequestMapping("/logout")
    public String logOut( HttpSession session){
        session.removeAttribute("userId");
        session.removeAttribute("userName");
        return "redirect:/";
    }
    
}
