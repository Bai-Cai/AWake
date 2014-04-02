package com.baicai.awake.jdbc.orm;

import com.baicai.awake.sql.UpdateStatementCreator;

public interface ObjectMapping<T> {

	
	UpdateStatementCreator insert(T obj);

	UpdateStatementCreator update(T obj);
	
}
