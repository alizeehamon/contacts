package com.projet.contacts.service;

import com.projet.contacts.dto.ContactDTO;
import com.projet.contacts.entity.Contact;
import com.projet.contacts.entity.User;
import com.projet.contacts.repository.ContactRepository;
import com.projet.contacts.uploadingfile.service.FileSystemStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Book;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public void addContact(ContactDTO contactDTO) {
        contactRepository.save(contactDTO.toDto());
    }

    public void delete(Long id) {
        Optional<Contact> contactOpt = this.contactRepository.findById(id);
        contactOpt.ifPresent(contact -> this.contactRepository.delete(contact));
        contactOpt.orElseThrow(() -> new NoSuchElementException("Contact not found to delete with the id " + id));
    }

    public ContactDTO findContactById(Long id, boolean isForEdit) {
        Optional<Contact> contactOpt = this.contactRepository.findById(id);
        return contactOpt.orElseThrow(() -> new NoSuchElementException("Contact not found with the id " + id)).toDTO(isForEdit);
    }

    public void edit(Long id, ContactDTO contactDTO) {
        Optional<Contact> contactOpt = this.contactRepository.findById(id);
        if (contactOpt.isPresent()) {
            Contact contact = contactOpt.get();
            contact.setFirstName(contactDTO.getFirstName());
            contact.setLastName(contactDTO.getLastName());
            contact.setPhone(contactDTO.getPhone());
            contact.setEmail(contactDTO.getEmail());
            contact.setAddress1(contactDTO.getAddress1());
            contact.setAddress2(contactDTO.getAddress2());
            contact.setZipCode(contactDTO.getZipCode());
            contact.setCity(contactDTO.getCity());
            contact.setCountry(contactDTO.getCountry());
            contact.setBirthdate(LocalDate.parse(contactDTO.getBirthdate()));
            contact.setCompany(contactDTO.getCompany());
            contact.setCompanyRole(contactDTO.getCompanyRole());
            contact.setEncounterSummary(contactDTO.getEncounterSummary());
            contact.setWebSite(contactDTO.getWebSite());
            if(contactDTO.getImage() != null && !contactDTO.getImage().getOriginalFilename().equals("")) {
                MultipartFile picture = contactDTO.getImage();
                try {
                    FileSystemStorageService fileService = new FileSystemStorageService();
                    fileService.store(picture);
                    contact.setImage("http://localhost:8080/images/" + picture.getOriginalFilename());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.contactRepository.save(contact);
        }
        contactOpt.orElseThrow(() -> new NoSuchElementException("Contact not found to edit with the id " + contactDTO.getId()));
    }

    public List<ContactDTO> searchContactsByUserId(String contactName, User user) {
        if (contactName != null) {
            List<Contact> contacts = this.contactRepository.findAllByNameAndUserId(contactName, user);
            return contacts.stream().map(c -> c.toDTO(false)).collect(Collectors.toList());
        }
        List<Contact> contacts = this.contactRepository.findAllByUserId(user);
        return contacts.stream().map(c -> c.toDTO(false)).collect(Collectors.toList());
    }
}
