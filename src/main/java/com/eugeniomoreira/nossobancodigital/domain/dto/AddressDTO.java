package com.eugeniomoreira.nossobancodigital.domain.dto;

import com.eugeniomoreira.nossobancodigital.domain.entity.AddressEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDTO {

    private Long id;

    @JsonProperty("postal_code")
    private String postalCode;

    private String street;

    private String neighborhood;

    private String complement;

    private String city;

    private String state;

    public AddressDTO() {
    }

    public AddressDTO(String postalCode, String street, String neighborhood, String complement, String city, String state) {
        this.postalCode = postalCode;
        this.street = street;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.city = city;
        this.state = state;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static AddressEntity fromDto(AddressDTO addressDto) {
        if (addressDto == null) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(addressDto.getStreet());
        addressEntity.setComplement(addressDto.getComplement());
        addressEntity.setState(addressDto.getState());
        addressEntity.setId(addressDto.getId());
        addressEntity.setNeighborhood(addressDto.getNeighborhood());
        addressEntity.setPostalCode(addressDto.getPostalCode());
        addressEntity.setCity(addressDto.getCity());

        return addressEntity;
    }

    public static AddressDTO toDto(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        AddressDTO addressDto = new AddressDTO();
        addressDto.setStreet(addressEntity.getStreet());
        addressDto.setComplement(addressEntity.getComplement());
        addressDto.setState(addressEntity.getState());
        addressDto.setId(addressEntity.getId());
        addressDto.setNeighborhood(addressEntity.getNeighborhood());
        addressDto.setPostalCode(addressEntity.getPostalCode());
        addressDto.setCity(addressEntity.getCity());

        return addressDto;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", postalCode='" + postalCode + '\'' +
                ", street='" + street + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", complement='" + complement + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

}
