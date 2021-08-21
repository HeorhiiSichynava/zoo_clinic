package com.hs.zoo_clinic.zoo_clinic.dao;

import com.hs.zoo_clinic.zoo_clinic.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryAnimal extends JpaRepository<Animal,Long> {
    List<Animal> findByClient_Id(Long id);
}
