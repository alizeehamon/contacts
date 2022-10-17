package com.projet.contacts.service;

import com.projet.contacts.dto.ContactDTO;
import com.projet.contacts.entity.Contact;
import com.projet.contacts.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
