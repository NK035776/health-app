package com.health.app.healthapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Diet")
public class Diet
{

    @Id
    @Column(name = "diet_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String foodType;
    private String calorieValue;
    private String intakeFrep;
    private Instant upDtTm;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "diet", cascade = CascadeType.ALL)
    private List<Encounters> encounters;

    public Long getId ()
    {
        return id;
    }

    public void setId (Long id)
    {
        this.id = id;
    }

    public String getFoodType ()
    {
        return foodType;
    }

    public void setFoodType (String foodType)
    {
        this.foodType = foodType;
    }

    public String getCalorieValue ()
    {
        return calorieValue;
    }

    public void setCalorieValue (String calorieValue)
    {
        this.calorieValue = calorieValue;
    }

    public String getIntakeFrep ()
    {
        return intakeFrep;
    }

    public void setIntakeFrep (String intakeFrep)
    {
        this.intakeFrep = intakeFrep;
    }

    public Instant getUpDtTm ()
    {
        return upDtTm;
    }

    public void setUpDtTm (Instant upDtTm)
    {
        this.upDtTm = upDtTm;
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
