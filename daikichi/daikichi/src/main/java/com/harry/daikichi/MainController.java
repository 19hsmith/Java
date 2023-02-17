package com.harry.daikichi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    
    @RequestMapping("/daikichi/travel")
    public String index(@RequestParam(value="place") String searchQuery){
        return "congrats! You will soon arrive to " + searchQuery;
    }

    @RequestMapping("/daikichi/lotto/{number}")
    public String test(@PathVariable("number") String number){
        if(Integer.parseInt(number) % 2 != 0){
            return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
        } else {
            return "you will take a grand journey in the near future,but be weary of tempting offers.";
        }
    }
}
