package com.projet.contacts.repository;

import com.projet.contacts.entity.Contact;
import com.projet.contacts.entity.Relationship;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationRepository extends CrudRepository<Relationship, Long> {
    @Query("SELECT r from Relationship r where r.transmitterContact.id = :id")
    List<Relationship> findAllByTransmitterId(Long id);
}
