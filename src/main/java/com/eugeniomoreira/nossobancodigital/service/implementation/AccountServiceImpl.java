package com.eugeniomoreira.nossobancodigital.service.implementation;

import com.eugeniomoreira.nossobancodigital.domain.entity.AccountEntity;
import com.eugeniomoreira.nossobancodigital.domain.entity.ProposalEntity;
import com.eugeniomoreira.nossobancodigital.repository.AccountRepository;
import com.eugeniomoreira.nossobancodigital.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    private static final String BANK_CODE = "0341";

    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public AccountEntity createAccount(ProposalEntity proposal) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setBankCode(BANK_CODE);
        accountEntity.setAccountNumber(generateAccountNumber());
        accountEntity.setAgency(generateAgencyNumber());
        accountEntity.setAccountNumber(generateAccountNumber());
        accountEntity.setProposal(proposal);

        return repository.save(accountEntity);
    }

    private String generateAgencyNumber(){
        return String.format("%08d", new Random().nextLong());
    }

    private String generateAccountNumber(){
        return String.format("%08d", new Random().nextInt(100000));
    }

}
