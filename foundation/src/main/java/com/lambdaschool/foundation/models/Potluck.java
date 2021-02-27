package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;


import static javax.persistence.TemporalType.*;

@Entity
@Table(name="potlucks")
public class Potluck extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long potluckid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

//   Figure out right data type later, use as string temporarily
    @Column(nullable = false)
    private String date;

  // Figure out right data type later, use as string temporarily
    @Column(nullable = false)
    private String time;

    @ManyToOne
    @JoinColumn(name = "userid",
    nullable = false)
    @JsonIgnoreProperties(value = "potlucks", allowSetters = true)
    private User organizer;

    @OneToMany(mappedBy = "potluck",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties(value = "potluck", allowSetters = true)
    private Set<PotluckUsers> guests = new HashSet<>();

    @OneToMany(mappedBy = "potluck",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JsonIgnoreProperties(value = "potluck", allowSetters = true)
    private Set<PotluckItems> items = new HashSet<>();

    public Potluck()
    {
    }

    public Potluck(
        String name,
        String location,
        String date,
        String time,
        User organizer,
        Set<PotluckUsers> guests,
        Set<PotluckItems> items)
    {
        this.name = name;
        this.location = location;
        this.date = date;
        this.time = time;
        this.organizer = organizer;
        this.guests = guests;
        this.items = items;
    }


    public Potluck(
        String name,
        String location,
        String date,
        String time,
        User organizer)
    {
        this.name = name;
        this.location = location;
        this.date = date;
        this.time = time;
        this.organizer = organizer;
    }

    public long getPotluckid()
    {
        return potluckid;
    }

    public void setPotluckid(long potluckid)
    {
        this.potluckid = potluckid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }


    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public User getOrganizer()
    {
        return organizer;
    }

    public void setOrganizer(User organizer)
    {
        this.organizer = organizer;
    }

    public Set<PotluckUsers> getGuests()
    {
        return guests;
    }

    public void setGuests(Set<PotluckUsers> guests)
    {
        this.guests = guests;
    }

    public Set<PotluckItems> getItems()
    {
        return items;
    }

    public void setItems(Set<PotluckItems> items)
    {
        this.items = items;
    }
}