package com.projet.contacts.repository;

import com.projet.contacts.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

    @Query("SELECT c from Contact c where c.lastName LIKE %?1% OR c.firstName LIKE %?1%")
    List<Contact> findAllByName(String contactName);
}
