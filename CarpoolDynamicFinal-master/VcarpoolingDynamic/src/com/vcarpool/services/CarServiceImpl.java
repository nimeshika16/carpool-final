package com.vcarpool.services;

import java.util.ArrayList;

import com.vcarpool.dao.CarDao;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.Car;

public class CarServiceImpl implements CarService {

	static CarDao dao = new CarDao();

	public CarServiceImpl() {
		    
	}

	public boolean addCar(Car car, int fk) throws VCarpoolException {
		return dao.addCar(car, fk);
	}

	public boolean updateSrcDest(String checking, String source, String destination) throws VCarpoolException {
		return dao.updateSrcDest(checking, source, destination);
	}

	public boolean updateDeptTime(String regNum, String timeUpdate) throws VCarpoolException {
		return dao.updateDeptTime(regNum, timeUpdate);
	}

	public ArrayList<Car> showCars(String source, String destination, String time, int seats) throws VCarpoolException {
		return dao.showCars(source, destination, time, seats);
	}
	
	public boolean bookCar(String regNo, int seats) throws VCarpoolException {
		return dao.bookCar(regNo,seats);
	}
}
