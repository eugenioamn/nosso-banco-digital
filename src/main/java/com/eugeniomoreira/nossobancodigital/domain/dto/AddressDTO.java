package com.eugeniomoreira.nossobancodigital.domain.dto;

import com.eugeniomoreira.nossobancodigital.domain.entity.AddressEntity;

public class AddressDTO {

    private Long id;

    private String postalCode;

    private String address;

    private String neighborhood;

    private String complement;

    private String state;

    private String country;

    public AddressDTO() {
    }

    public AddressDTO(String postalCode, String address, String neighborhood, String complement, String state, String country) {
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

    public static AddressEntity fromDto(AddressDTO address) {
        if (address == null) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress(address.getAddress());
        addressEntity.setComplement(address.getComplement());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setId(address.getId());
        addressEntity.setNeighborhood(address.getNeighborhood());
        addressEntity.setPostalCode(address.getPostalCode());
        addressEntity.setState(address.getState());

        return addressEntity;
    }

    public static AddressDTO toDto(AddressEntity address) {
        if (address == null) {
            return null;
        }
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddress(address.getAddress());
        addressDTO.setComplement(address.getComplement());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setId(address.getId());
        addressDTO.setNeighborhood(address.getNeighborhood());
        addressDTO.setPostalCode(address.getPostalCode());
        addressDTO.setState(address.getState());

        return addressDTO;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
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
