package com.sparta.sakilaapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.sakilaapi.entity.Actor;
import com.sparta.sakilaapi.entity.Customer;
import com.sparta.sakilaapi.repo.ActorRepository;
import com.sparta.sakilaapi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SakilaController {
    @Autowired
    private ActorRepository actorRepo;

    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable int id){
        // need some error handling for non-existent actors
        Actor result = actorRepo.findById(id).get();
        return result;
    }

    @GetMapping("/actor/all")
    public List<Actor> getAllActors(){
        List<Actor> list = actorRepo.findAll();
        return list;
    }

    @DeleteMapping("/actor/{id}")
    public int deleteById(@PathVariable int id){
        Actor actor = actorRepo.findById(id).get();
        actorRepo.delete(actor);
        return actor.getId();
    }

    @PutMapping("/actor/{id}/firstName/{newFirstName}")
    public Actor updateFirstName(@PathVariable int id, @PathVariable String newFirstName){
        Actor theActor = actorRepo.findById(id).get();
        theActor.setFirstName(newFirstName);
        actorRepo.save(theActor);
        return theActor;
    }

    @GetMapping("/")
    public String basic(){
        return "<h1>Hello</h1>";
    }

    @GetMapping({"/customer", "/something"})
    public Customer getCustomer(){
        return new Customer("Houssam Eddine", "Bououdina", 1);
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<String> getCustomerByID(@PathVariable int id){
        CustomerRepo repo = CustomerRepo.getInstance();
        Customer cust = repo.get(id);
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<String> result = null;
        headers.add("content-type", "application/json");
        if(cust != null) {
            try {
                result = new ResponseEntity<>(
                        mapper.writeValueAsString(cust), headers, HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            result = new ResponseEntity<>("{\"message\":\"Customer not found\"}",
                    headers, HttpStatus.OK);
        }
        return result;
    }

    @PostMapping("/customer")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void newCustomer(@RequestBody Customer newCustomer){
        CustomerRepo repo = CustomerRepo.getInstance();
        repo.add(newCustomer);
    }
//    public Customer newCustomer(String firstName, String lastName, int id){
//        CustomerRepo repo = CustomerRepo.getInstance();
//        Customer c = new Customer(firstName, lastName, id);
//        repo.add(c);
//        System.out.println(repo);
//        return c;
//    }

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers(){
        CustomerRepo repo = CustomerRepo.getInstance();
        return repo.getList();
    }
}
