package com.avanade.simple_bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.simple_bank.entities.Usuario;
import com.avanade.simple_bank.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario incluirUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public List<Usuario> buscarUsuariosByID(String id){
		return usuarioRepository.buscarUsuariosByID(id);
	}
}