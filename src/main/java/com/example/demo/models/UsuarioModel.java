package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//Utilizo Lombok que genera los getters y setters del modelo
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String email;
    @Column
    private Integer prioridad;

}
