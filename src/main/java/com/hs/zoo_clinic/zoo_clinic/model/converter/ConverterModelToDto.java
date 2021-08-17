package com.hs.zoo_clinic.zoo_clinic.model.converter;

import com.hs.zoo_clinic.zoo_clinic.dto.client.AnimalDto;
import com.hs.zoo_clinic.zoo_clinic.dto.client.ClientDto;
import com.hs.zoo_clinic.zoo_clinic.model.Animal;
import com.hs.zoo_clinic.zoo_clinic.model.Client;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ConverterModelToDto implements ConverterDtoClient, ConverterDtoAnimal{

    @Override
    public Client convertClientDtoToClient(ClientDto clientDto){
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setLogin(clientDto.getLogin());
        client.setPassword(clientDto.getPassword());
        return client;
    }
    @Override
    public ClientDto convertClientToClientDto(Client client){
        ClientDto clientDto = ClientDto.builder()
                .id(client.getId())
                .login(client.getLogin())
                .password(client.getPassword())
                .build();
        return clientDto;
    }

    @Override
    public Animal convertAnimalDtoToAnimal(AnimalDto animalDto) {
        Animal animal = new Animal();
        animal.setId(animalDto.getId());
        animal.setNameOfAnimal(animalDto.getNameOfAnimal());
        animal.setTypeOfAnimal(animalDto.getTypeOfAnimal());
        animal.setAgeOfAnimal(animalDto.getAgeOfAnimal());
        animal.setWeightOfAnimal(animalDto.getWeightOfAnimal());

        return animal;
    }

    @Override
    public AnimalDto convertAnimalToAnimalDto(Animal animal) {
        AnimalDto animalDto = AnimalDto.builder()
                .id(animal.getId())
                .nameOfAnimal(animal.getNameOfAnimal())
                .typeOfAnimal(animal.getTypeOfAnimal())
                .ageOfAnimal(animal.getAgeOfAnimal())
                .weightOfAnimal(animal.getWeightOfAnimal())
                .build();
        return animalDto;
    }
}
