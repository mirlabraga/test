package br.com.model.company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class UsuarioTest {

	@BeforeClass
	public static void setUp() {
		FixtureFactoryLoader.loadTemplates("br.com.six2six.template");
	}

	/*@Test
	public void saveTest() {

		Fixture.from(Usuario.class).uses(new HibernateProcessor(session))
				.gimme("usuario-first");
	}
*/
	@Test
	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testunitario");
		EntityManager em = emf.createEntityManager();
		Assert.assertNotNull(emf);
	}

}
