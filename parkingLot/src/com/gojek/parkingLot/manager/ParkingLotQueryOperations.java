package com.gojek.parkingLot.manager;

import java.util.List;

public interface ParkingLotQueryOperations {
	
	public void parkingLot_status();
	
	public int getavalaibleslot();
	
	public String regnum_cars_with_color(String color);
	
	public String slotnum_cars_with_color(String color);
	
	public String slotnum_for_regnum(String registration_num);

}
