package ru.task.spring.controllers;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class HomeController {
    private static final Logger log = getLogger(HomeController.class);

    @GetMapping("/")
    public String home() {
        log.debug("redirect to home");
        return "/home";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }


    @GetMapping("/login")
    public String login() {
        return "/login";
    }

}
