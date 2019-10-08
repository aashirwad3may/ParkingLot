package com.gojek.parkingLot.manager;

public interface parkingLotOperations {
	
	public void createParkingLot(int size);
	
	//For multilevel parkingLot
	public void createParkingLot(int size,int levels);
	
	public void park_vehicle(parkingLotVehicle vehicle);
	
	public void leaveParkingLot(parkingLotVehicle vehicle);
	

}