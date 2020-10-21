package com.eugeniomoreira.nossobancodigital.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "proposal")
public class ProposalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer status;

    @ManyToOne(targetEntity = ClientEntity.class)
    private ClientEntity client;

    public ProposalEntity(Long id, Integer status, ClientEntity client) {
        this.id = id;
        this.status = status;
        this.client = client;
    }

    public ProposalEntity() {
    }

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

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
