package com.dev.pos;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/products")
@RequestMapping("/products")

public class ProductController {
    @RequestMapping("/register")
    public String register() {
        return "product-detail";
    }



}
