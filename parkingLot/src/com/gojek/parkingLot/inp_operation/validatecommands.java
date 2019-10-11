package com.gojek.parkingLot.inp_operation;

import com.gojek.parkingLot.constants.parkingLotConstants;
import com.gojek.parkingLot.constants.parkingLotMapping;
import com.gojek.parkingLot.exceptions.InvalidCommandException;
import com.gojek.parkingLot.mem_cache.parkingLotCache;

public class validatecommands {

	public static boolean validate(String command) {

		
		try {
			String str[] = command.split(" ");
			if (str[0].equalsIgnoreCase(parkingLotConstants.CREATE_PARKING_LOT) && str.length-1 == parkingLotCache.getMap().get(parkingLotConstants.CREATE_PARKING_LOT)) {

					try {
						Integer.parseInt(str[1]);
						return true;
					} catch (Exception e) {
						throw new InvalidCommandException("INVALID COMMAND");
						
					}
					
			} 
			else if (str[0].equalsIgnoreCase(parkingLotConstants.LEAVE_SLOT) && str.length-1 == parkingLotCache.getMap().get(parkingLotConstants.LEAVE_SLOT)) {
				
				try {
					Integer.parseInt(str[1]);
					return true;
				} catch (Exception e) {
					throw new InvalidCommandException("INVALID COMMAND");
					
				}
				
			}
			
			else if (str[0].equalsIgnoreCase(parkingLotConstants.PARK_VECHILE) && str.length-1 == parkingLotCache.getMap().get(parkingLotConstants.PARK_VECHILE)) {
				return true;
			}
			
			else if (str[0].equalsIgnoreCase(parkingLotConstants.REGNUM_CARS_WITH_COLOR) && str.length-1 == parkingLotCache.getMap().get(parkingLotConstants.REGNUM_CARS_WITH_COLOR)) {
				return true;
			}
			
			else if (str[0].equalsIgnoreCase(parkingLotConstants.SLOTNUM_CARS_WITH_COLOR) && str.length-1 == parkingLotCache.getMap().get(parkingLotConstants.SLOTNUM_CARS_WITH_COLOR)) {
				return true;
			}
			else if (str[0].equalsIgnoreCase(parkingLotConstants.STATUS) && str.length-1 == parkingLotCache.getMap().get(parkingLotConstants.STATUS)) {
				return true;
			}
			else if (str[0].equalsIgnoreCase(parkingLotConstants.SLOTNUM_FOR_REGNUM) && str.length-1 == parkingLotCache.getMap().get(parkingLotConstants.SLOTNUM_FOR_REGNUM)) {
				return true;
			}
			else if(str[0].equalsIgnoreCase("check")) {
				return true;
			}
			else {
				throw new InvalidCommandException("COMMAND NOT FOUND");
			}
		} catch (Exception e) {
			throw new InvalidCommandException("INVALID COMMAND");
		}
			
		
	}

}
