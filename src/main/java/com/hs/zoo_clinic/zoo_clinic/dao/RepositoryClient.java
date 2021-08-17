package com.hs.zoo_clinic.zoo_clinic.dao;

import com.hs.zoo_clinic.zoo_clinic.dto.ClientDto;
import com.hs.zoo_clinic.zoo_clinic.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryClient extends JpaRepository<Client,Long> {
    Client save(ClientDto clientDto);
    Client findByLogin(String login);
    Client findByLoginAndPassword(String login, String password);
    Optional<Client> findById(Long id);
}
