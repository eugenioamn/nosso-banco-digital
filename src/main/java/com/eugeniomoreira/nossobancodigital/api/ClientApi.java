package com.eugeniomoreira.nossobancodigital.api;

import com.eugeniomoreira.nossobancodigital.domain.dto.AddressDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.AnswerProposalDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.ClientDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.ProposalDTO;
import com.eugeniomoreira.nossobancodigital.domain.exception.NotFoundException;
import com.eugeniomoreira.nossobancodigital.service.ProposalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/proposal")
public class ClientApi {

    private final ProposalService proposalService;

    public ClientApi(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProposalDTO> saveBasicData(@Validated @RequestBody ClientDTO clientDto) {

        ProposalDTO result = proposalService.createProposal(clientDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{proposalId}/address")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(location)
                .body(result);
    }

    @PostMapping("/{proposalId}/address")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProposalDTO> saveClientAddress(@Validated @PathVariable("proposalId") Long proposalId, @Validated @RequestBody AddressDTO addressDTO) throws NotFoundException {

        ProposalDTO result = proposalService.addAddressData(proposalId, addressDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{proposalId}/document")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(location)
                .body(result);
    }

    @PostMapping("/{proposalId}/document")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProposalDTO> saveClientDocument(@Validated @PathVariable("proposalId") Long proposalId, @Validated @RequestBody AddressDTO addressDTO) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{proposalId}")
    public ProposalDTO getClientProposal(@Validated @PathVariable("proposalId") Long proposalId) throws NotFoundException {
        return proposalService.getClientData(proposalId);
    }

    @PostMapping("/{proposalId}/answer/{status}")
    public ResponseEntity<AnswerProposalDTO> answerProposal(@Validated @PathVariable("proposalId") Long proposalId, @Validated @PathVariable("status") Integer status) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(proposalService.proposalAnswer(proposalId, status));
    }

}
