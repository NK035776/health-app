package com.health.app.healthapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Person_Details")
public class Person_Details
{
    @Id
    @Column(name = "person_detail_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String personWeight;
    private String personHeight;
    @Column(name = "person_sex")
    private String sex;

    public Person_Details() {}

    public Long getId ()
    {
        return id;
    }

    public void setId (Long id)
    {
        this.id = id;
    }

    public String getPersonWeight ()
    {
        return personWeight;
    }

    public void setPersonWeight (String personWeight)
    {
        this.personWeight = personWeight;
    }

    public String getPersonHeight ()
    {
        return personHeight;
    }

    public void setPersonHeight (String personHeight)
    {
        this.personHeight = personHeight;
    }

    public String getSex ()
    {
        return sex;
    }

    public void setSex (String sex)
    {
        this.sex = sex;
    }
}
