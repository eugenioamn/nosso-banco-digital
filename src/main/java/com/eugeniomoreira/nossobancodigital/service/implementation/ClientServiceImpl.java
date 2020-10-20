package com.eugeniomoreira.nossobancodigital.service.implementation;

import com.eugeniomoreira.nossobancodigital.domain.dto.AddressDTO;
import com.eugeniomoreira.nossobancodigital.domain.entity.ClientEntity;
import com.eugeniomoreira.nossobancodigital.domain.dto.ClientDTO;
import com.eugeniomoreira.nossobancodigital.domain.enumerable.ProposalStatus;
import com.eugeniomoreira.nossobancodigital.domain.exception.BadRequestException;
import com.eugeniomoreira.nossobancodigital.domain.exception.ClientNotFoundException;
import com.eugeniomoreira.nossobancodigital.repository.ClientRepository;
import com.eugeniomoreira.nossobancodigital.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientServiceImpl implements ClientService {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String CPF_PATTERN = "^(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)";
    private static final String BIRTHDATE_PATTERN = "^((?:0[0-9])|(?:[1-2][0-9])|(?:3[0-1]))"
            + "/((?:0[1-9])|(?:1[0-2]))/((?:19|20)\\d{2})$";

    private static final Pattern patternEmail = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    private static final Pattern patternCpf = Pattern.compile(CPF_PATTERN, Pattern.CASE_INSENSITIVE);
    private static final Pattern patternBirthDate = Pattern.compile(BIRTHDATE_PATTERN, Pattern.CASE_INSENSITIVE);

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClientDTO saveBasicClientData(ClientDTO clientDto) {
        validation(clientDto);
        return ClientDTO.toDto(repository.save(ClientDTO.fromDto(clientDto)));
    }

    @Override
    public ClientDTO updateClientWithAddress(Long clientId, AddressDTO addressDTO) throws ClientNotFoundException {
        ClientEntity clientEntity = repository.findById(clientId).orElseThrow(ClientNotFoundException::new);
        clientEntity.setAddress(AddressDTO.fromDto(addressDTO));
        repository.save(clientEntity);
        return ClientDTO.toDto(clientEntity);
    }

    @Override
    public ClientDTO getClientProposal(Long clientId) throws ClientNotFoundException {
        return ClientDTO.toDto(repository.findById(clientId).orElseThrow(ClientNotFoundException::new));
    }

    @Override
    public void answerProposal(Long clientId, Integer status) throws ClientNotFoundException {
        if (status != 1 && status != 2 && status != 3) {
            return;
        }
        ClientEntity clientEntity = repository.findById(clientId).orElseThrow(ClientNotFoundException::new);
        if (clientEntity.getProposalStatus() == ProposalStatus.PENDING.getN()) {
            clientEntity.setProposalStatus(status);
        }
    }

    private void validation(ClientDTO clientDto) {
        Optional.ofNullable(clientDto.getFirstName())
                .filter(firstName -> !firstName.isBlank())
                .orElseThrow(() -> new BadRequestException("First name not sent"));

        Optional.ofNullable(clientDto.getLastName())
                .filter(lastName -> !lastName.isBlank())
                .orElseThrow(() -> new BadRequestException("Last name not sent"));

        Optional.ofNullable(clientDto.getEmail())
                .filter(email -> {
                    Matcher matcher = patternEmail.matcher(email);
                    return matcher.matches();
                })
                .orElseThrow(() -> new BadRequestException("Email invalid"));

        Optional.ofNullable(clientDto.getBirthDate())
                .filter(birthdate -> {
                    Matcher matcher = patternBirthDate.matcher(birthdate);
                    return matcher.matches();
                })
                .orElseThrow(() -> new BadRequestException("Birthdate invalid"));

        Optional.ofNullable(clientDto.getDocument())
                .filter(document -> {
                    Matcher matcher = patternCpf.matcher(document);
                    return matcher.matches();
                })
                .orElseThrow(() -> new BadRequestException("Cpf invalid"));
    }

}
