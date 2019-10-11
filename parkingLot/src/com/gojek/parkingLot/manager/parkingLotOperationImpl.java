package com.gojek.parkingLot.manager;

import java.util.HashSet;

import com.gojek.parkingLot.exceptions.InvalidCommandException;
import com.gojek.parkingLot.mem_cache.parkingLotCache;

public class parkingLotOperationImpl implements parkingLotOperations {

	private static parkingLotOperationImpl operations = new parkingLotOperationImpl();

	private parkingLotOperationImpl() {

	}

	@Override
	public void createParkingLot(int size, int levels) {
		// TODO Auto-generated method stub

	}

	@Override
	public void park_vehicle(parkingLotVehicle vehicle) {
		
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
					System.out.println("Allocated slot number "+avalaibility);
				}
				else {
					parkingLotCache.getQueue().add(avalaibility);
					System.out.println("Vehicle already Parked");
				}
					
				
			} else
				System.out.println("Sorry,Parking Lot Is Full");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Parking of Vehicle Failed");
		}

	}

	@Override
	public void leaveParkingLot(int slot) {
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
				
				System.out.println("Slot number "+slot+" is free");
				
			}
			else {
				System.out.println("No Vehicle is parked at this Slot");
			}
		} catch (Exception e) {
			throw new InvalidCommandException("ParkingLot Exit Failed");
			
		}
	}

	@Override
	public void createParkingLot(int size) {
		parkingLotCache.getParkingLotSize().set(size);
		for (int i = 1; i <= size; i++) {
			parkingLotCache.getQueue().add(i);
		}
		System.out.println("Created Parking Lot with "+parkingLotCache.getQueue().size()+" size");
		System.out.println(parkingLotCache.getQueue());
	}

	public static parkingLotOperationImpl getOperations() {
		return operations;
	}

}
