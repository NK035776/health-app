package com.health.app.healthapp.service;

import java.util.List;

import com.health.app.healthapp.model.Persons;

public interface GetAllPersonsByIdService
{
    public List<Persons> getAllPersonsBy ();

    public Persons getPersonById(double personId);

    public double savePerson(Persons persons);
}
