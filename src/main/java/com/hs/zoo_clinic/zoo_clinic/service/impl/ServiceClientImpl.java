package com.hs.zoo_clinic.zoo_clinic.service.impl;

import com.hs.zoo_clinic.zoo_clinic.dao.AuthResponse;
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
        log.info("ServiceClient->save to repository");
        if (isNull(repositoryClient.findByLogin(clientDto.getLogin()))) {
            Client client = repositoryClient.save(converterModelToDto.convertClientDtoToClient(clientDto));
            return converterModelToDto.convertClientToClientDto(client);
        }
        return null;
    }

    @Override
    public ClientDto findByLogin(String login) {
        Client findClient = repositoryClient.findByLogin(login);
        log.info("ServiceClient->findByLogin");
        if (!isNull(findClient)) {
            log.info("ServiceClient->findByLoginAndPassword-> good request");
            return converterModelToDto.convertClientToClientDto(findClient);
        }
        log.info("ServiceClient->findByLoginAndPassword-> bad request");
        return null;
    }

    @Override
    public AuthResponse findByLoginAndPassword(AuthClientDto auth) {
        Client findClient = repositoryClient.findByLogin(auth.getLogin());
        log.info("ServiceClient->findByLoginAndPassword");
        if (!isNull(findClient)) {
            if (findClient.getPassword() == auth.getPassword()) {
                log.info("ServiceClient->findByLoginAndPassword-> good request");
                return new AuthResponse(converterModelToDto.convertClientToClientDto(findClient).getLogin());
            }
        }
        log.info("ServiceClient->findByLoginAndPassword-> bad request");
        return null;
    }

    private static boolean isNull(Client client) {
        if (client == null)
            return true;
        return false;
    }
}
