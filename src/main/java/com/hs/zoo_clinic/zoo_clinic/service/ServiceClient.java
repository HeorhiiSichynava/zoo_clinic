package com.hs.zoo_clinic.zoo_clinic.service;

import com.hs.zoo_clinic.zoo_clinic.dao.AuthResponse;
import com.hs.zoo_clinic.zoo_clinic.dto.AuthClientDto;
import com.hs.zoo_clinic.zoo_clinic.dto.ClientDto;

public interface ServiceClient {
    ClientDto save(ClientDto clientDto);
    ClientDto findByLogin(String login);
    AuthResponse findByLoginAndPassword(AuthClientDto auth);
}
