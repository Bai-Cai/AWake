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
package com.baicai.awake.jdbc;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.baicai.awake.jdbc.orm.ObjectMapping;
import com.baicai.awake.jdbc.orm.RowMapping;
import com.baicai.awake.sql.BaseBuilder;
import com.baicai.awake.sql.StatementCreator;
import com.baicai.awake.sql.UpdateStatementCreator;


public interface JdbcOperations {

	boolean execute(final String sql);
	boolean execute(final String sql, Object...params);
	boolean execute(BaseBuilder builder);
	
	/**
	 * basic ();
	 * @param psc
	 * @return
	 */
	boolean execute(StatementCreator psc);
	
	int update(final String sql);
	int update(final String sql, Object...params);
	int update(BaseBuilder builder);
	int update(StatementCreator psc);
	<T> int update(T obj, ObjectMapping<T> mapper);
	
	/**
	 *  for insertion without returning keys, consider update();
	 * @param sql
	 * @param cols
	 * @return
	 */
	Map<String, Object> insert(final String sql, final String[] cols);
	Map<String, Object> insert(final String sql, final String[] cols, Object...params);
	Map<String, Object> insert(BaseBuilder builder, final String[] cols);
	
	/**
	 * T the object type, E: the result type, usually the generated K
	 * @param obj
	 * @param mapper
	 * @return
	 */
	<T> Map<String, Object> insert(final T obj, ObjectMapping<T> mapper, final String[] cols);
	/**
	 * base
	 * @param psc
	 * @param cols
	 * @return
	 */
	<T> Map<String, T> insert(UpdateStatementCreator psc, final String[] cols);
	int[] batchUpdate(final String... sql);
//	int[] batchUpdate(StatementCreator... builder);
	
	
	
	<T> T queryForObject(final String sql, Class<T> type);
	<T> T queryForObject(final String sql, Class<T> type, final Object...params);
	<T> T queryForObject(BaseBuilder builder, Class<T> type);
	<T> T queryForObject(final StatementCreator psc, Class<T> type);
	
	<T> T queryForObject(final String sql, RowMapping<T>mapper);
	<T> T queryForObject(final String sql, RowMapping<T>mapper, Object...params);
	<T> T queryForObject(BaseBuilder builder, RowMapping<T>mapper);
	<T> T queryForObject(final StatementCreator psc, RowMapping<T>mapper);
	
	
	
	<T> List<T> queryForList(final String sql, Class<T> type);
	<T> List<T> queryForList(final String sql, Class<T> type, final Object...params);
	<T> List<T> queryForList(BaseBuilder builder, Class<T> type);
	<T> List<T> queryForList(final StatementCreator psc, Class<T> type);
	
	<T> List<T> queryForList(final String sql, RowMapping<T>mapper);
	<T> List<T> queryForList(final String sql, RowMapping<T>mapper, Object...params);
	<T> List<T> queryForList(BaseBuilder builder, RowMapping<T>mapper);
	<T> List<T> queryForList(final StatementCreator psc, RowMapping<T>mapper);
	
	Map<String, Object> queryForMap(final String sql);
	Map<String, Object> queryForMap(final String sql, Object...params);
	Map<String, Object> queryForMap(BaseBuilder builder);
	Map<String, Object> queryForMap(final StatementCreator psc);

	
	ResultSet queryForResultSet(final String sql);
	ResultSet queryForResultSet(final String sql, Object...params);
	ResultSet queryForResultSet(BaseBuilder builder);
	ResultSet queryForResultSet(final StatementCreator psc);
	
}

//
//public interface JdbcOperations {
//
//
//	<T> T execute(ConnectionCallback<T> action) throws DataAccessException;
//
//	<T> T execute(StatementCallback<T> action) throws DataAccessException;
//
//	<T> T execute(CallableStatementCreator csc, CallableStatementCallback<T> action)
//			throws DataAccessException;
//
//	void execute(String sql) throws DataAccessException;
//
//	<T> T query(String sql, ResultSetExtractor<T> rse) throws DataAccessException;
//
//	<T> T execute(PreparedStatementCreator psc, PreparedStatementCallback<T> action)
//			throws DataAccessException;
//
//	<T> T execute(String sql, PreparedStatementCallback<T> action) throws DataAccessException;
//
//
////	void query(String sql, RowCallbackHandler rch) throws DataAccessException;
//
//	<T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException;
//	
//	<T> T query(PreparedStatementCreator psc, ResultSetExtractor<T> rse) throws DataAccessException;
//
//	<T> T query(String sql, PreparedStatementSetter pss, ResultSetExtractor<T> rse)
//			throws DataAccessException;
//
//	<T> T query(String sql, Object[] args, int[] argTypes, ResultSetExtractor<T> rse)
//			throws DataAccessException;
//
//	<T> T query(String sql, Object[] args, ResultSetExtractor<T> rse) throws DataAccessException;
//
//	<T> T query(String sql, ResultSetExtractor<T> rse, Object... args) throws DataAccessException;
//
//
//	void query(PreparedStatementCreator psc, RowCallbackHandler rch) throws DataAccessException;

//
//	SqlRowSet queryForRowSet(String sql, Object[] args, int[] argTypes) throws DataAccessException;
//
//	SqlRowSet queryForRowSet(String sql, Object... args) throws DataAccessException;
//
//	int update(PreparedStatementCreator psc) throws DataAccessException;
//
//	int update(PreparedStatementCreator psc, KeyHolder generatedKeyHolder) throws DataAccessException;

//	int update(String sql, PreparedStatementSetter pss) throws DataAccessException;
//
//	int update(String sql, Object[] args, int[] argTypes) throws DataAccessException;
//
//	int update(String sql, Object... args) throws DataAccessException;
//
//	int[] batchUpdate(String sql, BatchPreparedStatementSetter pss) throws DataAccessException;
//
//
//	int update(String sql) throws DataAccessException;
//
//	int[] batchUpdate(String[] sql) throws DataAccessException;
//
//	public int[] batchUpdate(String sql, List<Object[]> batchArgs);
//
//
//	public int[] batchUpdate(String sql, List<Object[]> batchArgs, int[] argTypes);
//
//
//	public <T> int[][] batchUpdate(String sql, Collection<T> batchArgs, int batchSize, ParameterizedPreparedStatementSetter<T> pss);
//
//
//
//	Map<String, Object> call(CallableStatementCreator csc, List<SqlParameter> declaredParameters)
//			throws DataAccessException;
//}
