package com.hs.zoo_clinic.zoo_clinic.dto.client;

import com.hs.zoo_clinic.zoo_clinic.model.Animal;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.List;

@Builder
@Data
@EqualsAndHashCode
public class ClientDto {
    private Long id;
    private String name;
    private String login;
    private String password;
    private List<Animal> animalDtoList;
}
