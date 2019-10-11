package com.gojek.parkingLot.inp_operation;

import com.gojek.parkingLot.constants.parkingLotConstants;
import com.gojek.parkingLot.exceptions.commandExecutionFailed;
import com.gojek.parkingLot.manager.parkingLotOperationImpl;
import com.gojek.parkingLot.manager.parkingLotQueryOperationImpl;
import com.gojek.parkingLot.manager.parkingLotVehicle;
import com.gojek.parkingLot.mem_cache.parkingLotCache;
import com.gojek.parkingLot.pojos.Car;

public class executecommand {

	public static void inputCommand(String input) {

		String str[] = input.split(" ");
		switch (str[0]) {

		case parkingLotConstants.CREATE_PARKING_LOT:
			parkingLotOperationImpl.getOperations().createParkingLot(Integer.parseInt(str[1]));
			break;
		case parkingLotConstants.LEAVE_SLOT:
			parkingLotOperationImpl.getOperations().leaveParkingLot(Integer.parseInt(str[1]));
			break;

		case parkingLotConstants.PARK_VECHILE:
			parkingLotVehicle vehicle = new Car();
			vehicle.setColor(str[2].toLowerCase());
			vehicle.setRegistration_num(str[1]);
			parkingLotOperationImpl.getOperations().park_vehicle(vehicle);
			
			break;

		case parkingLotConstants.REGNUM_CARS_WITH_COLOR:

			parkingLotQueryOperationImpl.getQuery().regnum_cars_with_color(str[1].toLowerCase());
			break;

		case parkingLotConstants.SLOTNUM_CARS_WITH_COLOR:
			parkingLotQueryOperationImpl.getQuery().slotnum_cars_with_color(str[1].toLowerCase());
			break;

		case parkingLotConstants.SLOTNUM_FOR_REGNUM:
			parkingLotQueryOperationImpl.getQuery().slotnum_for_regnum(str[1]);	
			break;

		case parkingLotConstants.STATUS:
			parkingLotQueryOperationImpl.getQuery().parkingLot_status();
			break;
		
		case "check":
			parkingLotQueryOperationImpl.getQuery().checkstatus();
			break;
		default : 
			throw new commandExecutionFailed("NO COMMAND FOUND");

		}

	}

}
