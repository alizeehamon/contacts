package com.projet.contacts.controller;

import com.projet.contacts.dto.ContactDTO;
import com.projet.contacts.dto.RelationDTO;
import com.projet.contacts.entity.Contact;
import com.projet.contacts.entity.User;
import com.projet.contacts.service.ContactService;
import com.projet.contacts.service.RelationService;
import com.projet.contacts.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class ContactController {

    private final ContactService contactService;
    private final UserService userService;

    private final RelationService relationService;

    public ContactController(ContactService contactService, UserService userService, RelationService relationService) {
        this.contactService = contactService;
        this.userService = userService;
        this.relationService = relationService;
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
    public String createContact(Authentication authentication, ContactDTO contactDTO) {
        User user = userService.getCurrentUser(authentication.getName());
        contactService.addContact(contactDTO, user);
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

    @GetMapping("/addRelation/{id}")
    public String displayRelationForm(Authentication authentication, Model model, @PathVariable Long id){
        ContactDTO contactDTO = contactService.findContactById(id, false);
        model.addAttribute("contact", contactDTO);
        User user = userService.getCurrentUser(authentication.getName());
        List<ContactDTO> contactList = contactService.searchContactsByUserId(null, user);
        contactList = contactList.stream().filter(c -> !c.getId().equals(id)).collect(Collectors.toList());
        model.addAttribute("contacts", contactList);
        return "addRelation";
    }

    @PostMapping("/addRelation/{id}")
    public String addRelationForm(@PathVariable Long id, RelationDTO targetDTO){
        relationService.addRelation(id, targetDTO);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editBook( ContactDTO contactDTO, Model model, @PathVariable Long id) {
        model.addAttribute("contact", contactDTO);
        contactService.edit(id, contactDTO);
        return "redirect:/";
    }

    @GetMapping("/see/{id}")
    public String displayContactDetails(Model model, @PathVariable Long id) {
        ContactDTO contactDTO = contactService.findContactById(id, false);
        List<RelationDTO> relations = relationService.findRelationByContact(id);
        model.addAttribute("contact", contactDTO);
        model.addAttribute("relations", relations);
        return "contactDetails";
    }
}
