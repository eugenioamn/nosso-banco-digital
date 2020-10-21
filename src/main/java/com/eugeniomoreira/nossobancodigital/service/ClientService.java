package com.eugeniomoreira.nossobancodigital.service;

import com.eugeniomoreira.nossobancodigital.domain.dto.AddressDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.ClientDTO;
import com.eugeniomoreira.nossobancodigital.domain.exception.NotFoundException;

public interface ClientService {

    ClientDTO saveBasicClientData(ClientDTO clientDto);

    ClientDTO updateClientWithAddress(Long clientId, AddressDTO addressDTO) throws NotFoundException;

    ClientDTO getClientProposal(Long clientId) throws NotFoundException;

    ClientDTO saveDocumentFile(Long clientId, String documentFile) throws NotFoundException;

}
