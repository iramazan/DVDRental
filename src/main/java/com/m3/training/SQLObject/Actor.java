package com.m3.training.SQLObject;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ACTOR_ID")
    private long actorID;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="LAST_UPDATE")
    private Date lastUpdate;
}
