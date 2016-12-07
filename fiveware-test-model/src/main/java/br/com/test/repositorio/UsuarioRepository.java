package br.com.test.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.test.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("SELECT DISTINCT usuario FROM Usuario usuario WHERE usuario.nomeCurto LIKE :nomeCurto%")
	@Transactional(readOnly = true)
	Collection<Usuario> procurarPorNomeCurto(
			@Param("nomeCurto") String nomeCurto);

	@Query("SELECT usuario FROM Usuario usuario WHERE usuario.id =:id")
	@Transactional(readOnly = true)
	Usuario procurarPorId(@Param("id") Integer id);

}
