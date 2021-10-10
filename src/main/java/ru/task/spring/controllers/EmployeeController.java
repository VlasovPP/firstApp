package ru.task.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.task.spring.dao.EmployeeDAO;
import ru.task.spring.models.Division;
import ru.task.spring.models.Employee;
import ru.task.spring.models.Organization;

import javax.validation.Valid;
import java.util.List;

import static ru.task.spring.controllers.DivisionController.allDivisions;
import static ru.task.spring.controllers.OrganizationController.allOrganization;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("employee", employeeDAO.index());
        return "employee/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeDAO.show(id));
        return "employee/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("employee") Employee employee) {
        return "employee/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("employee") @Valid Employee employee,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "employee/new";

        employeeDAO.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("employee", employeeDAO.show(id));
        return "employee/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("employee") @Valid Employee employee,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "employee/edit";

        employeeDAO.update(id, employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        employeeDAO.delete(id);
        return "redirect:/employee";
    }

    @ModelAttribute("allDivisions")
    public List<Division> allDivisions1() {
        return allDivisions();
    }

    @ModelAttribute("allOrganization")
    public List<Organization> allOrganization1() {
        return allOrganization();
    }

}