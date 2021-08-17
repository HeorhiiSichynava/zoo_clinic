package com.hs.zoo_clinic.zoo_clinic.dto.client;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDto {
    private Long id;
    private String login;
    private String password;
}
