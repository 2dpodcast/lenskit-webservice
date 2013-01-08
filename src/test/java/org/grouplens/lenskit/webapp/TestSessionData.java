package org.grouplens.lenskit.webapp;

import java.sql.SQLException;

import org.grouplens.lenskit.core.LenskitRecommenderEngine;
import org.grouplens.lenskit.core.LenskitRecommenderEngineFactory;
import org.junit.Before;

public class TestSessionData extends AbstractSessionTest {

	@Before
	public void init() throws SQLException {
		String configPath = ServerUtils.getFilePath(this.getClass(), "recServer.properties");
		Configuration config = new Configuration(configPath);	
		LenskitRecommenderEngineFactory recommenderEngineFactory = config.getLenskitRecommenderEngineFactory();
		LenskitRecommenderEngine engine = recommenderEngineFactory.create();
		session = new Session(engine.open());
	}
}