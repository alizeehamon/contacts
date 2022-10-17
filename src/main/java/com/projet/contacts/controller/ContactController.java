package com.projet.contacts.controller;

import com.projet.contacts.dto.ContactDTO;
import com.projet.contacts.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String displayContacts(Model model){
        List<ContactDTO> contacts = contactService.findAllContacts();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/add")
    public String displayAddContact(){
        return "addContact";
    }

    @PostMapping("/add")
    public String createContact(ContactDTO contactDTO) {
        contactService.addContact(contactDTO);
        return "redirect:/";
    }
}
