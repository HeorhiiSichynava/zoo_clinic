package com.hs.zoo_clinic.zoo_clinic.service;

import com.hs.zoo_clinic.zoo_clinic.dto.client.AnimalDto;
import com.hs.zoo_clinic.zoo_clinic.dto.client.AnimalResponse;

import java.util.List;

public interface ServiceAnimal {
    AnimalDto save(AnimalDto animalDto);
    List<AnimalResponse> findByClient_Id(Long id);
}
