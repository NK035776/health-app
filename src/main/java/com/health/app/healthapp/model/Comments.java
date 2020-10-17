package com.health.app.healthapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Comments")
public class Comments
{
    @javax.persistence.Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long Id;
    private String comment_text;
    private Instant upDtTm;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "encounter_id")
    private Encounters encounters;


    public Long getId ()
    {
        return Id;
    }

    public void setId (Long id)
    {
        Id = id;
    }

    public String getComment_text ()
    {
        return comment_text;
    }

    public void setComment_text (String comment_text)
    {
        this.comment_text = comment_text;
    }

    public Instant getUpDtTm ()
    {
        return upDtTm;
    }

    public void setUpDtTm (Instant upDtTm)
    {
        this.upDtTm = upDtTm;
    }

    public Diet getDiet ()
    {
        return diet;
    }

    public Encounters getEncounters ()
    {
        return encounters;
    }

    public void setEncounters (Encounters encounters)
    {
        this.encounters = encounters;
    }

}
