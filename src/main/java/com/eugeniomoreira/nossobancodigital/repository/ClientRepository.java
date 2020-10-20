package com.eugeniomoreira.nossobancodigital.repository;

import com.eugeniomoreira.nossobancodigital.domain.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
}
