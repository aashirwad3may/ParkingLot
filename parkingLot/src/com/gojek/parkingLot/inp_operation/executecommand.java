package com.gojek.parkingLot.inp_operation;

import com.gojek.parkingLot.constants.parkingLotConstants;
import com.gojek.parkingLot.exceptions.commandExecutionFailed;

public class executecommand {

	public static void inputCommand(String input) {

		String str[] = input.split(" ");
		switch (str[0]) {

		case parkingLotConstants.CREATE_PARKING_LOT:

			break;
		case parkingLotConstants.LEAVE_SLOT:

			break;

		case parkingLotConstants.PARK_VECHILE:

			break;

		case parkingLotConstants.REGNUM_CARS_WITH_COLOR:

			break;

		case parkingLotConstants.SLOTNUM_CARS_WITH_COLOR:

			break;

		case parkingLotConstants.SLOTNUM_FOR_REGNUM:

			break;

		case parkingLotConstants.STATUS:

			break;
		default : 
			throw new commandExecutionFailed("NO COMMAND FOUND");

		}

	}

}
