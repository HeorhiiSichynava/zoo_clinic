package com.hs.zoo_clinic.zoo_clinic.service.impl;

import com.hs.zoo_clinic.zoo_clinic.dto.AuthResponse;
import com.hs.zoo_clinic.zoo_clinic.dao.RepositoryClient;
import com.hs.zoo_clinic.zoo_clinic.dto.AuthClientDto;
import com.hs.zoo_clinic.zoo_clinic.dto.ClientDto;
import com.hs.zoo_clinic.zoo_clinic.model.Client;
import com.hs.zoo_clinic.zoo_clinic.model.ConverterModelToDto;
import com.hs.zoo_clinic.zoo_clinic.service.ServiceClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class ServiceClientImpl implements ServiceClient {
    ConverterModelToDto converterModelToDto;
    RepositoryClient repositoryClient;

    @Autowired
    public ServiceClientImpl(ConverterModelToDto converterModelToDto, RepositoryClient clientRepo) {
        this.converterModelToDto = converterModelToDto;
        this.repositoryClient = clientRepo;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        String nameMethod = "ClientDto save(ClientDto clientDto)";
         if (isNull(repositoryClient.findByLogin(clientDto.getLogin()))) {
            Client client = repositoryClient.save(converterModelToDto.convertClientDtoToClient(clientDto));
            log.info(nameMethod+": good request"+ServiceClient.class);
            return converterModelToDto.convertClientToClientDto(client);
        }
        log.info(nameMethod+": bad request");
        return null;
    }

    @Override
    public ClientDto findByLogin(String login) {
        String nameMethod = "ClientDto findByLogin(String login)";
        Client findClient = repositoryClient.findByLogin(login);
        if (!isNull(findClient)) {
            log.info(nameMethod+": good request"+ServiceClient.class);
            return converterModelToDto.convertClientToClientDto(findClient);
        }
        log.info(nameMethod+": bad request");
        return null;
    }

    @Override
    public AuthResponse findByLoginAndPassword(AuthClientDto auth) {
        String nameMethod = "AuthResponse findByLoginAndPassword(AuthClientDto auth)";
        Client findClient = repositoryClient.findByLogin(auth.getLogin());
        if (!isNull(findClient)) {
            if (findClient.getPassword().equals(auth.getPassword())) {
                log.info(nameMethod+": good request"+ServiceClient.class);
                return new AuthResponse(converterModelToDto.convertClientToClientDto(findClient).getLogin());
            }
        }
        log.info(nameMethod+": bad request");
        return null;
    }

    private static boolean isNull(Client client) {
        if (client == null)
            return true;
        return false;
    }
}
