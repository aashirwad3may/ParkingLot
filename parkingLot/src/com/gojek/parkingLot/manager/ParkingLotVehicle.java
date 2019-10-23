package com.gojek.parkingLot.manager;

public abstract class ParkingLotVehicle {

	private String registration_num;
	private String color;

	public String getRegistration_num() {
		return registration_num;
	}

	public void setRegistration_num(String registration_num) {
		this.registration_num = registration_num;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "parkingLotVehichle [registration_num=" + registration_num + ", color=" + color + "]";
	}

	public void setColor(String color) {
		this.color = color;
	}

}
