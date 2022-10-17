package com.projet.contacts.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String address1;

    private String address2;

    private String zipCode;

    private String city;

    private String country;

    private LocalDate birthdate;

    private String encounterSummary;

    private String company;

    private String companyRole;

    private String webSite;

    private String note;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "targetContact")
    private List<Relationship> contactsRelatedToMe;

    @OneToMany(mappedBy = "transmitterContact")
    private List<Relationship> contactsImRelatedTo;


}
