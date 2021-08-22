package com.hs.zoo_clinic.zoo_clinic.dto.client;

import com.hs.zoo_clinic.zoo_clinic.model.Client;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalDto {
    private Long    id              ;
    private String  nameOfAnimal    ;
    private String  typeOfAnimal    ;
    private Integer ageOfAnimal     ;
    private Integer weightOfAnimal  ;
    private Long    clientId        ;
}
