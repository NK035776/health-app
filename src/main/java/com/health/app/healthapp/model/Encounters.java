package com.health.app.healthapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Encounters")
public class Encounters
{

    @Id
    @Column(name = "encounter_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private Instant upDtTm;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Persons persons;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diet_id")
    private Diet diet;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "encounters", cascade = CascadeType.ALL)
    private List<Comments> comments;

    public Encounters() {}

    public Long getId ()
    {
        return id;
    }

    public void setId (Long id)
    {
        this.id = id;
    }

    public Instant getUpDtTm ()
    {
        return upDtTm;
    }

    public void setUpDtTm (Instant upDtTm)
    {
        this.upDtTm = upDtTm;
    }

    public Persons getPersons ()
    {
        return persons;
    }

    public void setPersons (Persons persons)
    {
        this.persons = persons;
    }

    public Diet getDiet ()
    {
        return diet;
    }

    public void setDiet (Diet diet)
    {
        this.diet = diet;
    }

    public List<Comments> getComments ()
    {
        return comments;
    }

    public void setComments (List<Comments> comments)
    {
        this.comments = comments;
    }

}
