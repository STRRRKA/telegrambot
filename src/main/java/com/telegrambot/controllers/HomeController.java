package com.telegrambot.controllers;

import com.telegrambot.bots.TgBot;
import com.telegrambot.dao.PersonDAO;
import com.telegrambot.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class HomeController {

    private static String Color;
    public static void setColor(String color){
        Color = color;
    }
    private final PersonDAO personDAO;
    public HomeController(PersonDAO personDAO){
        this.personDAO = personDAO;
    }
    @GetMapping()
    public String home(Model model){
        model.addAttribute("people", personDAO.index());
        model.addAttribute("person1", new Person());
        model.addAttribute("color", Color);
        return "home";
    }

    @PostMapping()
    public String sendMSG(@ModelAttribute("person1") Person person){
        TgBot.setChatId(person.getTgID());
        return "redirect:/people";
    }
}