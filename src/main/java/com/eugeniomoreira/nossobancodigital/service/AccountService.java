package com.eugeniomoreira.nossobancodigital.service;

import com.eugeniomoreira.nossobancodigital.domain.entity.AccountEntity;
import com.eugeniomoreira.nossobancodigital.domain.entity.ProposalEntity;

public interface AccountService {

    AccountEntity createAccount(ProposalEntity proposal);
}
