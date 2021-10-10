package ru.task.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.task.spring.dao.DivisionDAO;
import ru.task.spring.dao.OrganizationDAO;
import ru.task.spring.models.Division;
import ru.task.spring.models.Organization;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static ru.task.spring.controllers.OrganizationController.allOrganization;

@Controller
@RequestMapping("/division")
public class DivisionController {

    private final DivisionDAO divisionDAO;

    @Autowired
    public DivisionController(DivisionDAO divisionDAO) {
        this.divisionDAO = divisionDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("division", divisionDAO.index());
        return "division/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("division", divisionDAO.show(id));
        return "division/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("division") Division division) {
        return "division/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("division") @Valid Division division,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "division/new";

        divisionDAO.save(division);
        return "redirect:/division";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("division", divisionDAO.show(id));
        return "division/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("division") @Valid Division division,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "division/edit";

        divisionDAO.update(id, division);
        return "redirect:/division";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        divisionDAO.delete(id);
        return "redirect:/division";
    }

//    @ModelAttribute("allOrganization")
//    public static List<Organization> allOrganization() {
//        List<Organization> organizations = new ArrayList<>();
//
//        organizations.add(new Organization(1,"asdfsa","sadfsadf",
//                "sadfsadf", "asdf"));
//        organizations.add(new Organization(2,"asgnhhy","sg",
//                "sadfsadf", "asdf"));
//        return organizations;
//    }

    @ModelAttribute("allOrganization")
    public List<Organization> allOrganization1() {
        return allOrganization();
    }
}