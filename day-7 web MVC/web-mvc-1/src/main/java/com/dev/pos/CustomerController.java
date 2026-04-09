package com.dev.pos;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class CustomerController {

    @RequestMapping(value = "/register")
    public String registerCustomer(HttpServletRequest request, Model model) {
        String customerName = request.getParameter("customerName");
        model.addAttribute("name", customerName);
        return "customer-detail";
    }
}
