package com.hs.zoo_clinic.zoo_clinic.service;

import com.hs.zoo_clinic.zoo_clinic.dto.client.AnimalDto;

import java.util.List;

public interface ServiceAnimal {
    AnimalDto save(AnimalDto animalDto);
    List<AnimalDto> findByNameOfAnimal(String nameOfAnimal);
}
