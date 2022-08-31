package com.webVillage.app.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(path = "/")
    public String greeting() {
        return "index";
    }
}
