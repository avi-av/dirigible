/*******************************************************************************
 * Copyright (c) 2017 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * SAP - initial API and implementation
 *******************************************************************************/

package org.eclipse.dirigible.repository.local;

import org.eclipse.dirigible.repository.api.IMasterRepository;

public class ZipMasterRepository extends ZipRepository implements IMasterRepository {

	public ZipMasterRepository(String user, String zip) throws LocalBaseException {
		super(user, zip);
	}

}