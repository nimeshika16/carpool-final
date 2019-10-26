package com.vcarpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vcarpool.connection.ConnectionUtil;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.Ride;
import com.vcarpool.model.User;
import com.vcarpool.services.RideService;
import com.vcarpool.services.UserServiceImpl;

public class RideDao implements RideService {
	Logger log = Logger.getLogger(RideDao.class.getName());

	public RideDao() {
		
	}

	@Override
	public int insert(Ride ride) throws VCarpoolException {

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int key = 0;
		String query = "insert into Ride(rideId, rideStatus, riderId, providerId) values(?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, ride.getRideId());
			preparedStatement.setString(2, ride.getStatus());
			preparedStatement.setInt(3, ride.getRider().getUserId());
			preparedStatement.setInt(4, ride.getProvider().getUserId());
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next())
				key = resultSet.getInt(1);
		} catch (SQLException e) {
			log.error("error-dao", e);
			throw new VCarpoolException("exception-dao");
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
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

	@Override
	public int update(Ride ride, String feild, String value) throws VCarpoolException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int key = 0;
		String query = "update ride set " + feild + "=? where rideId= ?";

		System.out.println(query);
		try {
			preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, value);
			preparedStatement.setInt(2, ride.getRideId());
			key = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error("update error- dao", e);
			throw new VCarpoolException("error-dao-update");
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
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

	@Override
	public Ride delet(Ride ride) throws VCarpoolException {

		Ride temp = ride;

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int key = 0;
		String query = "delete from ride where rideId=?";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, ride.getRideId());
			key = preparedStatement.executeUpdate();
			if (key > 0)
				return temp;
			else
				return null;
		} catch (SQLException e) {
			log.error("deletion error- dao", e);
			throw new VCarpoolException("error in deleting data");
		} finally {

			if (preparedStatement != null)
				try {
					preparedStatement.close();
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

	}

	@Override
	public List<Ride> showRides() throws VCarpoolException {
		UserServiceImpl ser = new UserServiceImpl();
		ArrayList<Ride> arr = new ArrayList<Ride>();
		ResultSet resultSet = null;
		Connection con = ConnectionUtil.getConnection();
		Statement statement = null;
		String query = "select * from ride";
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			if (resultSet == null)
				return null;
			else {
				Ride user = null;
				while (resultSet.next()) {
					user = new Ride();
					user.setRideId(resultSet.getInt("rideId"));
					user.setStatus(resultSet.getString("rideStatus"));

					User rider = ser.getUser(resultSet.getInt("riderId"));
					user.setRider(rider);
					User provider = ser.getUser(resultSet.getInt("providerId"));
					user.setProvider(provider);

					arr.add(user);
					user = null;
				}
			}
		} catch (SQLException e) {
			log.error("selection error- dao", e);
			throw new VCarpoolException("error in selecting data");
		}

		return arr;

		
	}

	
}
