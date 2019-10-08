package com.gojek.parkingLot.constants;

import java.util.HashMap;

public class parkingLotMapping {

	public static void createMap(HashMap<String, Integer> map) {
		map.put(parkingLotConstants.CREATE_PARKING_LOT, 1);
		map.put(parkingLotConstants.LEAVE_SLOT, 1);
		map.put(parkingLotConstants.PARK_VECHILE, 2);
		map.put(parkingLotConstants.REGNUM_CARS_WITH_COLOR, 1);
		map.put(parkingLotConstants.SLOTNUM_CARS_WITH_COLOR, 1);
		map.put(parkingLotConstants.SLOTNUM_FOR_REGNUM, 1);
		map.put(parkingLotConstants.STATUS, 0);

	}

}
