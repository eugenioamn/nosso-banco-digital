package com.eugeniomoreira.nossobancodigital.api;

import com.eugeniomoreira.nossobancodigital.domain.dto.AddressDTO;
import com.eugeniomoreira.nossobancodigital.domain.dto.ClientDTO;
import com.eugeniomoreira.nossobancodigital.domain.exception.ClientNotFoundException;
import com.eugeniomoreira.nossobancodigital.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
public class ClientApi {

    private final ClientService clientService;

    public ClientApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO saveBasicData(@Validated @RequestBody ClientDTO clientDto) {
        return clientService.saveBasicClientData(clientDto);
    }

    @PostMapping("/create/{clientId}/updateAddress")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO saveClientAddress(@Validated @PathVariable("clientId") Long clientId, @Validated @RequestBody AddressDTO addressDTO) throws ClientNotFoundException {
        return clientService.updateClientWithAddress(clientId, addressDTO);
    }

    @GetMapping("/create/{clientId}/proposal")
    public ClientDTO getClientProposal(@Validated @PathVariable("clientId") Long clientId) throws ClientNotFoundException {
        return clientService.getClientProposal(clientId);
    }

    @PostMapping("/create/{clientId}/proposal/{status}")
    public void answerProposal(@Validated @PathVariable("clientId") Long clientId, @Validated @PathVariable("status") Integer status) throws ClientNotFoundException {
        clientService.answerProposal(clientId, status);
    }

}
