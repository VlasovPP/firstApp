package ru.task.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.task.spring.dao.OrganizationDAO;
import ru.task.spring.models.Organization;


import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/organization")
public class OrganizationController {

    private static OrganizationDAO organizationDAO;

    @Autowired
    public OrganizationController(OrganizationDAO organizationDAO) {
        this.organizationDAO = organizationDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("organization", organizationDAO.index());
        return "organization/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("organization", organizationDAO.show(id));
        return "organization/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("organization") Organization organization) {
        return "organization/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("employee") @Valid Organization organization,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "organization/new";

        organizationDAO.save(organization);
        return "redirect:/organization";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("organization", organizationDAO.show(id));
        return "organization/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("organization") @Valid Organization organization,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "organization/edit";

        organizationDAO.update(id, organization);
        return "redirect:/organization";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        organizationDAO.delete(id);
        return "redirect:/organization";
    }

    @ModelAttribute("allOrganization")
    public static List<Organization> allOrganization() {
        return organizationDAO.index();
    }


}