package com.health.app.healthapp.model;

import java.time.Instant;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Persons")
public class Persons
{
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long personId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private Instant dateOfBirth;
    private Instant upDtTm;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_detail_id")
    private Person_Details personDetails;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persons")
    private List<Encounters> encounters;

    public Persons() {}

    public Long getPersonId ()
    {
        return personId;
    }

    public void setPersonId (Long personId)
    {
        this.personId = personId;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName ()
    {
        return lastName;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public Instant getDateOfBirth ()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth (Instant dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Instant getUpDtTm ()
    {
        return upDtTm;
    }

    public void setUpDtTm (Instant upDtTm)
    {
        this.upDtTm = upDtTm;
    }

    public Person_Details getPersonDetails ()
    {
        return personDetails;
    }

    public void setPersonDetails (Person_Details personDetails)
    {
        this.personDetails = personDetails;
    }

    public List<Encounters> getEncounters ()
    {
        return encounters;
    }

    public void setEncounters (List<Encounters> encounters)
    {
        this.encounters = encounters;
    }

}
