/*******************************************************************************
 * Copyright (c) 2013 Bowen Cai.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Bowen Cai - initial API and implementation
 ******************************************************************************/
package com.baicai.awake.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;


public class SQLUpdate extends BaseBuilder{


	StringBuilder columns = null;
	StringBuilder values = null;
	
	public void insert(String table, Map<String, Object> content) {

		builder.append("INSERT INTO ").append(table);
		
		values = new StringBuilder(32);
		values.append(" VALUES(");
		
		columns = new StringBuilder(128);
		columns.append('(');
		for (Map.Entry<String, Object> pair: content.entrySet()) {
			
			columns.append(pair.getKey()).append(',');
			
			values.append('?').append(',');
			
			parameters.add(pair.getValue());
		}
		columns.setCharAt(columns.lastIndexOf(","), ')');
		values.setCharAt(values.lastIndexOf(","), ')');
		
		builder.append(columns).append(values);
	}
	
	public SQLUpdate insertInto(String table) {
		builder.append("INSERT INTO ").append(table);
		return this;
	}
	
	public SQLUpdate put(String col, Object var) {
		if (columns == null || columns.length() == 0) {
			columns = new StringBuilder(128);
			columns.append('(');
		}
		if (values == null || values.length() == 0) {
			values = new StringBuilder(32);
			values.append(" VALUES(");
		}
		columns.append(col).append(',');
		values.append('?').append(',');
		parameters.add(var);
		return this;
	}
	public SQLUpdate put(String col, Object var, int type) {
		return this;
	}
	
	public SQLUpdate() {
	}
	
	Connection connection;
	public SQLUpdate(Connection co) {
		connection = co;
	}
	
	public boolean execute() throws SQLException {
		
		PreparedStatement ps;
		if (columns != null || columns.length() != 0) {
			columns.setCharAt(columns.lastIndexOf(","), ')');

			if (values != null || values.length() != 0) {
				values.setCharAt(values.lastIndexOf(","), ')');
			}
			builder.append(columns).append(values);
		}
		ps = build(connection);
		System.err.println(ps.toString());
		return ps.execute();
	}
}






