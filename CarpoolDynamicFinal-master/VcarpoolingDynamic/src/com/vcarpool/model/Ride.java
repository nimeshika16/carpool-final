package com.vcarpool.model;

public class Ride {
	
	
	public Ride() {
		
	}
	
	private String status;
	private int rideId;
	private User rider;
	private User provider;
	
	public Ride(String status, User rider, User provider) {
		super();
		this.status = status;
		this.rider = rider;
		this.provider = provider;
	}
	public Ride(String status, int rideId, User rider, User provider) {
		super();
		this.status = status;
		this.rideId = rideId;
		this.rider = rider;
		this.provider = provider;
	}
	@Override
	public String toString() {
		return "Ride [status=" + status + ", rideId=" + rideId + ", rider=" + rider + ", provider=" + provider + "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRideId() {
		return rideId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
	public User getRider() {
		return rider;
	}
	public void setRider(User rider) {
		this.rider = rider;
	}
	public User getProvider() {
		return provider;
	}
	public void setProvider(User provider) {
		this.provider = provider;
	}

	

}
