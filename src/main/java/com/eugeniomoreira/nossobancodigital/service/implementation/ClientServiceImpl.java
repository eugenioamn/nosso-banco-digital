package com.eugeniomoreira.nossobancodigital.service.implementation;

import com.eugeniomoreira.nossobancodigital.domain.entity.ClientEntity;
import com.eugeniomoreira.nossobancodigital.domain.dto.ClientDTO;
import com.eugeniomoreira.nossobancodigital.repository.ClientRepository;
import com.eugeniomoreira.nossobancodigital.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO saveBasicClientData(ClientDTO clientDto) {
        ClientEntity clientEntity = clientDto.fromDto(clientDto);

        clientRepository.save(clientEntity);

        return clientDto.toDto(clientEntity);
    }

}
