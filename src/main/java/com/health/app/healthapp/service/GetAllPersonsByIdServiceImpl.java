package com.health.app.healthapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.app.healthapp.model.Persons;
import com.health.app.healthapp.repository.PersonRepository;

@Service
public class GetAllPersonsByIdServiceImpl implements GetAllPersonsByIdService
{
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Persons> getAllPersonsBy ()
    {
        List<Persons> personListResponse = new ArrayList<>();
        Iterable<Persons> personList = personRepository.findAll();
        personList.forEach(personListResponse::add);
        return personListResponse;
    }

    @Override
    public Persons getPersonById (double personId)
    {
        return personRepository.findById(personId).orElse(null);
    }

    @Override
    public double savePerson(Persons persons)
    {
        Persons personResponse = personRepository.save(persons);
        return personResponse.getPersonId();
    }
}
