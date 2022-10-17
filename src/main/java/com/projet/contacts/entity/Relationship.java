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

    public Relationship() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public Contact getTransmitterContact() {
        return transmitterContact;
    }

    public void setTransmitterContact(Contact transmitterContact) {
        this.transmitterContact = transmitterContact;
    }

    public Contact getTargetContact() {
        return targetContact;
    }

    public void setTargetContact(Contact targetContact) {
        this.targetContact = targetContact;
    }
}
