package com.sparta.sakilaweb.repo;

import com.sparta.sakilaweb.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}