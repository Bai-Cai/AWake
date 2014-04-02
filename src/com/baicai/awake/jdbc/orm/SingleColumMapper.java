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
package com.baicai.awake.jdbc.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.baicai.awake.jdbc.JdbcUtil;


public class SingleColumMapper<T> implements RowMapping<T> {

	Class<T> type;
	
	public SingleColumMapper(Class<T> type) {
		super();
		this.type = type;
	}

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T rowToObjec(ResultSet rs) throws SQLException {

assert(rs.getMetaData().getColumnCount() == 1);

		T o = (T) JdbcUtil.getResultSetValue(rs, 1, type);
		if (o != null && type.isInstance(o)) {
			return o;
		} else {
			throw new RuntimeException(
					"failed to get requested value: type mismatch");
		}
	}

}




