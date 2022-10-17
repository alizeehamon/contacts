package com.projet.contacts.dto;

import com.projet.contacts.entity.Contact;
import com.projet.contacts.uploadingfile.service.FileSystemStorageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

public class ContactDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private MultipartFile image;

    private String imageUrl;

    private String address1;

    private String address2;

    private String zipCode;

    private String city;

    private String country;

    private String birthdate;

    private String encounterSummary;

    private String company;

    private String companyRole;

    private String webSite;

    private String note;

    public ContactDTO() {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Contact toDto(){
        Contact contact = new Contact();
        contact.setFirstName(this.getFirstName());
        contact.setLastName(this.getLastName());
        contact.setPhone(this.getPhone());
        contact.setEmail(this.getEmail());
        contact.setAddress1(this.getAddress1());
        contact.setAddress2(this.getAddress2());
        contact.setZipCode(this.getZipCode());
        contact.setCity(this.getCity());
        contact.setCountry(this.getCountry());
        contact.setBirthdate(LocalDate.parse(this.getBirthdate()));
        contact.setCompany(this.getCompany());
        contact.setCompanyRole(this.getCompanyRole());
        contact.setEncounterSummary(this.getEncounterSummary());
        contact.setWebSite(this.getWebSite());
        MultipartFile picture = this.getImage();
        try {
            FileSystemStorageService fileService = new FileSystemStorageService();
            fileService.store(picture);
            contact.setImage("http://localhost:8080/images/" + picture.getOriginalFilename());
        }catch(IOException e){
            e.printStackTrace();
        }
        return contact;
    }
}
