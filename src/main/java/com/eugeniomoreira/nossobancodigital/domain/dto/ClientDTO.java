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

    @JsonProperty("address")
    private AddressDTO addressDTO;

    private Integer proposalStatus;

    public ClientDTO() {
    }

    public ClientDTO(String firstName, String lastName, String email, String birthDate, String document, AddressDTO addressDTO, Integer proposalStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.document = document;
        this.addressDTO = addressDTO;
        this.proposalStatus = proposalStatus;
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

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public Integer getProposalStatus() {
        return proposalStatus;
    }

    public void setProposalStatus(Integer proposalStatus) {
        this.proposalStatus = proposalStatus;
    }

    public static ClientEntity fromDto(ClientDTO clientDTO) {
        ClientEntity client = new ClientEntity();
        client.setBirthDate(clientDTO.getBirthDate());
        client.setDocument(clientDTO.getDocument());
        client.setEmail(clientDTO.getEmail());
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setAddress(AddressDTO.fromDto(clientDTO.getAddressDTO()));
        client.setProposalStatus(clientDTO.getProposalStatus());

        return client;
    }

    public static ClientDTO toDto(ClientEntity client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setBirthDate(client.getBirthDate());
        clientDTO.setDocument(client.getDocument());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setFirstName(client.getFirstName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setAddressDTO(AddressDTO.toDto(client.getAddress()));
        clientDTO.setProposalStatus(client.getProposalStatus());

        return clientDTO;
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
                ", addressDTO=" + addressDTO +
                ", proposalStatus=" + proposalStatus +
                '}';
    }

}
