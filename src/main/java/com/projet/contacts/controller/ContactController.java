package com.projet.contacts.controller;

import com.projet.contacts.dto.ContactDTO;
import com.projet.contacts.entity.Contact;
import com.projet.contacts.entity.User;
import com.projet.contacts.service.ContactService;
import com.projet.contacts.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class ContactController {

    private final ContactService contactService;
    private final UserService userService;

    public ContactController(ContactService contactService, UserService userService) {
        this.contactService = contactService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String displayContacts(Authentication authentication, Model model, @Param("contactName") String contactName){
        User user = userService.getCurrentUser(authentication.getName());
        List<ContactDTO> contacts = contactService.searchContactsByUserId(contactName, user);
        model.addAttribute("contacts", contacts);
        model.addAttribute("contactName", contactName);
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

    @GetMapping("/delete/{id}")
    public String displayDeleteForm(Model model, @PathVariable Long id) {
        ContactDTO contactDTO = contactService.findContactById(id, false);
        model.addAttribute("contact", contactDTO);
        return "deleteContact";
    }

    @PostMapping("/delete/{id}")
    public String removeBook(@PathVariable Long id) {
        contactService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String displayEditForm(Model model, @PathVariable Long id) {
       ContactDTO contactDTO = contactService.findContactById(id, true);
        model.addAttribute("contact", contactDTO);
        return "editContact";
    }

    @PostMapping("/edit/{id}")
    public String editBook(ContactDTO contactDTO, Model model, @PathVariable Long id) {
        model.addAttribute("contact", contactDTO);
        contactService.edit(id, contactDTO);
        return "redirect:/";
    }
}
