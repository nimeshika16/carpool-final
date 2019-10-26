package com.vcarpool.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vcarpool.exception.VCarpoolException;

public class ConnectionUtil {

	public ConnectionUtil() {
	}

	static Logger log = Logger.getLogger(ConnectionUtil.class);

	public static Connection getConnection() throws VCarpoolException {

		try {
            Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			log.error("class not found", e);
			throw new VCarpoolException("class not found!");

		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vcarpooldb", "root", "root");
		} catch (SQLException e) {
			throw new VCarpoolException("connecting failed!");
		}
		return con;

	}

	
}
