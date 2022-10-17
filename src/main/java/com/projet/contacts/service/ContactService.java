package com.projet.contacts.service;

import com.projet.contacts.dto.ContactDTO;
import com.projet.contacts.entity.Contact;
import com.projet.contacts.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.io.IOException;
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


    public List<ContactDTO> findAllContacts() {
        List<Contact> contactList = (List<Contact>) contactRepository.findAll();
        return contactList.stream().map(c -> c.toDTO()).collect(Collectors.toList());
    }

    public void addContact(ContactDTO contactDTO) {
        contactRepository.save(contactDTO.toDto());
    }

    public void delete(Long id) {
        Optional<Contact> contactOpt = this.contactRepository.findById(id);
        contactOpt.ifPresent(contact -> this.contactRepository.delete(contact));
        contactOpt.orElseThrow(() -> new NoSuchElementException("Contact not found to delete with the id " + id));
    }

    public ContactDTO findContactById(Long id) {
        Optional<Contact> contactOpt = this.contactRepository.findById(id);
        return contactOpt.orElseThrow(() -> new NoSuchElementException("Contact not found with the id " + id)).toDTO();
    }
}
