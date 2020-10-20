package com.eugeniomoreira.nossobancodigital.api;

import com.eugeniomoreira.nossobancodigital.domain.dto.ClientDTO;
import com.eugeniomoreira.nossobancodigital.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClientApi {

    private final ClientService clientService;

    public ClientApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO saveBasicData(@RequestBody ClientDTO clientDto) {
        return clientService.saveBasicClientData(clientDto);
    }

}
