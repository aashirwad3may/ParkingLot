package com.gojek.parkingLot.mem_cache;

import java.util.HashMap;

public class parkingLotMaps {
	
	private static HashMap<String , Integer> map = new HashMap<String, Integer>();

	public static HashMap<String, Integer> getMap() {
		return map;
	}


}
