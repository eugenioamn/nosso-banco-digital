package com.eugeniomoreira.nossobancodigital.service;

import com.eugeniomoreira.nossobancodigital.TestSetup;
import com.eugeniomoreira.nossobancodigital.domain.dto.ClientDTO;
import com.eugeniomoreira.nossobancodigital.domain.entity.AddressEntity;
import com.eugeniomoreira.nossobancodigital.domain.entity.ClientEntity;
import com.eugeniomoreira.nossobancodigital.domain.exception.BadRequestException;
import com.eugeniomoreira.nossobancodigital.repository.ClientRepository;
import com.eugeniomoreira.nossobancodigital.service.implementation.ClientServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest extends TestSetup {

    @InjectMocks
    private ClientServiceImpl service;

    @Mock
    private ClientRepository repository;

    @Override
    public void init() {
    }

    private ClientEntity getClient() {
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        return clientEntity;
    }

    private AddressEntity getAddress() {
        AddressEntity addressEntity = new AddressEntity("45820-000", "Rua Paulino Mendes Lima",
                "Centro", "Apartamento 305", "Bahia", "Brasil");
        return addressEntity;
    }

    @Test
    public void saveBasicClientDataTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        service.saveBasicClientData(ClientDTO.toDto(getClient()));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataFirstNameNullTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity(null, "Moreira", "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataFirstNameBlankTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity("", "Moreira", "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataFirstNameBlankSpaceTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity("  ", "Moreira", "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataLastNameNullTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity("Eugênio", null, "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataLastNameBlankTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity("Eugênio", "", "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataLastNameBlankSpaceTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity("Eugênio", "  ", "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataEmailNullTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", null,
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataEmailInvalidTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste_de_email",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataBirthdateNullTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste@teste.com",
                null, "835.331.640-47", getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataBirthdateInvalidTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste@teste.com",
                "01012001", "835.331.640-47", getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataCpfNullTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste@teste.com",
                "01/01/2001", null, getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataCpfInvalidTest() {
        when(repository.save(any(ClientEntity.class))).thenReturn(getClient());
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste@teste.com",
                "01/01/2001", "83533164047", getAddress(), 1);
        service.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(repository).save(any(ClientEntity.class));
    }

}
