package com.hs.zoo_clinic.zoo_clinic.service.impl;

import com.hs.zoo_clinic.zoo_clinic.dao.RepositoryAnimal;
import com.hs.zoo_clinic.zoo_clinic.dto.client.*;
import com.hs.zoo_clinic.zoo_clinic.dao.RepositoryClient;
import com.hs.zoo_clinic.zoo_clinic.model.Animal;
import com.hs.zoo_clinic.zoo_clinic.model.Client;
import com.hs.zoo_clinic.zoo_clinic.model.converter.ConverterModelToDto;
import com.hs.zoo_clinic.zoo_clinic.service.ServiceAnimal;
import com.hs.zoo_clinic.zoo_clinic.service.ServiceClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Log
@Service
public class ServiceMainImpl implements ServiceClient, ServiceAnimal {
    ConverterModelToDto converterModelToDto;
    RepositoryClient repositoryClient;
    RepositoryAnimal repositoryAnimal;

    @Autowired
    public ServiceMainImpl(ConverterModelToDto converterModelToDto, RepositoryClient repositoryClient, RepositoryAnimal repositoryAnimal) {
        this.converterModelToDto = converterModelToDto;
        this.repositoryClient = repositoryClient;
        this.repositoryAnimal = repositoryAnimal;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        String nameMethod = "ClientDto save(ClientDto clientDto)";
        if (isNull(repositoryClient.findByLogin(clientDto.getLogin()))) {
            Client client = repositoryClient.save(converterModelToDto.convertClientDtoToClient(clientDto));
            log.info(nameMethod + ": good request" + ServiceClient.class);
            return converterModelToDto.convertClientToClientDto(client);
        }
        log.info(nameMethod + ": bad request");
        return null;
    }

    @Override
    public ClientDto findByLogin(String login) {
        String nameMethod = "ClientDto findByLogin(String login)";
        Client findClient = repositoryClient.findByLogin(login);
        if (!isNull(findClient)) {
            log.info(nameMethod + ": good request" + ServiceClient.class);
            return converterModelToDto.convertClientToClientDto(findClient);
        }
        log.info(nameMethod + ": bad request");
        return null;
    }

    @Override
    public AuthResponse findByLoginAndPassword(AuthClientDto auth) {
        String nameMethod = "AuthResponse findByLoginAndPassword(AuthClientDto auth)";
        Client findClient = repositoryClient.findByLogin(auth.getLogin());
        if (!isNull(findClient)) {
            if (findClient.getPassword().equals(auth.getPassword())) {
                log.info(nameMethod + ": good request" + ServiceClient.class);
                return new AuthResponse(converterModelToDto.convertClientToClientDto(findClient).getLogin());
            }
        }
        log.info(nameMethod + ": bad request");
        return null;
    }

    @Override
    public List<ClientDto> findAll() {
        List<Client> clients = repositoryClient.findAll();
        List<ClientDto> clientDtoList = new LinkedList<>();
        for (Client client:clients) {
            clientDtoList.add(converterModelToDto.convertClientToClientDto(client));
        }
        return clientDtoList;
    }

    private static boolean isNull(Client client) {
        if (client == null)
            return true;
        return false;
    }

    @Override
    public AnimalDto save(AnimalDto animalDto) {
        String nameMethod = "AnimalDto save(AnimalDto animalDto)";
        Client client =repositoryClient.findByLogin(animalDto.getLoginOfClient());
        if (!isNull(client)) {
            Animal animal = new Animal();
            animal.setNameOfAnimal(animalDto.getNameOfAnimal());
            animal.setTypeOfAnimal(animalDto.getTypeOfAnimal());
            animal.setAgeOfAnimal(animalDto.getAgeOfAnimal());
            animal.setWeightOfAnimal(animalDto.getWeightOfAnimal());
            animal.setClient(client);
            client.addAnimal(animal);
            repositoryClient.save(client);
            repositoryAnimal.save(animal);
            log.info(nameMethod + ": good request" + ServiceClient.class);
            return converterModelToDto.convertAnimalToAnimalDto(animal);
        }
        log.info(nameMethod + ": bad request");
        return null;
    }

    @Override
    public List<AnimalResponse> findByClient_Id(Long id) {
//        Optional<Client> client = repositoryClient.findById(id);

        List<Animal> animals = repositoryAnimal.findByClient_Id(id);
        List<AnimalResponse> animalDtoList = new ArrayList<>();
        for (Animal animal:animals) {
            animalDtoList.add(converterModelToDto.convertAnimalToAnimalResponse(animal));
        }

        return animalDtoList;
    }
}
