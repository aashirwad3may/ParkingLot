package com.gojek.parkingLot.manager;

import java.util.List;

public interface ParkingLotQueryOperations {
	
	public void parkingLot_status();
	
	public int getavalaibleslot();
	
	public void regnum_cars_with_color(String color);
	
	public void slotnum_cars_with_color(String color);
	
	public void slotnum_for_regnum(String registration_num);

}
