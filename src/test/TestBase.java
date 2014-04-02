/*******************************************************************************
 * Copyright (c) 2013 BowenCai.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     BowenCai - initial API and implementation
 ******************************************************************************/
package test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestBase {

//	public JdbcTemplate thisJdbc;
	public ComboPooledDataSource cpds;
	public void getConnected() {
		
		cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysqljdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		cpds.setJdbcUrl("jdbc:mysql://localhost:3456/bw_web");
		cpds.setUser("cbw");
		cpds.setPassword("test");
		cpds.setMinPoolSize(1);
		cpds.setAcquireIncrement(3);
		cpds.setMaxPoolSize(10);
		
//		thisJdbc = new JdbcTemplate(cpds, false);
		
	}
	
	public Connection getConnection() {
		if (connection == null) {
			try {
				return cpds.getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} else {
			return connection;
		}
	}
	public void closeConnections() {

			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	Connection connection;
	public void setUpDirectConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3456/bw_web",
				"cbw",
				"dev-test"
				);
	}
	public Connection getSingle(){
		return connection;
	}
	public void closeSingle() throws SQLException {
		connection.close();
	}
}








