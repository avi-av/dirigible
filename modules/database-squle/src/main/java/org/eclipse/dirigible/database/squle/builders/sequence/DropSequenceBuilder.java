/*******************************************************************************
 * Copyright (c) 2017 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * SAP - initial API and implementation
 *******************************************************************************/

package org.eclipse.dirigible.database.squle.builders.sequence;

import org.eclipse.dirigible.database.squle.ISquleDialect;
import org.eclipse.dirigible.database.squle.builders.AbstractDropSquleBuilder;

public class DropSequenceBuilder extends AbstractDropSquleBuilder {
	
	private String sequence = null;
	
	public DropSequenceBuilder(ISquleDialect dialect, String sequence) {
		super(dialect);
		this.sequence = sequence;
	}

	@Override
	public String generate() {
		
		StringBuilder sql = new StringBuilder();
		
		// DROP
		generateDrop(sql);
		
		// SEQUENCE
		generateSequence(sql);
		
		return sql.toString();
	}
	
	protected void generateSequence(StringBuilder sql) {
		sql.append(SPACE)
			.append(KEYWORD_SEQUENCE)
			.append(SPACE)
			.append(this.sequence);
	}
	
	public String getSequence() {
		return sequence;
	}
	
}
