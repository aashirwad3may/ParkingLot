package com.gojek.parkingLot.startup;

import java.util.Scanner;

import com.gojek.parkingLot.constants.parkingLotMapping;
import com.gojek.parkingLot.exceptions.InvalidCommandException;
import com.gojek.parkingLot.inp_operation.executecommand;
import com.gojek.parkingLot.inp_operation.validatecommands;
import com.gojek.parkingLot.mem_cache.parkingLotMaps;

public class bootstrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**************************************************************************");
		System.out.println("*************************PARKING******************************************");
		System.out.println("***************************LOT********************************************");
		System.out.println("**************************GOJEK*******************************************");

		initializeManagers();

		Scanner sc = new Scanner(System.in);
		if (args.length == 0) {
			
			System.out.println();
			System.out.println("Enter exit to close the shell");
			while (true) {
				System.out.println();
				System.out.println("Input: ");
				String input = sc.nextLine();

				try {
					validatecommands.validate(input);
					
					executecommand.inputCommand(input);

				} catch (Exception e) {
					System.out.println("Exception occured: " + e.getMessage());
				}

			}

		} else {

		}
	}

	private static void initializeManagers() {
		parkingLotMapping.createMap(parkingLotMaps.getMap());
	}

}
