package com.baicai.awake.jdbc.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapping<T> {

	T rowToObjec(ResultSet rs) throws SQLException;
}
