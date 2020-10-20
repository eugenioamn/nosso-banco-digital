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
    private ClientServiceImpl clientServiceImpl;

    @Mock
    private ClientRepository clientRepository;

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
        when(clientRepository.save(any(ClientEntity.class))).thenReturn(getClient());
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(getClient()));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataFirstNameNullTest() {
        ClientEntity clientEntity = new ClientEntity(null, "Moreira", "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataFirstNameBlankTest() {
        ClientEntity clientEntity = new ClientEntity("", "Moreira", "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataFirstNameBlankSpaceTest() {
        ClientEntity clientEntity = new ClientEntity("  ", "Moreira", "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataLastNameNullTest() {
        ClientEntity clientEntity = new ClientEntity("Eugênio", null, "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataLastNameBlankTest() {
        ClientEntity clientEntity = new ClientEntity("Eugênio", "", "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataLastNameBlankSpaceTest() {
        ClientEntity clientEntity = new ClientEntity("Eugênio", "  ", "teste@teste.com",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataEmailNullTest() {
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", null,
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataEmailInvalidTest() {
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste_de_email",
                "01/01/2001", "835.331.640-47", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataBirthdateNullTest() {
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste@teste.com",
                null, "835.331.640-47", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataBirthdateInvalidTest() {
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste@teste.com",
                "01012001", "835.331.640-47", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataBirthdateUnderageTest() {
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste@teste.com",
                "01/01/2003", "835.331.640-47", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataCpfNullTest() {
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste@teste.com",
                "01/01/2001", null, getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test(expected = BadRequestException.class)
    public void saveBasicClientDataCpfInvalidTest() {
        ClientEntity clientEntity = new ClientEntity("Eugênio", "Moreira", "teste@teste.com",
                "01/01/2001", "83533164047", getAddress(), 1);
        clientServiceImpl.saveBasicClientData(ClientDTO.toDto(clientEntity));
        verify(clientRepository).save(any(ClientEntity.class));
    }

}
