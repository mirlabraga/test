package br.com.test.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.test.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
