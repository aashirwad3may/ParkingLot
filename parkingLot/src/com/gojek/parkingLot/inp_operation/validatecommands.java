package com.gojek.parkingLot.inp_operation;

import com.gojek.parkingLot.constants.parkingLotConstants;
import com.gojek.parkingLot.constants.parkingLotMapping;
import com.gojek.parkingLot.exceptions.InvalidCommandException;

public class validatecommands {

	public static boolean validate(String command) {

		
		try {
			String str[] = command.split(" ");
			if (str[0].equalsIgnoreCase(parkingLotConstants.CREATE_PARKING_LOT) && str.length == parkingLotMapping.getMap().get(parkingLotConstants.CREATE_PARKING_LOT)-1) {

					return true;
			} 
			else if (str[0].equalsIgnoreCase(parkingLotConstants.LEAVE_SLOT) && str.length == parkingLotMapping.getMap().get(parkingLotConstants.LEAVE_SLOT)-1) {
				
					return true;
				
			}
			
			else if (str[0].equalsIgnoreCase(parkingLotConstants.PARK_VECHILE) && str.length == parkingLotMapping.getMap().get(parkingLotConstants.PARK_VECHILE)-1) {
				return true;
			}
			
			else if (str[0].equalsIgnoreCase(parkingLotConstants.REGNUM_CARS_WITH_COLOR) && str.length == parkingLotMapping.getMap().get(parkingLotConstants.REGNUM_CARS_WITH_COLOR)-1) {
				return true;
			}
			
			else if (str[0].equalsIgnoreCase(parkingLotConstants.SLOTNUM_CARS_WITH_COLOR) && str.length == parkingLotMapping.getMap().get(parkingLotConstants.SLOTNUM_CARS_WITH_COLOR)-1) {
				return true;
			}
			else if (str[0].equalsIgnoreCase(parkingLotConstants.STATUS) && str.length == parkingLotMapping.getMap().get(parkingLotConstants.STATUS)-1) {
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
