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

    @JsonProperty("birthdate")
    private String birthdate;

    private String document;

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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public static ClientEntity fromDto(ClientDTO clientDto) {
        ClientEntity clientEntity = new ClientEntity();

        return clientEntity;
    }

    public static ClientDTO toDto(ClientEntity clientEntity) {
        ClientDTO clientDto = new ClientDTO();

        return clientDto;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", document='" + document + '\'' +
                '}';
    }

}
