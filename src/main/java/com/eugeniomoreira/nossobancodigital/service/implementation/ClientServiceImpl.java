package com.eugeniomoreira.nossobancodigital.service.implementation;

import com.eugeniomoreira.nossobancodigital.domain.dto.AddressDTO;
import com.eugeniomoreira.nossobancodigital.domain.entity.ClientEntity;
import com.eugeniomoreira.nossobancodigital.domain.dto.ClientDTO;
import com.eugeniomoreira.nossobancodigital.domain.enumerable.ProposalStatus;
import com.eugeniomoreira.nossobancodigital.domain.exception.ClientNotFoundException;
import com.eugeniomoreira.nossobancodigital.repository.ClientRepository;
import com.eugeniomoreira.nossobancodigital.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO saveBasicClientData(ClientDTO clientDto) {
        validation(clientDto);

        ClientEntity clientEntity = ClientDTO.fromDto(clientDto);
        clientEntity.setProposalStatus(ProposalStatus.PENDING.getN());

        return ClientDTO.toDto(clientRepository.save(clientEntity));
    }

    @Override
    public ClientDTO updateClientWithAddress(Long clientId, AddressDTO addressDTO) throws ClientNotFoundException {
        ClientEntity clientEntity = clientRepository.findById(clientId).orElseThrow(ClientNotFoundException::new);
        clientEntity.setAddress(AddressDTO.fromDto(addressDTO));
        clientRepository.save(clientEntity);
        return ClientDTO.toDto(clientEntity);
    }

    @Override
    public ClientDTO getClientProposal(Long clientId) throws ClientNotFoundException {
        return ClientDTO.toDto(clientRepository.findById(clientId).orElseThrow(ClientNotFoundException::new));
    }

    @Override
    public void answerProposal(Long clientId, Integer status) throws ClientNotFoundException {
        if (status != 1 && status != 2 && status != 3) {
            return;
        }
        ClientEntity clientEntity = clientRepository.findById(clientId).orElseThrow(ClientNotFoundException::new);
        if (clientEntity.getProposalStatus() == ProposalStatus.PENDING.getN()) {
            clientEntity.setProposalStatus(status);
        }
    }

    private void validation(ClientDTO clientDto) {
        Optional.ofNullable(clientDto.getFirstName())
                .filter(firstName -> !firstName.isBlank())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "First name not sent"));

        Optional.ofNullable(clientDto.getLastName())
                .filter(lastName -> !lastName.isBlank())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Last name not sent"));

        Optional.ofNullable(clientDto.getEmail())
                .filter(email -> {
                    Matcher matcher = patternEmail.matcher(email);
                    return matcher.matches();
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email"));

        Optional.ofNullable(clientDto.getBirthDate())
                .filter(birthdate -> {
                    Matcher matcher = patternBirthDate.matcher(birthdate);
                    if (matcher.matches()) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
                        LocalDate dateOfBirth = LocalDate.parse(birthdate, formatter);
                        LocalDate dateToday = LocalDate.now();
                        Period period = Period.between(dateToday, dateOfBirth);
                        int years = Math.abs(period.getYears());
                        if (years >= 18) {
                            return true;
                        }
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid birthdate: underage");
                    }
                    return matcher.matches();
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid birthdate"));

        Optional.ofNullable(clientDto.getDocument())
                .filter(document -> {
                    Matcher matcher = patternCpf.matcher(document);
                    return matcher.matches();
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid cpf"));

        Long count = clientRepository.countByDocument(clientDto.getDocument());
        if (count > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cpf already exists");
        }

        Long countEmail = clientRepository.countByEmail(clientDto.getEmail());
        if (countEmail > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }
    }

}
