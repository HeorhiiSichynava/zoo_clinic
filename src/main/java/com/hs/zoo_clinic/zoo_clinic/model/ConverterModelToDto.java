package com.hs.zoo_clinic.zoo_clinic.model;

import com.hs.zoo_clinic.zoo_clinic.dto.ClientDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ConverterModelToDto {

    public Client convertClientDtoToClient(ClientDto clientDto){
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setLogin(clientDto.getLogin());
        client.setPassword(clientDto.getPassword());
        return client;
    }

    public ClientDto convertClientToClientDto(Client client){
        ClientDto clientDto = ClientDto.builder()
                .id(client.getId())
                .login(client.getLogin())
                .password(client.getPassword())
                .build();
        return clientDto;
    }
}
