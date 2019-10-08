package com.gojek.parkingLot.constants;

import java.util.HashMap;

public class parkingLotMapping {
	
	private static HashMap<String , Integer> map = new HashMap<String, Integer>();

	public static void createMap() {
		map.put(parkingLotConstants.CREATE_PARKING_LOT, 1);
		map.put(parkingLotConstants.LEAVE_SLOT, 1);
		map.put(parkingLotConstants.PARK_VECHILE, 2);
		map.put(parkingLotConstants.REGNUM_CARS_WITH_COLOR, 1);
		map.put(parkingLotConstants.SLOTNUM_CARS_WITH_COLOR, 1);
		map.put(parkingLotConstants.SLOTNUM_FOR_REGNUM, 1);
		map.put(parkingLotConstants.STATUS, 0);
		
	}
	
	
	
	
	public static HashMap<String, Integer> getMap() {
		return map;
	}
	
	

}
