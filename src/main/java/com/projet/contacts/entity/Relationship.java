package com.projet.contacts.entity;

import javax.persistence.*;

@Entity
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String relationType;

    @ManyToOne
    private Contact transmitterContact;

    @ManyToOne
    private Contact targetContact;
}
