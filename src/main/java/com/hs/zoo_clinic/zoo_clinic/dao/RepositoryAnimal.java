package com.hs.zoo_clinic.zoo_clinic.dao;

import com.hs.zoo_clinic.zoo_clinic.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryAnimal extends JpaRepository<Animal,Long> {
    List<Animal> findByClient_Id(Long id);
    List<Animal> findAll();
    Animal getById(Long id);
    void deleteById(Long id);
}
