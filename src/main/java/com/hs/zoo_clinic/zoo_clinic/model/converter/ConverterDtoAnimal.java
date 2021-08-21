package com.hs.zoo_clinic.zoo_clinic.model.converter;

import com.hs.zoo_clinic.zoo_clinic.dto.client.AnimalDto;
import com.hs.zoo_clinic.zoo_clinic.dto.client.AnimalResponse;
import com.hs.zoo_clinic.zoo_clinic.model.Animal;

public interface ConverterDtoAnimal {
    Animal convertAnimalDtoToAnimal(AnimalDto animalDto);
    AnimalDto convertAnimalToAnimalDto(Animal animal);
    AnimalResponse convertAnimalToAnimalResponse(Animal animal);
}
