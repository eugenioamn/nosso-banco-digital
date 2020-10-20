package com.eugeniomoreira.nossobancodigital.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ClientEntity {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String birthDate;

    private String document;

    @OneToOne
    private AddressEntity address;

    private Integer proposalStatus;

    public ClientEntity() {
    }

    public ClientEntity(String firstName, String lastName, String email, String birthDate, String document, AddressEntity address, Integer proposalStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.document = document;
        this.address = address;
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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Integer getProposalStatus() {
        return proposalStatus;
    }

    public void setProposalStatus(Integer proposalStatus) {
        this.proposalStatus = proposalStatus;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", document='" + document + '\'' +
                ", address=" + address +
                ", proposalStatus=" + proposalStatus +
                '}';
    }
}
