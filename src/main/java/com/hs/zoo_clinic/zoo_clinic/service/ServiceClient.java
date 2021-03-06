package com.hs.zoo_clinic.zoo_clinic.service;

import com.hs.zoo_clinic.zoo_clinic.dto.client.AnimalDto;
import com.hs.zoo_clinic.zoo_clinic.dto.client.AuthResponse;
import com.hs.zoo_clinic.zoo_clinic.dto.client.AuthClientDto;
import com.hs.zoo_clinic.zoo_clinic.dto.client.ClientDto;
import com.hs.zoo_clinic.zoo_clinic.model.Animal;

import java.util.List;

public interface ServiceClient {
    ClientDto saveClient(ClientDto clientDto);
    ClientDto findClientByLogin(String login);
    ClientDto getClientById(Long id);
    AuthResponse findByLoginAndPassword(AuthClientDto auth);
    List<ClientDto> findAll();
    void deleteClientById(Long id);
}
