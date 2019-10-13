package com.gojek.parkingLot.manager;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.gojek.parkingLot.exceptions.InvalidCommandException;
import com.gojek.parkingLot.exceptions.commandExecutionFailed;
import com.gojek.parkingLot.mem_cache.parkingLotCache;
import com.gojek.parkingLot.pojos.statuspojo;

public class parkingLotQueryOperationImpl implements ParkingLotQueryOperations{
	
	private static final parkingLotQueryOperationImpl query = new parkingLotQueryOperationImpl();
	
	public static parkingLotQueryOperationImpl getQuery() {
		return query;
	}

	private parkingLotQueryOperationImpl() {
		
	}

	@Override
	public void parkingLot_status() {
		ConcurrentHashMap<String , String > map = parkingLotCache.getRegnum_slot_map();
		for(Map.Entry<String, String> entry : map.entrySet()) {
		    statuspojo status = new statuspojo();
		    status.setReg_num(entry.getKey());
		    status.setColor(entry.getValue().split(",")[1]);
		    status.setSlot_num(Integer.parseInt(entry.getValue().split(",")[0]));
		    
		    parkingLotCache.getStatus().add(status);
		}
		Collections.sort(parkingLotCache.getStatus());
		Iterator<statuspojo> itr = parkingLotCache.getStatus().iterator();
		String format = "%-10s %s %10s\n";
		System.out.format(format,"Slot No.","Registration No","Color");
		while(itr.hasNext()) {
			statuspojo pojo = itr.next();
			
			System.out.format(format,pojo.getSlot_num(),pojo.getReg_num(),pojo.getColor());
		}
		
		parkingLotCache.getStatus().clear();
		
	}

	@Override
	public String regnum_cars_with_color(String color) {
		try {
			// TODO Auto-generated method stub
			HashSet<String> set = parkingLotCache.getColor_slotreg_map().get(color.toLowerCase());
			StringBuilder out = new StringBuilder();
			if(set!=null) {
				Iterator<String> itr = set.iterator();
				int size = set.size();
				int i = 0;
				while(itr.hasNext()) {
					i++;
					if(i==size)
					out.append(itr.next().split(",")[0]);
					else
						out.append(itr.next().split(",")[0]+", ");
				}
				out.append("\n");
				return out.toString();
			}
			else
				return("Vehicle of color "+color+" is not present");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new commandExecutionFailed("Retrivel of all Registration numbers of cars with given color Failed");
		}
		
		
	}

	@Override
	public String slotnum_cars_with_color(String color) {
		try {
			// TODO Auto-generated method stub
			HashSet<String> set = parkingLotCache.getColor_slotreg_map().get(color.toLowerCase());
			StringBuilder out = new StringBuilder();
			if(set!=null) {
				Iterator<String> itr = set.iterator();
				int size = set.size();
				int i = 0;
				while(itr.hasNext()) {
					i++;
					if(i==size)
					out.append(itr.next().split(",")[1]);
					else
						out.append(itr.next().split(",")[1]+", ");
				}
				out.append("\n");
				return out.toString();
			}
			else
				return("Vehicle of color "+color+" is not present");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new commandExecutionFailed("Retrivel of all slots with given color Failed");

		}
		
	}

	@Override
	public String slotnum_for_regnum(String registration_num) {
		try {
			// TODO Auto-generated method stub
			if(parkingLotCache.getRegnum_slot_map().get(registration_num)!=null)
			return(parkingLotCache.getRegnum_slot_map().get(registration_num).split(",")[0]);
			else
				return("Not found");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new commandExecutionFailed("Retrivel of all slot Failed");

		}
	}

	@Override
	public int getavalaibleslot() {
		if(parkingLotCache.getQueue().isEmpty())
		return 0;
		else 
			return parkingLotCache.getQueue().remove();
	}
	
	public void checkstatus() {
		System.out.println(parkingLotCache.getColor_slotreg_map());
		System.out.println(parkingLotCache.getQueue());
		System.out.println(parkingLotCache.getRegnum_slot_map());
		System.out.println(parkingLotCache.getSlot_reg_map());
	}

}
