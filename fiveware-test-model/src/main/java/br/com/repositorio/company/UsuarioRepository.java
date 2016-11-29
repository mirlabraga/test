package br.com.repositorio.company;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.company.Usuario;

public interface UsuarioRepository extends Repository<Usuario, Integer> {

	@Query("SELECT DISTINCT usuario FROM Usuario usuario WHERE usuario.nomeCurto LIKE :nomeCurto%")
	@Transactional(readOnly = true)
	Collection<Usuario> procurarPorNomeCurto(
			@Param("nomeCurto") String nomeCurto);

	@Query("SELECT usuario FROM Usuario usuario WHERE usuario.id =:id")
	@Transactional(readOnly = true)
	Usuario procurarPorId(@Param("id") Integer id);

	void save(Usuario usuario);

}
