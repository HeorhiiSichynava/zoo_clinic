package com.hs.zoo_clinic.zoo_clinic.dao;

import com.hs.zoo_clinic.zoo_clinic.dto.client.ClientDto;
import com.hs.zoo_clinic.zoo_clinic.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryClient extends JpaRepository<Client,Long> {
    Client save(ClientDto clientDto);
    Client findByLogin(String login);
    Optional<Client> findById(Long id);
    Client findByLoginAndPassword(String login, String password);

    @Override
    List<Client> findAll();
}
