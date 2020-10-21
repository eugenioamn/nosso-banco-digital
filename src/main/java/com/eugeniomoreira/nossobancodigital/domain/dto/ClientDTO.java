package com.eugeniomoreira.nossobancodigital.domain.dto;

import com.eugeniomoreira.nossobancodigital.domain.entity.ClientEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientDTO {

    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String email;

    @JsonProperty("birth_date")
    private String birthDate;

    private String document;

    private String documentFile;

    @JsonProperty("address")
    private AddressDTO addressDto;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String firstName, String lastName, String email, String birthDate, String document, String documentFile, AddressDTO addressDto) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.document = document;
        this.documentFile = documentFile;
        this.addressDto = addressDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocumentFile() {
        return documentFile;
    }

    public void setDocumentFile(String documentFile) {
        this.documentFile = documentFile;
    }

    public AddressDTO getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDTO addressDto) {
        this.addressDto = addressDto;
    }

    public static ClientEntity fromDto(ClientDTO clientDto) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(clientDto.getId());
        clientEntity.setBirthDate(clientDto.getBirthDate());
        clientEntity.setDocument(clientDto.getDocument());
        clientEntity.setEmail(clientDto.getEmail());
        clientEntity.setFirstName(clientDto.getFirstName());
        clientEntity.setLastName(clientDto.getLastName());
        clientEntity.setAddress(AddressDTO.fromDto(clientDto.getAddressDto()));
        clientEntity.setDocumentFile(clientDto.getDocumentFile());

        return clientEntity;
    }

    public static ClientDTO toDto(ClientEntity clientEntity) {
        ClientDTO clientDto = new ClientDTO();
        clientDto.setId(clientEntity.getId());
        clientDto.setBirthDate(clientEntity.getBirthDate());
        clientDto.setDocument(clientEntity.getDocument());
        clientDto.setEmail(clientEntity.getEmail());
        clientDto.setFirstName(clientEntity.getFirstName());
        clientDto.setLastName(clientEntity.getLastName());
        clientDto.setAddressDto(AddressDTO.toDto(clientEntity.getAddress()));
        clientDto.setDocumentFile(clientEntity.getDocumentFile());

        return clientDto;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", document='" + document + '\'' +
                ", addressDto=" + addressDto +
                '}';
    }

}
