package com.eugeniomoreira.nossobancodigital.service;

import com.eugeniomoreira.nossobancodigital.domain.dto.AddressDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.AnswerProposalDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.ClientDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.ProposalDTO;
import com.eugeniomoreira.nossobancodigital.domain.exception.NotFoundException;
import org.springframework.web.multipart.MultipartFile;

public interface ProposalService {

    ProposalDTO createProposal(ClientDTO clientDTO);

    ProposalDTO addAddressData(Long proposalId, AddressDTO addressDTO) throws NotFoundException;

    ProposalDTO addDocumentData(Long proposalId, MultipartFile file) throws NotFoundException;

    ProposalDTO getClientData(Long proposalId) throws NotFoundException;

    AnswerProposalDTO proposalAnswer(Long proposalId, Integer status) throws NotFoundException;

}
