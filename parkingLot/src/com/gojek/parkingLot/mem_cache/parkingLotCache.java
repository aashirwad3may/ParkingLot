package com.gojek.parkingLot.mem_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.gojek.parkingLot.pojos.statuspojo;

public class parkingLotCache {

	private static ConcurrentHashMap<String, Integer> constants_mapping_map = new ConcurrentHashMap<String, Integer>();

	private static ConcurrentHashMap<String, String> regnum_slot_map = new ConcurrentHashMap<String, String>();

	private static ConcurrentHashMap<String, HashSet<String>> color_slotreg_map = new ConcurrentHashMap<String, HashSet<String>>();

	private static ConcurrentHashMap<Integer, String> slot_reg_map = new ConcurrentHashMap<Integer, String>();

	private static PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

	private static AtomicInteger parkingLotSize = new AtomicInteger();

	private static ArrayList<statuspojo> status = new ArrayList<statuspojo>();

	public static AtomicInteger getParkingLotSize() {
		return parkingLotSize;
	}

	public static PriorityQueue<Integer> getQueue() {
		return queue;
	}

	public static ConcurrentHashMap<String, String> getRegnum_slot_map() {
		return regnum_slot_map;
	}

	public static ConcurrentHashMap<String, HashSet<String>> getColor_slotreg_map() {
		return color_slotreg_map;
	}

	public static ConcurrentHashMap<String, Integer> getMap() {
		return constants_mapping_map;
	}

	public static ConcurrentHashMap<Integer, String> getSlot_reg_map() {
		return slot_reg_map;
	}

	public static ArrayList<statuspojo> getStatus() {
		return status;
	}

}
