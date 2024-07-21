package pl.davidduke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @GetMapping
    public String getPeople(Model model) {

        return null;
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model) {

        return null;
    }
}
