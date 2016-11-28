package br.com.model.company;

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
		managerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	@Test
	public void test() {
		Assert.assertNotNull(managerFactory);
	}
}
