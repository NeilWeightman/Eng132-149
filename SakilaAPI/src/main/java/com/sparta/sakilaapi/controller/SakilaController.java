package com.sparta.sakilaapi.controller;

import com.sparta.sakilaapi.entity.Customer;
import com.sparta.sakilaapi.repo.CustomerRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SakilaController {

    @GetMapping("/")
    public String basic(){
        return "<h1>Hello</h1>";
    }

    @GetMapping({"/customer", "/something"})
    public Customer getCustomer(){
        return new Customer("Houssam Eddine", "Bououdina");
    }

    @PostMapping("/customer")
    public Customer newCustomer(String firstName, String lastName){
        CustomerRepo repo = CustomerRepo.getInstance();
        Customer c = new Customer(firstName, lastName);
        repo.add(c);
        System.out.println(repo);
        return c;
    }
}
