package com.harry.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harry.dojo.models.Dojo;
import com.harry.dojo.models.Ninja;
import com.harry.dojo.services.DojoService;
import com.harry.dojo.services.NinjaService;

@Controller



public class MainController {
    @Autowired DojoService dojoService;
    @Autowired NinjaService ninjaService;

    @RequestMapping(value={"/dojos/new", "/"})
    public String newDojo(@ModelAttribute("dojo")Dojo dojo,Model model) {
        List<Dojo>dojos = dojoService.getAll();
        model.addAttribute("dojos",dojos);
        return "dojos/new.jsp";
    }
    
    @PostMapping("/dojos")
    public String createDojo(@ModelAttribute("dojo")Dojo dojo){
        dojoService.createDojo(dojo);
        return "redirect:/";
    }

    @RequestMapping(value={"/ninjas/new"})
    public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model){
        List<Dojo>dojos = dojoService.getAll();
        model.addAttribute("dojos",dojos);
        return "ninjas/new.jsp";
    }
    @PostMapping("/ninjas")
    public String createNinja(@ModelAttribute("ninja")Ninja ninja){
        ninjaService.createNinja(ninja);
        return "redirect:/";
    }
    @GetMapping("/dojos/show/{id}")
    public String showNinja(@PathVariable("id")Long id,Model model){
        Dojo something = dojoService.getDojo(id);
        model.addAttribute("dojo",something);
        return "/dojos/show.jsp";
    }
}
