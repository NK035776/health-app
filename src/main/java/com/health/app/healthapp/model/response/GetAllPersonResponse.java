package com.health.app.healthapp.model.response;

import java.util.List;

import org.springframework.hateoas.Link;

import com.health.app.healthapp.model.Persons;
import com.health.app.healthapp.service.GetAllPersonsByIdService;

import lombok.Data;

@Data
public class GetAllPersonResponse
{
    GetPersonByIdResponse getPersonByIdResponse;

    Link allLink;

    public GetAllPersonResponse() {}
}
