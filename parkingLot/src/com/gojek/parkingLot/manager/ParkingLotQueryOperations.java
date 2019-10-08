package com.gojek.parkingLot.manager;

import java.util.List;

public interface ParkingLotQueryOperations {
	
	public void parkingLot_status();
	
	public List<String> regnum_cars_with_color(String color);
	
	public List<Integer> slotnum_cars_with_color(String color);
	
	public int slotnum_for_regnum(String registration_num);

}
