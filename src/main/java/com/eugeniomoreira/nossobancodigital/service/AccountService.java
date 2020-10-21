package com.eugeniomoreira.nossobancodigital.service;

import com.eugeniomoreira.nossobancodigital.domain.entity.AccountEntity;

public interface AccountService {

    AccountEntity createAccount(Long proposalId);

}
