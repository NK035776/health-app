package com.health.app.healthapp.model.response;

import org.springframework.hateoas.Link;

import com.health.app.healthapp.model.Persons;

import lombok.Data;

@Data
public class GetPersonByIdResponse
{
    Persons persons;

    Link link;

    public GetPersonByIdResponse () {}
}
