/*
 * Copyright (c) 2017 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * SAP - initial API and implementation
 */

package org.eclipse.dirigible.engine.api.script;

import static java.text.MessageFormat.format;

import java.util.HashSet;
import java.util.ServiceLoader;
import java.util.Set;

import org.eclipse.dirigible.commons.api.module.StaticInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A factory for creating ScriptEngineExecutor objects.
 */
public class ScriptEngineExecutorFactory {

	private static final ServiceLoader<IScriptEngineExecutor> SCRIPT_ENGINE_EXECUTORS = ServiceLoader.load(IScriptEngineExecutor.class);

	private static final Logger logger = LoggerFactory.getLogger(ScriptEngineExecutorFactory.class);

	/**
	 * Gets the script engine executor.
	 *
	 * @param type
	 *            the type
	 * @return the script engine executor
	 */
	public static IScriptEngineExecutor getScriptEngineExecutor(String type) {
		for (IScriptEngineExecutor next : SCRIPT_ENGINE_EXECUTORS) {
			if (next.getType().equals(type)) {
				return StaticInjector.getInjector().getInstance(next.getClass());
			}
		}
		logger.error(format("Script Executor of Type {0} does not exist.", type));
		return null;
	}
	
	public static Set<String> getEnginesTypes() {
		Set<String> engineTypes = new HashSet<String>();
		for (IScriptEngineExecutor next : SCRIPT_ENGINE_EXECUTORS) {
			engineTypes.add(next.getType());
		}
		return engineTypes;
	}

}
