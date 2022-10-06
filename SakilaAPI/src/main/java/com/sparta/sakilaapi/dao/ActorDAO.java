package com.sparta.sakilaapi.dao;

import com.sparta.sakilaapi.dto.ActorDTO;
import com.sparta.sakilaapi.entity.Actor;
import com.sparta.sakilaapi.repo.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActorDAO {
    private ActorRepository actorRepo;

    public ActorDAO(ActorRepository actorRepo) {
        this.actorRepo = actorRepo;
    }

    public ActorDTO update(ActorDTO actorDTO) {
        Optional<Actor> optional = actorRepo.findById(actorDTO.getId());
        Actor theActor = null;
        if(optional.isPresent())
            theActor = optional.get();
        else
            return new ActorDTO(-1, null, null);
        if(actorDTO.getFirstName()!=null)
            theActor.setFirstName(actorDTO.getFirstName());
        if(actorDTO.getLastName()!=null)
            theActor.setLastName(actorDTO.getLastName());
        actorRepo.save(theActor);
        theActor = actorRepo.findById(actorDTO.getId()).get();
        return new ActorDTO(theActor.getId(),
                theActor.getFirstName(), theActor.getLastName());
    }
}
