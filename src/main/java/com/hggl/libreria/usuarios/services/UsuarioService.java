package com.hggl.libreria.usuarios.services;

import java.util.List;
import java.util.Optional;

import com.hggl.libreria.usuarios.models.entity.Usuario;

public interface UsuarioService {
    List<Usuario> listar();
    Optional<Usuario>buscarPorId(Long i);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
    
  //¿Para que sirve una interfaz?-> Puente entre una clase y otra


}