package com.sparta.sakilaapi.repo;

import com.sparta.sakilaapi.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}