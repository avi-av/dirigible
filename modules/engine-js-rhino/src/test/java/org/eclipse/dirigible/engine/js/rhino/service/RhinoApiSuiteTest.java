package org.eclipse.dirigible.engine.js.rhino.service;

import java.io.IOException;

import javax.inject.Inject;

import org.eclipse.dirigible.api.v3.test.AbstractApiSuiteTest;
import org.eclipse.dirigible.commons.api.scripting.ScriptingException;
import org.eclipse.dirigible.engine.js.rhino.processor.RhinoJavascriptEngineExecutor;
import org.eclipse.dirigible.repository.api.IRepository;
import org.eclipse.dirigible.repository.api.RepositoryWriteException;
import org.junit.Before;
import org.junit.Test;

public class RhinoApiSuiteTest extends AbstractApiSuiteTest {

	@Inject
	private IRepository repository;

	private RhinoJavascriptEngineExecutor rhinoJavascriptEngineExecutor;

	@Before
	public void setUp() throws Exception {
		this.repository = getInjector().getInstance(IRepository.class);
		this.rhinoJavascriptEngineExecutor = getInjector().getInstance(RhinoJavascriptEngineExecutor.class);
	}

	@Test
	public void runSuite() throws RepositoryWriteException, IOException, ScriptingException {
		super.runSuite(this.rhinoJavascriptEngineExecutor, repository);
	}

}
