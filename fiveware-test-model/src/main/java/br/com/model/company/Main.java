package br.com.model.company;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Main {

	private static Log log = LogFactory.getLog(Main.class);
	private static final String PERSISTENCE_UNIT = "fiveware-test-model";
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		log.debug("creating entity manager factory");

		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}
}
