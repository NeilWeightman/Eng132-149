package com.sparta.jdbc.sakila;

import com.sparta.jdbc.sakila.dao.interfaces.DAO;
import com.sparta.jdbc.sakila.dao.sql.ActorDAO;
import com.sparta.jdbc.sakila.entities.Actor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAO<Actor> actorDAO = ActorDAO.getInstance();
        Actor actor = actorDAO.findById(123);
        System.out.println(actor);
        List<Actor> allActors = actorDAO.findAll();
        System.out.println(allActors);
        int newId = actorDAO.insert(new Actor(0, "Adam", "Lemdani"));
        Actor newActor = actorDAO.findById(newId);
        System.out.println(newActor);
    }
}