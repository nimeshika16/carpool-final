package com.vcarpool.services;

import java.util.List;

import com.vcarpool.dao.RideDao;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.Ride;

public class RideServiceImpl implements RideService {
	
	public RideServiceImpl() {
		
		
	}
	
	static RideDao dao = new RideDao();

	public int insert(Ride r) throws VCarpoolException {
		
		return dao.insert(r);
	}

	public int update(Ride r, String feild, String value) throws VCarpoolException {
		
		return dao.update(r, feild, value);
	}

	public Ride delet(Ride r) throws VCarpoolException {
		
		return dao.delet(r);
	}

	public List<Ride> showRides() throws VCarpoolException {

		return dao.showRides();
	}

	
	

}
