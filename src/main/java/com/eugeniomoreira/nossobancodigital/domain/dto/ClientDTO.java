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
    private AddressDTO addressDto;

    private Integer proposalStatus;

    public ClientDTO() {
    }

    public ClientDTO(String firstName, String lastName, String email, String birthDate, String document, AddressDTO addressDto, Integer proposalStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.document = document;
        this.addressDto = addressDto;
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

    public AddressDTO getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDTO addressDto) {
        this.addressDto = addressDto;
    }

    public Integer getProposalStatus() {
        return proposalStatus;
    }

    public void setProposalStatus(Integer proposalStatus) {
        this.proposalStatus = proposalStatus;
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
        clientEntity.setProposalStatus(clientDto.getProposalStatus());

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
        clientDto.setProposalStatus(clientEntity.getProposalStatus());

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
                ", proposalStatus=" + proposalStatus +
                '}';
    }

}
