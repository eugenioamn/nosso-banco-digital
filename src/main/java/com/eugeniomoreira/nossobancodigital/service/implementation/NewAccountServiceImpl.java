package com.eugeniomoreira.nossobancodigital.service.implementation;

import com.eugeniomoreira.nossobancodigital.domain.bean.EmailBean;
import com.eugeniomoreira.nossobancodigital.domain.entity.AccountEntity;
import com.eugeniomoreira.nossobancodigital.domain.entity.ProposalEntity;
import com.eugeniomoreira.nossobancodigital.service.AccountService;
import com.eugeniomoreira.nossobancodigital.service.EmailService;
import com.eugeniomoreira.nossobancodigital.service.NewAccountService;
import org.springframework.stereotype.Service;

@Service
public class NewAccountServiceImpl implements NewAccountService {

    private final AccountService accountService;

    private final EmailService emailService;

    public NewAccountServiceImpl(AccountService accountService, EmailService emailService) {
        this.accountService = accountService;
        this.emailService = emailService;
    }

    @Override
    public void createAccount(ProposalEntity proposal) {
        AccountEntity account = accountService.createAccount(proposal);
        account.getBankCode();
        account.getAgency();
        account.getAccountNumber();
        String text = String.format("Olá, %s\n\n" +
                        "Tudo bem? Segue abaixo dados da sua conta:\n\n" +
                        "BANCO: %s\n" +
                        "AGÊNCIA: %s\n" +
                        "CONTA: %s\n\n" +
                        "Obrigado pela atenção!",
                account.getProposal().getClient().getFirstName(),
                account.getBankCode(),
                account.getAgency(),
                account.getAccountNumber());
        EmailBean email = new EmailBean(account.getProposal().getClient().getEmail(),
                "ABERTURA DE CONTA", text);
        emailService.send(email);
    }

}
