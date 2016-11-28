package br.com.model.company;

import org.junit.BeforeClass;
import org.junit.Test;

public class UsuarioTest {

	private static Log log = LogFactory.getLog(UsuarioTest.class);
	private static final String PERSISTENCE_UNIT = "fiveware-test-model";
	private static EntityManagerFactory emf;

	@BeforeClass
	public static void setUpClass() {

		log.debug("creating entity manager factory");
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	@Test
	public void test() {
	}

}
