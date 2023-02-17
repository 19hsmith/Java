package com.harry.travels.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.harry.travels.models.Travel;
import com.harry.travels.services.TravelService;





@Controller
public class MainController {
    @Autowired TravelService travelService;
    @RequestMapping("/")
    public String index(@ModelAttribute("travel")Travel travel, Model model) {
        List<Travel>travels = travelService.allTravel();
        System.out.println(travels);
        model.addAttribute("travels",travels);
        return "index.jsp";
    }
    
    @PostMapping("/travels")
    public String createTravel(
            @Valid @ModelAttribute("travel") Travel travel,BindingResult result, Model model
            ){  
                if(result.hasErrors()){
                    List<Travel>travels = travelService.allTravel();
                    model.addAttribute("travels",travels);
                    return "index.jsp";
                }else{
                    travelService.createTravel(travel);
                    return("redirect:/");
                }
            }
    @GetMapping("/travels/show/{id}")
    public String show(@PathVariable("id")Long id,Model model){
        Travel travel = travelService.getOneTravel(id);
        model.addAttribute("travel",travel);
        return "show.jsp";
    }

    @GetMapping("/travels/edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        Travel travel = travelService.getOneTravel(id);
        model.addAttribute("travel",travel);
        return "edit.jsp";
    }
    @PutMapping("/travels/{id}")
    public String update(@PathVariable("id")Long id, @Valid @ModelAttribute("travel")Travel travel, BindingResult result){
        if(result.hasErrors()){
            return "edit.jsp";
        } else {
            travelService.updateTravel(travel);
            return "redirect:/";
        }
    }
    @DeleteMapping("/travels/delete/{id}")
    public String destroy(@PathVariable("id")Long id){
        Travel travel = travelService.getOneTravel(id);
        travelService.deleteTravel(travel);
        return "redirect:/";
    }
}

