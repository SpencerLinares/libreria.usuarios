package com.hggl.libreria.usuarios.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {
	@Id   //Identificador PK en el modelo relacional
	@GeneratedValue(strategy=GenerationType.IDENTITY) //estrategia
	private Long id;
	private String nombre;
	@Column(unique = true)
	private String email;
	private String password;
}
