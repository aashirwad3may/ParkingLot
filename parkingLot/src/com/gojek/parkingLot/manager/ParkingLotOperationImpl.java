package com.gojek.parkingLot.manager;

import java.util.HashSet;

import com.gojek.parkingLot.exceptions.InvalidCommandException;
import com.gojek.parkingLot.exceptions.CommandExecutionFailed;
import com.gojek.parkingLot.mem_cache.ParkingLotCache;

public class ParkingLotOperationImpl implements ParkingLotOperations {

	private static ParkingLotOperationImpl operations = new ParkingLotOperationImpl();

	private ParkingLotOperationImpl() {

	}

	/**
	 * Method to be implemented if multiple levels allowed
	 */
	@Override
	public void createParkingLot(int size, int levels) {

	}

	/**
	 * Method to park a vehicle based on slot availability
	 */
	@Override
	public void park_vehicle(ParkingLotVehicle vehicle) {

		try {
			int avalaibility = ParkingLotQueryOperationImpl.getQuery().getavalaibleslot();
			/** If availability>0 means slot is available */
			if (avalaibility != 0) {

				/**
				 * Inserting into Regnum_slot_map with Key(datatype=String):Registration_num and
				 * value(datatype=String):(slot,color)
				 */
				if (ParkingLotCache.getRegnum_slot_map().get(vehicle.getRegistration_num()) == null) {
					ParkingLotCache.getRegnum_slot_map().put(vehicle.getRegistration_num(),
							avalaibility + "," + vehicle.getColor());

					/**
					 * Inserting into Color_slotreg_map with Key(datatype=String):Colour and
					 * value(datatype=HashSet<String>):HashSet of String("Registrstion_num,slot")
					 */
					if (ParkingLotCache.getColor_slotreg_map().get(vehicle.getColor()) != null) {
						ParkingLotCache.getColor_slotreg_map().get(vehicle.getColor())
								.add(vehicle.getRegistration_num() + "," + avalaibility);
					} else {
						HashSet<String> hset = new HashSet<String>();
						hset.add(vehicle.getRegistration_num() + "," + avalaibility);
						ParkingLotCache.getColor_slotreg_map().put(vehicle.getColor(), hset);
					}

					/**
					 * Inserting into Slot_reg_num map with Key(datatype:Integer):slot and
					 * value(datatype:String):Registration_num
					 */
					ParkingLotCache.getSlot_reg_map().put(avalaibility, vehicle.getRegistration_num());
					System.out.println("Allocated slot number: " + avalaibility);
				} else {
					ParkingLotCache.getQueue().add(avalaibility);
					System.out.println("Vehicle already Parked");
				}

			} else
				System.out.println("Sorry, parking lot is full");
		} catch (Exception e) {

			throw new CommandExecutionFailed("Parking of Vehicle Failed");
		}

	}

	/**
	 * Method to free a slot by clearing the vehicle data stored in map and adding
	 * the occupied slot to available slots
	 */
	@Override
	public void leaveParkingLot(int slot) {
		try {

			if (slot >= 1 && slot <= ParkingLotCache.getParkingLotSize().get()
					&& (ParkingLotCache.getSlot_reg_map().get(slot) != null)) {

				String reg = ParkingLotCache.getSlot_reg_map().get(slot);

				ParkingLotCache.getSlot_reg_map().remove(slot);

				ParkingLotCache.getQueue().add(slot);

				String str[] = ParkingLotCache.getRegnum_slot_map().get(reg).split(",");
				ParkingLotCache.getRegnum_slot_map().remove(reg);

				ParkingLotCache.getColor_slotreg_map().get(str[1]).remove(reg + "," + slot);
				if (ParkingLotCache.getColor_slotreg_map().get(str[1]).size() == 0)
					ParkingLotCache.getColor_slotreg_map().remove(str[1]);
				
				System.out.println("Slot number " + slot + " is free");

			} else {
				System.out.println("No Vehicle is parked at this Slot");
			}
		} catch (Exception e) {
			throw new CommandExecutionFailed("ParkingLot Exit Failed");

		}
	}

	/**
	 * Method to create a parking Lot only once further attempts to create a parking
	 * lot is not supported
	 */
	@Override
	public void createParkingLot(int size) {

		try {
			if (ParkingLotCache.getParkingLotSize().get() == 0) {
				ParkingLotCache.getParkingLotSize().set(size);
				for (int i = 1; i <= size; i++) {
					ParkingLotCache.getQueue().add(i);
				}
				System.out.println("Created a parking lot with " + ParkingLotCache.getQueue().size() + " slots");
			} else {
				System.out.println("Parking lot already created");
			}
		} catch (Exception e) {

			throw new CommandExecutionFailed("Parking lot creation failed");
		}

	}

	public static ParkingLotOperationImpl getOperations() {
		return operations;
	}

}
