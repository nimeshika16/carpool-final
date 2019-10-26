package com.vcarpool.services;

import java.util.ArrayList;

import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.Car;

public interface CarService {

	public boolean addCar(Car car, int fk) throws VCarpoolException;

	public boolean updateSrcDest(String checking, String source, String destination) throws VCarpoolException;

	public boolean updateDeptTime(String regNum, String timeUpdate) throws VCarpoolException;
	
	public ArrayList<Car> showCars(String source, String destination, String time,int seats) throws VCarpoolException;
	
	public boolean bookCar(String regNo, int seats) throws VCarpoolException;



}
