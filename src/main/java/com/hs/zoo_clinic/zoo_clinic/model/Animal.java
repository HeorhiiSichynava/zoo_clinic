package com.hs.zoo_clinic.zoo_clinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "animal")
@Data
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name_of_animal")
    private String nameOfAnimal;
    @Column(name = "type_of_animal")
    private String typeOfAnimal;
    @Column(name = "age_of_animal")
    private Integer ageOfAnimal;
    @Column(name = "weight_of_animal")
    private Integer weightOfAnimal;
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;
}
