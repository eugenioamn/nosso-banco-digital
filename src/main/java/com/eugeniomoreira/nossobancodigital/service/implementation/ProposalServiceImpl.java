package com.eugeniomoreira.nossobancodigital.service.implementation;

import com.eugeniomoreira.nossobancodigital.domain.dto.AddressDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.AnswerProposalDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.ClientDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.ProposalDTO;
import com.eugeniomoreira.nossobancodigital.domain.entity.ProposalEntity;
import com.eugeniomoreira.nossobancodigital.domain.enumerable.ProposalStatus;
import com.eugeniomoreira.nossobancodigital.domain.exception.NotFoundException;
import com.eugeniomoreira.nossobancodigital.repository.ProposalRepository;
import com.eugeniomoreira.nossobancodigital.service.ClientService;
import com.eugeniomoreira.nossobancodigital.service.ProposalService;
import com.eugeniomoreira.nossobancodigital.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProposalServiceImpl implements ProposalService {

    private ProposalRepository proposalRepository;

    private ClientService clientService;

    private UploadService uploadService;

    public ProposalServiceImpl(ProposalRepository proposalRepository, ClientService clientService, UploadService uploadService) {
        this.proposalRepository = proposalRepository;
        this.clientService = clientService;
        this.uploadService = uploadService;
    }

    @Override
    public ProposalDTO createProposal(ClientDTO clientDTO) {
        ClientDTO result = clientService.saveBasicClientData(clientDTO);

        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setStatus(ProposalStatus.PENDING.getN());
        proposalEntity.setClient(ClientDTO.fromDto(result));

        return ProposalDTO.toDto(proposalRepository.save(proposalEntity));
    }

    @Override
    public ProposalDTO addAddressData(Long proposalId, AddressDTO addressDTO) throws NotFoundException {
        ProposalEntity proposalEntity = proposalRepository.findById(proposalId).orElseThrow(NotFoundException::new);
        clientService.updateClientWithAddress(proposalEntity.getClient().getId(), addressDTO);
        proposalEntity = proposalRepository.findById(proposalId).orElseThrow(NotFoundException::new);
        return ProposalDTO.toDto(proposalEntity);
    }

    @Override
    public ProposalDTO addDocumentData(Long proposalId, MultipartFile file) throws NotFoundException {
        ProposalEntity proposalEntity = proposalRepository.findById(proposalId).orElseThrow(NotFoundException::new);

        String fileUpload = uploadService.saveFileUpload(file);

        clientService.saveDocumentFile(proposalEntity.getClient().getId(), fileUpload);

        return new ProposalDTO();
    }

    @Override
    public ProposalDTO getClientData(Long proposalId) throws NotFoundException {
        ProposalEntity proposalEntity = proposalRepository.findById(proposalId).orElseThrow(NotFoundException::new);

        return ProposalDTO.toDto(proposalEntity);
    }

    @Override
    public AnswerProposalDTO proposalAnswer(Long proposalId, Integer status) throws NotFoundException {
        ProposalEntity proposalEntity = proposalRepository.findById(proposalId).orElseThrow(NotFoundException::new);

        if(isValid(status)){
            proposalEntity.setStatus(status);
        }

        proposalRepository.save(proposalEntity);

        AnswerProposalDTO answerProposalDTO = new AnswerProposalDTO();
        answerProposalDTO.setMessage(getMessage(status));
        answerProposalDTO.setProposalId(proposalEntity.getId());

        return answerProposalDTO;
    }

    private Boolean isValid(Integer status) {
        if (status == null) {
            return false;
        }

        return status >= 2 && status <= 3;
    }

    private String getMessage(Integer status) {
        String message = "";
        switch (status)
        {
            case 2:
                message = "Conta criada com sucesso";
                break;
            case 3:
                message = "Que pena. Esperamos te ver por aqui depois";
                break;
            default:
                break;
        }
        return message;
    }

}
