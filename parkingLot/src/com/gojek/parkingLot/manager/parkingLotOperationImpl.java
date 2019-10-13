package com.gojek.parkingLot.manager;

import java.util.HashSet;

import com.gojek.parkingLot.exceptions.InvalidCommandException;
import com.gojek.parkingLot.exceptions.commandExecutionFailed;
import com.gojek.parkingLot.mem_cache.parkingLotCache;

public class parkingLotOperationImpl implements parkingLotOperations {

	private static parkingLotOperationImpl operations = new parkingLotOperationImpl();

	private parkingLotOperationImpl() {

	}

	@Override
	public String createParkingLot(int size, int levels) {
		return null;
		

	}

	@Override
	public String park_vehicle(parkingLotVehicle vehicle) {
		
		try {
			int avalaibility = parkingLotQueryOperationImpl.getQuery().getavalaibleslot();
			if (avalaibility != 0) {
				//Inserting in registration map
				if(parkingLotCache.getRegnum_slot_map().get(vehicle.getRegistration_num())==null){
					parkingLotCache.getRegnum_slot_map().put(vehicle.getRegistration_num(),
							avalaibility + "," + vehicle.getColor());

					//Inserting in color slot map
					if (parkingLotCache.getColor_slotreg_map().get(vehicle.getColor())!=null) {
						parkingLotCache.getColor_slotreg_map().get(vehicle.getColor())
								.add(vehicle.getRegistration_num() + "," + avalaibility);
					} else {
						HashSet<String> hset = new HashSet<String>();
						hset.add(vehicle.getRegistration_num() + "," + avalaibility);
						parkingLotCache.getColor_slotreg_map().put(vehicle.getColor(), hset);
					}
					
					//inserting in slot reg map
					parkingLotCache.getSlot_reg_map().put(avalaibility, vehicle.getRegistration_num());
					return("Allocated slot number: "+avalaibility);
				}
				else {
					parkingLotCache.getQueue().add(avalaibility);
					return("Vehicle already Parked");
				}
					
				
			} else
				return("Sorry, parking lot is full");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new commandExecutionFailed("Parking of Vehicle Failed");
		}

	}

	@Override
	public String leaveParkingLot(int slot) {
		try {
			// TODO Auto-generated method stub
			if(slot>=1 && slot<=parkingLotCache.getParkingLotSize().get() && (parkingLotCache.getSlot_reg_map().get(slot)!=null)) {
				
				//throw exception
				String reg = parkingLotCache.getSlot_reg_map().get(slot);
				
				parkingLotCache.getSlot_reg_map().remove(slot);
				
				parkingLotCache.getQueue().add(slot);
				
				String str[] = parkingLotCache.getRegnum_slot_map().get(reg).split(",");
				parkingLotCache.getRegnum_slot_map().remove(reg);
				
				parkingLotCache.getColor_slotreg_map().get(str[1]).remove(reg+","+slot);
				
				return("Slot number "+slot+" is free");
				
			}
			else {
				return("No Vehicle is parked at this Slot");
			}
		} catch (Exception e) {
			throw new commandExecutionFailed("ParkingLot Exit Failed");
			
		}
	}

	@Override
	public String createParkingLot(int size) {
		
		try {
			if(parkingLotCache.getParkingLotSize().get()==0) {
				parkingLotCache.getParkingLotSize().set(size);
				for (int i = 1; i <= size; i++) {
					parkingLotCache.getQueue().add(i);
				}
				return("Created a parking lot with "+parkingLotCache.getQueue().size()+" slots");
			}
			else {
				return("Parking lot already created");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new commandExecutionFailed("Parking lot creation failed");
		}
		
		
	}

	public static parkingLotOperationImpl getOperations() {
		return operations;
	}

}
