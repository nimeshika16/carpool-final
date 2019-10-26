package com.vcarpool.model;

/*
@author hemanth;
*/

public class Bill {

	
	private int txnId;
	private String status;
	private double fare;
	private Ride rideId;
	
	public Bill(String status, double fare, Ride rideId) {
		super();
		this.status = status;
		this.fare = fare;
		this.rideId = rideId;
	}

	public Bill(int txnId, String status, double fare, Ride rideId) {
		super();
		this.txnId = txnId;
		this.status = status;
		this.fare = fare;
		this.rideId = rideId;
	}

	public int getTxnId() {
		return txnId;
	}

	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public Ride getRideId() {
		return rideId;
	}

	public void setRideId(Ride rideId) {
		this.rideId = rideId;
	}

	@Override
	public String toString() {
		return "Bill [txnId=" + txnId + ", status=" + status + ", fare=" + fare + ", rideId=" + rideId + "]";
	}
	
	
	
	
	
	
}
