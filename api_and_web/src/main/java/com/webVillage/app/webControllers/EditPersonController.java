package com.webVillage.app.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EditPersonController {
    @GetMapping(path = "/edit/{id}")
    public String getPerson(@PathVariable(name="id", required=true) Integer id, Model model) {
        model.addAttribute("id", id);
        return "editPerson";
    }
}
