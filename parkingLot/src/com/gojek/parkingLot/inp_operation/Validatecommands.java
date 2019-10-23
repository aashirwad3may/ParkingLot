package com.gojek.parkingLot.inp_operation;

import com.gojek.parkingLot.constants.ParkingLotConstants;
import com.gojek.parkingLot.constants.ParkingLotMapping;
import com.gojek.parkingLot.exceptions.InvalidCommandException;
import com.gojek.parkingLot.mem_cache.ParkingLotCache;

public class Validatecommands {

	/**Method to validate input command based on no of arguments passed for that command
	 * @param command
	 * @return true if command is validate else send exception
	 */
	public static boolean validate(String command) {

		
		try {
			String str[] = command.split(" ");
			if (str[0].equalsIgnoreCase(ParkingLotConstants.CREATE_PARKING_LOT) && str.length-1 == ParkingLotCache.getMap().get(ParkingLotConstants.CREATE_PARKING_LOT)) {

					try {
						Integer.parseInt(str[1]);
						return true;
					} catch (Exception e) {
						throw new InvalidCommandException("INVALID COMMAND");
						
					}
					
			} 
			else if (str[0].equalsIgnoreCase(ParkingLotConstants.LEAVE_SLOT) && str.length-1 == ParkingLotCache.getMap().get(ParkingLotConstants.LEAVE_SLOT)) {
				
				try {
					Integer.parseInt(str[1]);
					return true;
				} catch (Exception e) {
					throw new InvalidCommandException("INVALID COMMAND");
					
				}
				
			}
			
			else if (str[0].equalsIgnoreCase(ParkingLotConstants.PARK_VECHILE) && str.length-1 == ParkingLotCache.getMap().get(ParkingLotConstants.PARK_VECHILE)) {
				return true;
			}
			
			else if (str[0].equalsIgnoreCase(ParkingLotConstants.REGNUM_CARS_WITH_COLOR) && str.length-1 == ParkingLotCache.getMap().get(ParkingLotConstants.REGNUM_CARS_WITH_COLOR)) {
				return true;
			}
			
			else if (str[0].equalsIgnoreCase(ParkingLotConstants.SLOTNUM_CARS_WITH_COLOR) && str.length-1 == ParkingLotCache.getMap().get(ParkingLotConstants.SLOTNUM_CARS_WITH_COLOR)) {
				return true;
			}
			else if (str[0].equalsIgnoreCase(ParkingLotConstants.STATUS) && str.length-1 == ParkingLotCache.getMap().get(ParkingLotConstants.STATUS)) {
				return true;
			}
			else if (str[0].equalsIgnoreCase(ParkingLotConstants.SLOTNUM_FOR_REGNUM) && str.length-1 == ParkingLotCache.getMap().get(ParkingLotConstants.SLOTNUM_FOR_REGNUM)) {
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
