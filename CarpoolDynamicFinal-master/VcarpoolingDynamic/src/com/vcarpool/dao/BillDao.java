package com.vcarpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.vcarpool.connection.ConnectionUtil;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.Bill;
import com.vcarpool.services.BillService;

public class BillDao implements   BillService{


Logger logger = Logger.getLogger(BillDao.class.getName());

@Override
public int insert(Bill bill) throws VCarpoolException {

	ResultSet resultSet = null;
	Connection connection = ConnectionUtil.getConnection();
	PreparedStatement preparedStatement = null;
	int userNo = 0;
	try {
		System.out.println(connection);
		preparedStatement = connection.prepareStatement("insert into bill(status,fare,Ride_rideId) values(?,?,?)",
				Statement.RETURN_GENERATED_KEYS

		);
		// preparedStatement.setInt(1, bill.getTxnId());
		preparedStatement.setString(1, bill.getStatus());
		preparedStatement.setDouble(2, bill.getFare());
		preparedStatement.setInt(3, bill.getRideId().getRideId());
		preparedStatement.executeUpdate();

		resultSet = preparedStatement.getGeneratedKeys();
		if (resultSet.next()) {

			userNo = resultSet.getInt(1);
			System.out.println(userNo);
		}

	} catch (SQLException e) {

		logger.error("sql error", e);
		throw new VCarpoolException(e.getMessage());
	} catch (Exception e) {
		
		logger.error("internal error", e);
		throw new VCarpoolException(e.getMessage());
	}

	finally {

		// close pstmt,connection,result set also
		try {

			if (resultSet != null) {

				resultSet.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {

			logger.error("sql error", e);
			// TODO: handle exception
			throw new VCarpoolException(" error while closing a resource contact to admin");

		} catch (Exception e) {
			// TODO: handle exception

			logger.error("internal error", e);
			throw new VCarpoolException("  contact to admin");

		}

	}

	return userNo;
}

@Override
public int delete(Bill bill) throws VCarpoolException {
	// TODO Auto-generated method stub

	ResultSet resultSet = null;
	Connection connection = ConnectionUtil.getConnection();
	PreparedStatement preparedStatement = null;
	int userNo = 0;
	try {
		System.out.println(connection);
		preparedStatement = connection.prepareStatement("delete table bill where txnId=?",
				Statement.RETURN_GENERATED_KEYS

		);
		preparedStatement.setInt(1, bill.getTxnId());
		// preparedStatement.setString(2, bill.getStatus());
		// preparedStatement.setDouble(3, bill.getFare());
		// preparedStatement.setInt(4, bill.getRideId());

		resultSet = preparedStatement.getGeneratedKeys();
		if (resultSet.next()) {

			userNo = resultSet.getInt(1);
			System.out.println(userNo);
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		logger.error("sql error", e);
		throw new VCarpoolException(e.getMessage());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		logger.error("internal error", e);
		throw new VCarpoolException(e.getMessage());
	}

	finally {

		// close pstmt,connection,result set also
		try {

			if (resultSet != null) {

				resultSet.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {

			logger.error("sql error", e);
			// TODO: handle exception
			throw new VCarpoolException(" error while closing a resource contact to admin");

		} catch (Exception e) {
			// TODO: handle exception

			logger.error("internal error", e);
			throw new VCarpoolException("contact to admin");

		}

	}
	return userNo;

}

@Override
public int update(Bill b, String field, String value) throws VCarpoolException {

	Connection con = ConnectionUtil.getConnection();
	PreparedStatement pst = null;
	ResultSet rs = null;
	int key = 0;
	String query = "update bill set " + field + "=? where txnId= ?";

	System.out.println(query);
	try {
		pst = con.prepareStatement(query);

		pst.setString(1, value);
		pst.setInt(2, b.getTxnId());
		key = pst.executeUpdate();
	} catch (SQLException e) {
		logger.error("update error- dao", e);
		throw new VCarpoolException("error-dao-update");
	} finally {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				throw new VCarpoolException();
			}
		if (pst != null)
			try {
				pst.close();
			} catch (SQLException e) {
				throw new VCarpoolException();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				throw new VCarpoolException();
			}
	}

	return key;

}

}
