package com.gojek.parkingLot.startup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.gojek.parkingLot.constants.ParkingLotMapping;
import com.gojek.parkingLot.inp_operation.Executecommand;
import com.gojek.parkingLot.inp_operation.Validatecommands;
import com.gojek.parkingLot.mem_cache.ParkingLotCache;


public class Bootstrap {
	
	public static void main(String[] args) { 
		
		initializeManagers();

		Scanner sc = new Scanner(System.in);
		/**Run the code in interactive mode or through file input is based on value of args length*/ 
		if (args.length == 0) {
			
			
			while (true) {
				
				String input = sc.nextLine();
				
				if(input.equalsIgnoreCase("exit"))
					break;

				try {
					/**Validate as well as execute the given input*/
					Validatecommands.validate(input);
					
					Executecommand.inputCommand(input);

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
							Validatecommands.validate(line);
							
							Executecommand.inputCommand(line);

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
	
	/**
	 * Method to create mapping between input commands and number of arguments for each command
	 */
	private static void initializeManagers() {
		ParkingLotMapping.createMap(ParkingLotCache.getMap());
	}

}
