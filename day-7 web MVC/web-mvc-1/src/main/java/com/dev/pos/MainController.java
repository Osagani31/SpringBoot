package com.dev.pos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainController {

    @GetMapping({"/", "/main-page", "/main-page/"})

    public String loadMainUi(){
        return "main-page";
    }
}
