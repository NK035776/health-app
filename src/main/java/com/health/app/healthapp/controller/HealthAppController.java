package com.health.app.healthapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.health.app.healthapp.model.Persons;
import com.health.app.healthapp.model.response.GetAllPersonResponse;
import com.health.app.healthapp.model.response.GetPersonByIdResponse;
import com.health.app.healthapp.model.response.SavePersonByIdResponse;
import com.health.app.healthapp.service.GetAllPersonsByIdService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
@RequestMapping(path="/health-App")
public class HealthAppController
{

    @Autowired
    GetAllPersonsByIdService getAllPersonsByIdService;

    @GetMapping(path = "/all")
    public ResponseEntity<GetAllPersonResponse> getAppPersonsById() {
        List<Persons> personsList = getAllPersonsByIdService.getAllPersonsBy();
        GetPersonByIdResponse getPersonByIdResponse = new GetPersonByIdResponse();
        personsList.forEach(persons -> {
            Link selfLink = linkTo(methodOn(HealthAppController.class)
                    .getPersonById(String.valueOf(persons.getPersonId())))
                    .withSelfRel();
            getPersonByIdResponse.setLink(selfLink);
            getPersonByIdResponse.setPersons(persons);
        });
        Link allLink = linkTo(methodOn(HealthAppController.class).getAppPersonsById()).withRel("Person");
        GetAllPersonResponse getAllPersonResponse = new GetAllPersonResponse();
        getAllPersonResponse.setGetPersonByIdResponse(getPersonByIdResponse);
        getAllPersonResponse.setAllLink(allLink);
        return new ResponseEntity<>(getAllPersonResponse, HttpStatus.OK);
    }

    @GetMapping("/getPerson/{personId}")
    public ResponseEntity<GetPersonByIdResponse> getPersonById(@PathVariable String personId) {
        Persons persons = getAllPersonsByIdService.getPersonById(Integer.parseInt(personId));
        Link selfLink = linkTo(methodOn(HealthAppController.class).getPersonById(personId)).withSelfRel();

        Link allLink = linkTo(methodOn(HealthAppController.class).getAppPersonsById()).withRel("Person");
        GetPersonByIdResponse getPersonByIdResponse = new GetPersonByIdResponse();
        getPersonByIdResponse.setPersons(persons);
        getPersonByIdResponse.setLink(selfLink);
        return new ResponseEntity<>(getPersonByIdResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/addPerson")
    public ResponseEntity<SavePersonByIdResponse> savePerson(@RequestBody Persons persons) {

        getAllPersonsByIdService.savePerson(persons);
        Link selfLink = linkTo(methodOn(HealthAppController.class).savePerson(persons)).withSelfRel();
        SavePersonByIdResponse savePersonByIdResponse = new SavePersonByIdResponse();

        savePersonByIdResponse.setLink(selfLink);

        return new ResponseEntity<>(savePersonByIdResponse, HttpStatus.CREATED);
    }
}
