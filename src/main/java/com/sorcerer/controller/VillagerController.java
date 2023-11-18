package com.sorcerer.controller;

import com.sorcerer.service.VilagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VillagerController {

    @Autowired
    private VilagerService vilagerService;
    @GetMapping("/")
    public String index() {

        return "Greetings from Spring Boot hello!";
    }

        @GetMapping(path = "/sorcerer")
        public String hello(@RequestParam("ages") List<Integer> ages,
                            @RequestParam("death") List<Integer> yearOfDeath){

        if(ages.size() != yearOfDeath.size()){
            return "WARNING : list data ages and year of death not in the same length";
        }
            return String.format("So the average number of victims between those two years is %s",vilagerService.countVictims(ages, yearOfDeath));
        }

}