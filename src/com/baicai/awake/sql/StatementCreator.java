package com.baicai.awake.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementCreator {

	
	PreparedStatement createStatement(Connection con) throws SQLException;
}
