package com.baicai.awake.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface UpdateStatementCreator extends StatementCreator {


	PreparedStatement createUpdate(Connection con, final String[] cols) throws SQLException;
}
