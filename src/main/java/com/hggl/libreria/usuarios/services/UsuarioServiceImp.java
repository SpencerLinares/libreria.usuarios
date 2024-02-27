package com.hggl.libreria.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hggl.libreria.usuarios.models.entity.Usuario;
import com.hggl.libreria.usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional (readOnly = true)
	public List<Usuario> listar() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Usuario> buscarPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void eliminar(Long id) {
		usuarioRepository.deleteById(id);
	}

}