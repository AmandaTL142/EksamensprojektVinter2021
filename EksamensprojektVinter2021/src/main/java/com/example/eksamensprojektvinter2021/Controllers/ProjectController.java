package com.example.eksamensprojektvinter2021.Controllers;

import com.example.eksamensprojektvinter2021.Services.ProjectService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ProjectController {

    ProjectService ps = new ProjectService();

    @GetMapping("/project/{thisProject}")//Path variables: /{}
    public String showWishlist(@PathVariable("thisProject") int thisProject, Model model) {
        model.addAttribute("Wishlist", ps.showProject(thisProject));
        return "project";
    }
}
