package com.health.app.healthapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.health.app.healthapp.model.Persons;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Persons, Double>
{

}
