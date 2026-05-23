package org.example.controller;

import org.example.service.TechStackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TechStackController {

    private final TechStackService techStackService;

    public TechStackController(TechStackService techStackService) {
        this.techStackService = techStackService;
    }

    @GetMapping("/tech-stack")
    public String techStack(Model model) {
        model.addAttribute("categories", techStackService.getCategories());
        return "tech-stack";
    }
}
