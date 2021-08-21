package com.hs.zoo_clinic.zoo_clinic.dto.client;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AnimalResponse {
    private Long client_id;
    private String nameOfClient;
    private Long animal_id;
    private String typeOfAnimal;
    private String nameOfAnimal;
}
