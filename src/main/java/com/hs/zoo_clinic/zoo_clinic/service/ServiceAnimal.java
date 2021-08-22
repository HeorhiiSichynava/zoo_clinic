package com.hs.zoo_clinic.zoo_clinic.service;

import com.hs.zoo_clinic.zoo_clinic.dto.client.AnimalDto;
import com.hs.zoo_clinic.zoo_clinic.dto.client.AnimalResponse;
import com.hs.zoo_clinic.zoo_clinic.model.Animal;

import java.util.List;

public interface ServiceAnimal {
    AnimalDto addPetToClientId(AnimalDto animalDto);
    List<AnimalResponse> findByClient_Id(Long id);
    List<AnimalDto> findAllAnimals();
    AnimalDto getAnimalById(Long id);
    void deleteAnimalById(Long id);
}
