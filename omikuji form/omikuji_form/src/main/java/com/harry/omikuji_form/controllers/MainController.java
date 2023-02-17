package com.harry.omikuji_form.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }

    @RequestMapping(value ="/submit", method=RequestMethod.POST)
    public String submit(
        @RequestParam("pick") String pick,
        @RequestParam("city") String city,
        @RequestParam("person") String person,
        @RequestParam("hobby") String hobby,
        @RequestParam("thing") String thing,
        @RequestParam("nice") String nice,HttpSession session){
            session.setAttribute("pick", pick);
            session.setAttribute("city", city);
            session.setAttribute("person", person);
            session.setAttribute("hobby", hobby);
            session.setAttribute("thing", thing);
            session.setAttribute("nice", nice);
            return "redirect:/results";
        }
    @RequestMapping("/results")
    public String results(){
        return "results.jsp";
    }

}
