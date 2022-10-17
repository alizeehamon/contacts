package com.projet.contacts.entity;

import com.projet.contacts.dto.ContactDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String image;

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

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "targetContact")
    private List<Relationship> contactsRelatedToMe;

    @OneToMany(mappedBy = "transmitterContact")
    private List<Relationship> contactsImRelatedTo;

    public Contact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEncounterSummary() {
        return encounterSummary;
    }

    public void setEncounterSummary(String encounterSummary) {
        this.encounterSummary = encounterSummary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyRole() {
        return companyRole;
    }

    public void setCompanyRole(String companyRole) {
        this.companyRole = companyRole;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Relationship> getContactsRelatedToMe() {
        return contactsRelatedToMe;
    }

    public void setContactsRelatedToMe(List<Relationship> contactsRelatedToMe) {
        this.contactsRelatedToMe = contactsRelatedToMe;
    }

    public List<Relationship> getContactsImRelatedTo() {
        return contactsImRelatedTo;
    }

    public void setContactsImRelatedTo(List<Relationship> contactsImRelatedTo) {
        this.contactsImRelatedTo = contactsImRelatedTo;
    }

    public ContactDTO toDTO(boolean isForEdit) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(this.getId());
        contactDTO.setFirstName(this.getFirstName());
        contactDTO.setLastName(this.getLastName());
        contactDTO.setPhone(this.getPhone());
        contactDTO.setEmail(this.getEmail());
        contactDTO.setAddress1(this.getAddress1());
        contactDTO.setAddress2(this.getAddress2());
        contactDTO.setZipCode(this.getZipCode());
        contactDTO.setCity(this.getCity());
        contactDTO.setCountry(this.getCountry());
        contactDTO.setBirthdate(String.valueOf(this.getBirthdate()));
        contactDTO.setCompany(this.getCompany());
        contactDTO.setCompanyRole(this.getCompanyRole());
        contactDTO.setEncounterSummary(this.getEncounterSummary());
        contactDTO.setWebSite(this.getWebSite());
        if(!isForEdit) {
            contactDTO.setImageUrl(this.getImage());
        }
        return contactDTO;
    }
}
