package com.gojek.parkingLot.startup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.gojek.parkingLot.constants.parkingLotMapping;
import com.gojek.parkingLot.inp_operation.executecommand;
import com.gojek.parkingLot.inp_operation.validatecommands;
import com.gojek.parkingLot.mem_cache.parkingLotCache;

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
				
				if(input.equalsIgnoreCase("exit"))
					break;

				try {
					validatecommands.validate(input);
					
					executecommand.inputCommand(input);

				} catch (Exception e) {
					System.out.println("Exception occured: " + e.getMessage());
				}

			}

		} else {
			
			try {

				BufferedReader br = new BufferedReader(new FileReader(args[0])) ;
				    String line;
				    while ((line = br.readLine()) != null) {
				    	try {
							validatecommands.validate(line);
							
							executecommand.inputCommand(line);

						} catch (Exception e) {
							System.out.println("Exception occured: " + e.getMessage());
						}
				    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
	}

	private static void initializeManagers() {
		parkingLotMapping.createMap(parkingLotCache.getMap());
	}

}
