package com.gojek.parkingLot.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.gojek.parkingLot.exceptions.CommandExecutionFailed;
import com.gojek.parkingLot.mem_cache.ParkingLotCache;
import com.gojek.parkingLot.pojos.Statuspojo;

public class ParkingLotQueryOperationImpl implements ParkingLotQueryOperations {

	private static final ParkingLotQueryOperationImpl query = new ParkingLotQueryOperationImpl();

	public static ParkingLotQueryOperationImpl getQuery() {
		return query;
	}

	private ParkingLotQueryOperationImpl() {

	}

	/**
	 * Method tp print the currrent status of parking Lot
	 */
	@Override
	public void parkingLot_status() {
		ConcurrentHashMap<String, String> map = ParkingLotCache.getRegnum_slot_map();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			Statuspojo status = new Statuspojo();
			status.setReg_num(entry.getKey());
			status.setColor(entry.getValue().split(",")[1]);
			status.setSlot_num(Integer.parseInt(entry.getValue().split(",")[0]));

			ParkingLotCache.getStatus().add(status);
		}
		Collections.sort(ParkingLotCache.getStatus());
		Iterator<Statuspojo> itr = ParkingLotCache.getStatus().iterator();
		String format = "%-12s%-19s%s\n";
		System.out.format(format, "Slot No.", "Registration No", "Colour");
		while (itr.hasNext()) {
			Statuspojo pojo = itr.next();

			System.out.format(format, pojo.getSlot_num(), pojo.getReg_num(),
					pojo.getColor().substring(0, 1).toUpperCase() + pojo.getColor().substring(1));
		}

		ParkingLotCache.getStatus().clear();

	}

	/**
	 * Method to return registration_num of all cars of particular colour
	 */
	@Override
	public void regnum_cars_with_color(String color) {
		try {

			HashSet<String> set = ParkingLotCache.getColor_slotreg_map().get(color.toLowerCase());
			if (set != null) {
			List<String> list = null;
			/**
			 * converting the set into sorted list based on alphabetic order to passed the
			 * provided unit test can be omitted
			 */
			list = new ArrayList<String>(set);
			Collections.sort(list);

			StringBuilder out = new StringBuilder();
				Iterator<String> itr = list.iterator();
				int size = set.size();
				int i = 0;
				while (itr.hasNext()) {
					i++;
					if (i == size)
						out.append(itr.next().split(",")[0]);
					else
						out.append(itr.next().split(",")[0] + ", ");
				}

				System.out.println(out.toString());
			} else
				System.out.println("Vehicle of color " + color + " is not present");

		} catch (Exception e) {

			throw new CommandExecutionFailed(
					"Retrivel of all Registration numbers of cars with given color Failed" + e);
		}

	}

	/**
	 * Method to return slot numbers of cars of a particular colour
	 */
	@Override
	public void slotnum_cars_with_color(String color) {
		try {
			/**
			 * converting the set into sorted list based on increasing slot number order to
			 * passed the provided unit test can be omitted
			 */
			HashSet<String> set = ParkingLotCache.getColor_slotreg_map().get(color.toLowerCase());
			if (set != null) {
			List<String> list = new ArrayList<String>(set);
			Collections.sort(list);
			StringBuilder out = new StringBuilder();
			
				Iterator<String> itr = list.iterator();
				int size = set.size();
				int i = 0;
				while (itr.hasNext()) {
					i++;
					if (i == size)
						out.append(itr.next().split(",")[1]);
					else
						out.append(itr.next().split(",")[1] + ", ");
				}

				System.out.println(out.toString());
			} else
				System.out.println("Vehicle of color " + color + " is not present");
		} catch (Exception e) {
			
			throw new CommandExecutionFailed("Retrivel of all slots with given color Failed");

		}

	}

	/**
	 * Method to get registration number for corresponding slot number
	 */
	@Override
	public void slotnum_for_regnum(String registration_num) {
		try {

			if (ParkingLotCache.getRegnum_slot_map().get(registration_num) != null)
				System.out.println(ParkingLotCache.getRegnum_slot_map().get(registration_num).split(",")[0]);
			else
				System.out.println("Not found");
		} catch (Exception e) {

			throw new CommandExecutionFailed("Retrivel of all slot Failed");

		}
	}

	/**
	 * Method to return nearest available slot of parking lot is full returns 0
	 */
	@Override
	public int getavalaibleslot() {
		if (ParkingLotCache.getQueue().isEmpty())
			return 0;
		else
			return ParkingLotCache.getQueue().remove();
	}

	public void checkstatus() {
		System.out.println(ParkingLotCache.getColor_slotreg_map());
		System.out.println(ParkingLotCache.getQueue());
		System.out.println(ParkingLotCache.getRegnum_slot_map());
		System.out.println(ParkingLotCache.getSlot_reg_map());
	}

}
