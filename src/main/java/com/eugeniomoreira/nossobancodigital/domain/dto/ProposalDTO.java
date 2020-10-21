package com.eugeniomoreira.nossobancodigital.domain.dto;

import com.eugeniomoreira.nossobancodigital.domain.entity.ProposalEntity;

public class ProposalDTO {

    private Long id;

    private Integer status;

    private ClientDTO clientDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public static ProposalDTO toDto(ProposalEntity entity) {
        ProposalDTO dto = new ProposalDTO();
        dto.setId(entity.getId());
        dto.setStatus(entity.getStatus());
        dto.setClientDTO(ClientDTO.toDto(entity.getClient()));

        return dto;
    }

    public static ProposalEntity fromDto(ProposalDTO dto) {
        ProposalEntity entity = new ProposalEntity();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
        entity.setClient(ClientDTO.fromDto(dto.getClientDTO()));

        return entity;
    }
}
