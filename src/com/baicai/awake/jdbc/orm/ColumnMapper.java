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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

import com.baicai.awake.collection.NoCaseMap;
import com.baicai.awake.jdbc.JdbcUtil;





public class ColumnMapper implements RowMapping<Map<String, Object>>{


	@Override
	public Map<String, Object> rowToObjec(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();

		NoCaseMap<Object> m = new NoCaseMap<>(columnCount);
		
		for (int i = 1; i <= columnCount; ++i) {
			String key = JdbcUtil.lookupColumnName(md, i);
			Object var = JdbcUtil.getResultSetValue(rs, i);
			m.put(key, var);
		}
		return m;
	}

}


//public class ColumnMapRowMapper implements RowMapper<Map<String, Object>> {
//
//	@Override
//	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
//		ResultSetMetaData rsmd = rs.getMetaData();
//		int columnCount = rsmd.getColumnCount();
//		Map<String, Object> mapOfColValues = createColumnMap(columnCount);
//		for (int i = 1; i <= columnCount; i++) {
//			String key = getColumnKey(JdbcUtils.lookupColumnName(rsmd, i));
//			Object obj = getColumnValue(rs, i);
//			mapOfColValues.put(key, obj);
//		}
//		return mapOfColValues;
//	}
//
//	/**
//	 * Create a Map instance to be used as column map.
//	 * <p>By default, a linked case-insensitive Map will be created.
//	 * @param columnCount the column count, to be used as initial
//	 * capacity for the Map
//	 * @return the new Map instance
//	 * @see org.springframework.util.LinkedCaseInsensitiveMap
//	 */
//	protected Map<String, Object> createColumnMap(int columnCount) {
//		return new LinkedCaseInsensitiveMap<Object>(columnCount);
//	}
//
//	/**
//	 * Determine the key to use for the given column in the column Map.
//	 * @param columnName the column name as returned by the ResultSet
//	 * @return the column key to use
//	 * @see java.sql.ResultSetMetaData#getColumnName
//	 */
//	protected String getColumnKey(String columnName) {
//		return columnName;
//	}
//
//	/**
//	 * Retrieve a JDBC object value for the specified column.
//	 * <p>The default implementation uses the {@code getObject} method.
//	 * Additionally, this implementation includes a "hack" to get around Oracle
//	 * returning a non standard object for their TIMESTAMP datatype.
//	 * @param rs is the ResultSet holding the data
//	 * @param index is the column index
//	 * @return the Object returned
//	 * @see org.springframework.jdbc.support.JdbcUtils#getResultSetValue
//	 */
//	protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
//		return JdbcUtils.getResultSetValue(rs, index);
//	}
//
//}
