package com.hggl.libreria.usuarios.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hggl.libreria.usuarios.models.entity.Usuario;
import com.hggl.libreria.usuarios.services.UsuarioService;

@RestController
@RequestMapping ("/api/usuarios")
public class UsuariosController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> listar(){
		return usuarioService.listar();
	}
    @GetMapping("/{id}")
    public ResponseEntity<?> ListarPorId(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = usuarioService.buscarPorId(id);
        if(usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<?> crear (@RequestBody Usuario usuario){
    	return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuario));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar (@RequestBody Usuario usuario, @PathVariable Long id){
    	Optional <Usuario> o = usuarioService.buscarPorId(id);
    	if (o.isPresent()) {
    		Usuario usuarioDB = o.get();
    		usuarioDB.setNombre(usuario.getNombre());
    		usuarioDB.setEmail(usuario.getEmail());
    		usuarioDB.setPassword(usuario.getPassword());
    		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuarioDB));
    	}
    	return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
    	Optional <Usuario> o = usuarioService.buscarPorId(id);
    	if(o.isPresent()) {
    		usuarioService.eliminar(id);
    		return ResponseEntity.noContent().build();
    	}
    	return ResponseEntity.notFound().build();
    }
}

