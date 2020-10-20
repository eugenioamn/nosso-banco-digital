package com.eugeniomoreira.nossobancodigital.service;

import com.eugeniomoreira.nossobancodigital.domain.dto.AddressDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.ClientDTO;
import com.eugeniomoreira.nossobancodigital.domain.exception.ClientNotFoundException;

public interface ClientService {

    ClientDTO saveBasicClientData(ClientDTO clientDto);

    ClientDTO updateClientWithAddress(Long clientId, AddressDTO addressDTO) throws ClientNotFoundException;

    ClientDTO getClientProposal(Long clientId) throws ClientNotFoundException;

    void answerProposal(Long clientId, Integer status) throws ClientNotFoundException;

}
