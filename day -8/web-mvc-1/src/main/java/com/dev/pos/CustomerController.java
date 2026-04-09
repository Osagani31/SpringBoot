package com.dev.pos;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")

public class CustomerController {
    @RequestMapping("/set-ui")
    public String setUi(Model model) {
        Customer customerEntry = new Customer();
        model.addAttribute("customer", customerEntry);

        return "customer-ui";
    }
    @RequestMapping("/register")
    public String register(@ModelAttribute("customer")Customer customer){
        return "customer-detail";



    }

}
