package com.gojek.parkingLot.manager;

public interface ParkingLotOperations {
	
	public void createParkingLot(int size);
	
	//For multilevel parkingLot
	public void createParkingLot(int size,int levels);
	
	public void park_vehicle(ParkingLotVehicle vehicle);
	
	public void leaveParkingLot(int slot);
	

}
