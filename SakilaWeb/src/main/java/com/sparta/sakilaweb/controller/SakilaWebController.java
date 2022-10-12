package com.sparta.sakilaweb.controller;

import com.sparta.sakilaweb.entity.Actor;
import com.sparta.sakilaweb.repo.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("castList")
public class SakilaWebController {
    @Autowired
    private ActorRepository repo;

    @GetMapping("/sakila/testname")
    public String testName(String nameParam, Model model){
        model.addAttribute("nameAttribute", nameParam+" is adequate");
        return "displayName";
    }

    @GetMapping("/sakila/actor")
    public String findActor(int id, Model model){
        Actor result = repo.findById(id).get();
        model.addAttribute("actor", result);
        return "displayActor";
    }
    @GetMapping("/sakila/actor/all")
    public String findAllActors(Model model){
        List<Actor> allActors = repo.findAll();
        model.addAttribute("allActors", allActors);
        return "allActors";
    }

    @GetMapping("/sakila/cast/add/{id}")
    public String addCastMember(@PathVariable int id,
                                Model model,
                                @ModelAttribute("castList") List<Actor> castList){
        Actor actorToAdd = repo.findById(id).get();
        castList.add(actorToAdd);
        System.out.println(castList);
        return "displayCastList";
    }

    @ModelAttribute("castList")
    public List<Actor> castList(){
        System.out.println("Initialising the cast list");
        return new ArrayList<>();
    }
}
