package com.bosonit.EJ2.application.UseCase;

import com.bosonit.EJ2.Exceptions.NotFoundException;
import com.bosonit.EJ2.application.Port.GetPersonPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonUseCase implements GetPersonPort {

    @Autowired
    PersonaRepository personaRepository;

    public PersonaEnt getPersonaByID(Integer id) throws Exception
    {
        return personaRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuario no encontrado"));
    }

    //getnombre

    public List <PersonaEnt> getPersonByName(String name){
        List <PersonaEnt> listPersona = personaRepository.findByName(name);
        return listPersona;
    }

    //getall

    public List<PersonaEnt> getAllPerson() {
        List<PersonaEnt> personaList = personaRepository.findAll();
        return personaList;
    }

}
