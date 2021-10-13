package ru.task.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.task.spring.dao.AssigmentDAO;
import ru.task.spring.models.Assigment;
import ru.task.spring.models.Employee;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import static ru.task.spring.controllers.EmployeeController.allEmployee;



@Controller
@RequestMapping("/assigment")
public class AssigmentController {

    private final AssigmentDAO assigmentDAO;

    @Autowired
    public AssigmentController(AssigmentDAO assigmentDAO) {
        this.assigmentDAO = assigmentDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("assigment", assigmentDAO.index());
        return "assigment/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("assigment", assigmentDAO.show(id));
        return "assigment/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("assigment") Assigment assigment) {
        return "assigment/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("assigment") @Valid Assigment assigment,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "assigment/new";

        assigmentDAO.save(assigment);
        return "redirect:/assigment";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("assigment", assigmentDAO.show(id));
        return "assigment/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("assigment") @Valid Assigment assigment,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "assigment/edit";

        assigmentDAO.update(id, assigment);
        return "redirect:/assigment";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        assigmentDAO.delete(id);
        return "redirect:/assigment";
    }

    @ModelAttribute("singOfControl")
        public static List<String> singOfCont() {
            List<String> singOfCont = new ArrayList<>();
            singOfCont.add("there was no control yet");
            singOfCont.add("control");

        return singOfCont;
    }

    @ModelAttribute("singOfExecution")
    public static List<String> singOfExecution() {
        List<String> singOfExecution = new ArrayList<>();
        singOfExecution.add("Preparation");
        singOfExecution.add("Execution");
        singOfExecution.add("Сontrol");
        singOfExecution.add("Accepted");

        return singOfExecution;
    }

    @ModelAttribute("allEmployee")
    public List<Employee> allEmployee1() {
        return allEmployee();
    }

}