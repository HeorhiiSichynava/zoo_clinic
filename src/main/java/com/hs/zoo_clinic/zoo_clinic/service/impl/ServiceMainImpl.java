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
    public ClientDto saveClient(ClientDto clientDto) {
        String nameMethod = "ClientDto save(ClientDto clientDto)";
        if (isNull(repositoryClient.findByLogin(clientDto.getLogin()))) {
            log.info(nameMethod + ": good request" + ServiceClient.class);
            Client client = repositoryClient.save(converterModelToDto.convertClientDtoToClient(clientDto));
            return converterModelToDto.convertClientToClientDto(client);
        }
        log.info(nameMethod + ": bad request");
        return null;
    }

    @Override
    public ClientDto findClientByLogin(String login) {
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
    public ClientDto getClientById(Long id) {
        String nameMethod = "ClientDto getClientById(Long id)";
        Client client = repositoryClient.getById(id);
        if (!isNull(client)){
            log.info(nameMethod + ": good request" + ServiceClient.class);
            return converterModelToDto.convertClientToClientDto(client);
        }
        log.info(nameMethod + ": bad request");
        return null;
    }

    @Override
    public void deleteClientById(Long id) {
        String nameMethod = "void deleteClientById(Long id)";
        Client client = repositoryClient.getById(id);

        for (Animal animal: repositoryAnimal.findByClient_Id(id)) {
            repositoryAnimal.deleteById(animal.getId());
        }

        repositoryClient.deleteById(id);
        if (isNull(client)){
            log.info(nameMethod + ": good request" + ServiceClient.class);
        }
        log.info(nameMethod + ": bad request");
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
    public List<AnimalDto> findAllAnimals() {
        String nameMethod = "List<AnimalDto> findAllAnimals()";

        List<Animal> animals = repositoryAnimal.findAll();
        if (animals != null) {
            log.info(nameMethod + ": good request" + ServiceClient.class);
            List<AnimalDto> animalDtoList = new LinkedList<>();
            for (Animal animal : animals) {
                animalDtoList.add(converterModelToDto.convertAnimalToAnimalDto(animal));
            }
            return animalDtoList;
        }
        log.info(nameMethod + ": bad request");
        return null;
    }

    @Override
    public List<ClientDto> findAll() {
        String nameMethod = "List<ClientDto> findAll()";
        List<Client> clients = repositoryClient.findAll();
        if (clients != null) {
            log.info(nameMethod + ": good request" + ServiceClient.class);
            List<ClientDto> clientDtoList = new LinkedList<>();
            for (Client client : clients) {
                clientDtoList.add(converterModelToDto.convertClientToClientDto(client));
            }
            return clientDtoList;
        }
        log.info(nameMethod + ": bad request");
        return null;
    }

    private static boolean isNull(Client client) {
        if (client == null)
            return true;
        return false;
    }

    @Override
    public AnimalDto addPetToClientId(AnimalDto animalDto) {
        String nameMethod = "AnimalDto save(AnimalDto animalDto)";
        Client client = repositoryClient.getById(animalDto.getClientId());
        if (!isNull(client)) {
            log.info(nameMethod + ": good request" + ServiceClient.class);
            Animal animal = new Animal();
            animal.setNameOfAnimal(animalDto.getNameOfAnimal());
            animal.setTypeOfAnimal(animalDto.getTypeOfAnimal());
            animal.setAgeOfAnimal(animalDto.getAgeOfAnimal());
            animal.setWeightOfAnimal(animalDto.getWeightOfAnimal());
            animal.setClient(client);
            client.addAnimal(animal);
            repositoryClient.save(client);
            repositoryAnimal.save(animal);
            return converterModelToDto.convertAnimalToAnimalDto(animal);
        }
        log.info(nameMethod + ": bad request");
        return null;
    }

    @Override
    public AnimalDto getAnimalById(Long id) {
        String nameMethod = "AnimalDto getAnimalById(Long id)";
        Animal animal = repositoryAnimal.getById(id);
        if (animal != null) {
            log.info(nameMethod + ": good request" + ServiceClient.class);
            return converterModelToDto.convertAnimalToAnimalDto(animal);
        }
        log.info(nameMethod + ": bad request");
        return null;
    }

    @Override
    public void deleteAnimalById(Long id) {
        String nameMethod = "deleteAnimalById(Long id)";
        repositoryAnimal.deleteById(id);
        Animal animal = repositoryAnimal.getById(id);
        if (animal != null) {
            log.info(nameMethod + ": good request" + ServiceClient.class);
        } else {
            log.info(nameMethod + ": bad request");
        }
    }

    @Override
    public List<AnimalResponse> findByClient_Id(Long id) {
        String nameMethod = "List<AnimalResponse> findByClient_Id(Long id)";
        List<Animal> animals = repositoryAnimal.findByClient_Id(id);
        if (animals != null) {
            log.info(nameMethod + ": good request" + ServiceClient.class);
            List<AnimalResponse> animalDtoList = new ArrayList<>();
            for (Animal animal : animals) {
                animalDtoList.add(converterModelToDto.convertAnimalToAnimalResponse(animal));
            }

            return animalDtoList;
        }
        log.info(nameMethod + ": bad request");
        return null;
    }
}
