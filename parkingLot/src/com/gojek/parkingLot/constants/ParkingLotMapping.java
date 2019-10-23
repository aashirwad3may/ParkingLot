package com.gojek.parkingLot.constants;

import java.util.concurrent.ConcurrentHashMap;

public class ParkingLotMapping {

	public static void createMap(ConcurrentHashMap<String, Integer> map) {
		map.put(ParkingLotConstants.CREATE_PARKING_LOT, 1);
		map.put(ParkingLotConstants.LEAVE_SLOT, 1);
		map.put(ParkingLotConstants.PARK_VECHILE, 2);
		map.put(ParkingLotConstants.REGNUM_CARS_WITH_COLOR, 1);
		map.put(ParkingLotConstants.SLOTNUM_CARS_WITH_COLOR, 1);
		map.put(ParkingLotConstants.SLOTNUM_FOR_REGNUM, 1);
		map.put(ParkingLotConstants.STATUS, 0);

	}

}
