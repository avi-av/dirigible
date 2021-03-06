/*
 * Copyright (c) 2017 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * SAP - initial API and implementation
 */

package org.eclipse.dirigible.repository.master.jar;

import java.io.IOException;

import org.eclipse.dirigible.repository.api.IMasterRepository;
import org.eclipse.dirigible.repository.local.LocalRepositoryException;

/**
 * The Jar Master Repository.
 */
public class JarMasterRepository extends JarRepository implements IMasterRepository {

	public static final String TYPE = "jar";

	/** The Constant DIRIGIBLE_MASTER_REPOSITORY_JAR_PATH. */
	public static final String DIRIGIBLE_MASTER_REPOSITORY_JAR_PATH = "DIRIGIBLE_MASTER_REPOSITORY_JAR_PATH";

	/**
	 * Instantiates a new jar master repository.
	 *
	 * @param zip
	 *            the zip
	 * @throws LocalRepositoryException
	 *             the local repository exception
	 * @throws IOException 
	 */
	public JarMasterRepository(String zip) throws LocalRepositoryException, IOException {
		super(zip);
	}

}
