package com.eugeniomoreira.nossobancodigital.repository;

import com.eugeniomoreira.nossobancodigital.domain.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
}
