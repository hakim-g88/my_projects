package com.webVillage.app.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewPersonController {
    @GetMapping(path = "/person/new")
    public String getPerson() {
        return "newPerson";
    }
}