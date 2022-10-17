package com.projet.contacts.dto;

public class RelationDTO {

    private String relationType;
    private Long idTargetContact;
    private String targetContactName;

    public RelationDTO() {
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public Long getIdTargetContact() {
        return idTargetContact;
    }

    public void setIdTargetContact(Long idTargetContact) {
        this.idTargetContact = idTargetContact;
    }

    public String getTargetContactName() {
        return targetContactName;
    }

    public void setTargetContactName(String targetContactName) {
        this.targetContactName = targetContactName;
    }
}
