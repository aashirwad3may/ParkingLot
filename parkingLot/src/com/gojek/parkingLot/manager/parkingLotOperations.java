package com.gojek.parkingLot.manager;

public interface parkingLotOperations {
	
	public String createParkingLot(int size);
	
	//For multilevel parkingLot
	public String createParkingLot(int size,int levels);
	
	public String park_vehicle(parkingLotVehicle vehicle);
	
	public String leaveParkingLot(int slot);
	

}
