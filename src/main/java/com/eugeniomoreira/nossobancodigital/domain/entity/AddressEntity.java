package com.eugeniomoreira.nossobancodigital.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddressEntity {

    @Id
    private Long id;

    private String postalCode;

    private String address;

    private String neighborhood;

    private String complement;

    private String state;

    private String country;

    public AddressEntity() {
    }

    public AddressEntity(String postalCode, String address, String neighborhood, String complement, String state, String country) {
        this.postalCode = postalCode;
        this.address = address;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.state = state;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", postalCode='" + postalCode + '\'' +
                ", address='" + address + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", complement='" + complement + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
