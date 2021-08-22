package com.hs.zoo_clinic.zoo_clinic.dao;

import com.hs.zoo_clinic.zoo_clinic.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryClient extends JpaRepository<Client,Long> {
    Client save(Client client);
//    Client update(Client client);
    Client getById(Long id);
    void deleteById(Long id);
    Client findByLogin(String login);
    Client findByLoginAndPassword(String login, String password);
    @Override
    List<Client> findAll();
}
