package com.gojek.parkingLot.inp_operation;

import com.gojek.parkingLot.constants.ParkingLotConstants;
import com.gojek.parkingLot.exceptions.CommandExecutionFailed;
import com.gojek.parkingLot.manager.ParkingLotOperationImpl;
import com.gojek.parkingLot.manager.ParkingLotQueryOperationImpl;
import com.gojek.parkingLot.manager.ParkingLotVehicle;
import com.gojek.parkingLot.mem_cache.ParkingLotCache;
import com.gojek.parkingLot.pojos.Car;

public class Executecommand {

	/**Method to execute a particular command after it is validated
	 * @param input: input command
	 */
	public static void inputCommand(String input) {

		String str[] = input.split(" ");
		switch (str[0]) {

		case ParkingLotConstants.CREATE_PARKING_LOT:
			ParkingLotOperationImpl.getOperations().createParkingLot(Integer.parseInt(str[1]));
			break;
		case ParkingLotConstants.LEAVE_SLOT:
			if(ParkingLotCache.getParkingLotSize().get()>0)
			ParkingLotOperationImpl.getOperations().leaveParkingLot(Integer.parseInt(str[1]));
			else
				throw new CommandExecutionFailed("NO PARKINGLOT CREATED ");
			break;

		case ParkingLotConstants.PARK_VECHILE:
			if(ParkingLotCache.getParkingLotSize().get()>0) {
				ParkingLotVehicle vehicle = new Car();
				vehicle.setColor(str[2].toLowerCase());
				vehicle.setRegistration_num(str[1]);
				ParkingLotOperationImpl.getOperations().park_vehicle(vehicle);
			}
			else
				throw new CommandExecutionFailed("NO PARKINGLOT CREATED ");
			
			
			break;

		case ParkingLotConstants.REGNUM_CARS_WITH_COLOR:
			if(ParkingLotCache.getParkingLotSize().get()>0) 
			ParkingLotQueryOperationImpl.getQuery().regnum_cars_with_color(str[1].toLowerCase());
			else
				throw new CommandExecutionFailed("NO PARKINGLOT CREATED ");
			break;

		case ParkingLotConstants.SLOTNUM_CARS_WITH_COLOR:
			if(ParkingLotCache.getParkingLotSize().get()>0) 
			ParkingLotQueryOperationImpl.getQuery().slotnum_cars_with_color(str[1].toLowerCase());
			else
				throw new CommandExecutionFailed("NO PARKINGLOT CREATED ");
			break;

		case ParkingLotConstants.SLOTNUM_FOR_REGNUM:
			if(ParkingLotCache.getParkingLotSize().get()>0) 
			ParkingLotQueryOperationImpl.getQuery().slotnum_for_regnum(str[1]);	
			else
				throw new CommandExecutionFailed("NO PARKINGLOT CREATED ");
			break;

		case ParkingLotConstants.STATUS:
			ParkingLotQueryOperationImpl.getQuery().parkingLot_status();
			break;
		
		case "check":
			ParkingLotQueryOperationImpl.getQuery().checkstatus();
			break;
		default : 
			throw new CommandExecutionFailed("NO COMMAND FOUND");

		}

	}

}
