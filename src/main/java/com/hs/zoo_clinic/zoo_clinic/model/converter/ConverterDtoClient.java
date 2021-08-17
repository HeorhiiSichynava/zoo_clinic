package com.hs.zoo_clinic.zoo_clinic.model.converter;

import com.hs.zoo_clinic.zoo_clinic.dto.client.ClientDto;
import com.hs.zoo_clinic.zoo_clinic.model.Client;

public interface ConverterDtoClient {
    Client convertClientDtoToClient(ClientDto clientDto);
    ClientDto convertClientToClientDto(Client client);
}
