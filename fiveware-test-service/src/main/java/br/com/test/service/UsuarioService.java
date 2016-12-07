package br.com.test.service;

import java.util.List;

import br.com.test.model.Usuario;

public interface UsuarioService {
	
     List<Usuario> getAll();
     Usuario findById(int id);
     void saveUsuario(Usuario usuario);
     void deleteUsuario(int id);
}
