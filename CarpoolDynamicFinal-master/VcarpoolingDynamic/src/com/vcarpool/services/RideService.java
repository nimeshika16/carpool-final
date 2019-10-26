package com.vcarpool.services;

import java.util.List;

import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.Ride;

public interface RideService {
	

	public int insert(Ride r) throws VCarpoolException;

	public int update(Ride r, String feild, String value) throws VCarpoolException;

	public Ride delet(Ride r) throws VCarpoolException;
	
	public List<Ride> showRides() throws VCarpoolException;
	
}
