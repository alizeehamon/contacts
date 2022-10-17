package com.projet.contacts.service;

import com.projet.contacts.dto.ContactDTO;
import com.projet.contacts.dto.RelationDTO;
import com.projet.contacts.entity.Contact;
import com.projet.contacts.entity.Relationship;
import com.projet.contacts.repository.RelationRepository;
import org.springframework.stereotype.Service;

import javax.management.relation.Relation;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelationService {

    private final RelationRepository relationRepository;
    private final ContactService contactService;


    public RelationService(RelationRepository relationRepository, ContactService contactService) {
        this.relationRepository = relationRepository;
        this.contactService = contactService;
    }

    public void addRelation(Long id, RelationDTO relationDTO) {
        Contact emitter = contactService.findContactById(id);
        Contact target = contactService.findContactById(relationDTO.getIdTargetContact());
        Relationship relationship = new Relationship();
        relationship.setTransmitterContact(emitter);
        relationship.setTargetContact(target);
        relationship.setRelationType(relationDTO.getRelationType());
        this.relationRepository.save(relationship);
        // Do the other way
        Relationship relationshipOtherWay = new Relationship();
        relationshipOtherWay.setTargetContact(emitter);
        relationshipOtherWay.setTransmitterContact(target);
        relationshipOtherWay.setRelationType(relationDTO.getRelationType());
        this.relationRepository.save(relationshipOtherWay);
    }

    public List<RelationDTO> findRelationByContact(Long id) {
        List<Relationship> relations = relationRepository.findAllByTransmitterId(id);
        return relations.stream().map(r -> r.toDto()).collect(Collectors.toList());
    }
}
