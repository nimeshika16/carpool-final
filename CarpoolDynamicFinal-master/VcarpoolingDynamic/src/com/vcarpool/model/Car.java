package com.vcarpool.model;

public class Car {

	public Car() {
		 
	}
	
	private String regNo;
	private String carName;
	private int seatsAvailable;
	private String source;
	private String destination;
	private String deptTime;	
	
	
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDeptTime() {
		return deptTime;
	}
	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}
	
	public Car(String regNo, String carName, int seatsAvailable, String source, String destination, String deptTime) {
		super();
		this.regNo = regNo;
		this.carName = carName;
		this.seatsAvailable = seatsAvailable;
		this.source = source;
		this.destination = destination;
		this.deptTime = deptTime;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carName == null) ? 0 : carName.hashCode());
		result = prime * result + ((deptTime == null) ? 0 : deptTime.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((regNo == null) ? 0 : regNo.hashCode());
		result = prime * result + seatsAvailable;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carName == null) {
			if (other.carName != null)
				return false;
		} else if (!carName.equals(other.carName))
			return false;
		if (deptTime == null) {
			if (other.deptTime != null)
				return false;
		} else if (!deptTime.equals(other.deptTime))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (regNo == null) {
			if (other.regNo != null)
				return false;
		} else if (!regNo.equals(other.regNo))
			return false;
		if (seatsAvailable != other.seatsAvailable)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", carName=" + carName + ", seatsAvailable=" + seatsAvailable + ", source="
				+ source + ", destination=" + destination + ", deptTime=" + deptTime + "]";
	}
	
	
	
	

	
	
}
