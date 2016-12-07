package br.com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.test.model.Usuario;
import br.com.test.repositorio.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> getAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(int id) {
		return usuarioRepository.findOne(id);
	}

	@Override
	public void saveUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void deleteUsuario(int id) {
		usuarioRepository.delete(id);
	}
}
