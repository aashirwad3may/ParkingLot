package com.gojek.parkingLot.pojos;

public class Statuspojo implements Comparable<Statuspojo>{

	private String reg_num;
	private int slot_num;
	private String color;
	
	
	public String getReg_num() {
		return reg_num;
	}


	@Override
	public String toString() {
		return "statuspojo [reg_num=" + reg_num + ", slot_num=" + slot_num + ", color=" + color + "]";
	}


	public void setReg_num(String reg_num) {
		this.reg_num = reg_num;
	}


	public int getSlot_num() {
		return slot_num;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public void setSlot_num(int slot_num) {
		this.slot_num = slot_num;
	}


	@Override
	public int compareTo(Statuspojo o) {	
		return this.slot_num-o.slot_num;
	}

}
