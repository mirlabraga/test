package br.com.model.company;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsuarioTest {

	private static Log log = LogFactory.getLog(UsuarioTest.class);
	private static final String PERSISTENCE_UNIT = "fiveware-test-model";
	private static EntityManagerFactory managerFactory;

	@BeforeClass
	public static void setUpClass() {
		log.debug("creating entity manager factory");
		managerFactory = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	@Test
	public void testManagerFactory() {
		Assert.assertNotNull(managerFactory);
	}

	@Test
	public void testPersiteUsuario() {

		Endereco endereco = new Endereco("Rua Carlos de Campos",
				"Vila Boa Vista", "Barueri", "SP", 848394);
		GregorianCalendar gregorianCalendar = new GregorianCalendar(1986, 4, 11);
		Date dataNascimento = gregorianCalendar.getTime();

		Usuario usuario = new Usuario("Mirla Braga", "Mirla Rafaela Braga",
				dataNascimento, Sexo.FEMININO, 12121, 32594203, 88416388,
				"mirlabraga@gmail.com", "123456", endereco);
		EntityManager entityManager = managerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
