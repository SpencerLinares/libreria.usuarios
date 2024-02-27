package com.hggl.libreria.usuarios.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hggl.libreria.usuarios.models.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	

}
