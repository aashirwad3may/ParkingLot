package com.gojek.parkingLot.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gojek.parkingLot.manager.ParkingLotOperationImpl;
import com.gojek.parkingLot.manager.ParkingLotQueryOperationImpl;
import com.gojek.parkingLot.manager.ParkingLotVehicle;
import com.gojek.parkingLot.mem_cache.ParkingLotCache;
import com.gojek.parkingLot.pojos.Car;

public class Bootstraptest {
	private static final ByteArrayOutputStream outstream = new ByteArrayOutputStream();

	@BeforeClass
	public static void createparkinglot() {
		System.setOut(new PrintStream(outstream));
		ParkingLotOperationImpl.getOperations().createParkingLot(10);
		assertEquals(outstream.toString().trim().toLowerCase().replace(" ", ""), "createdaparkinglotwith10slots");
		outstream.reset();
	}

	@Test
	public final void recreateparkinglot() {

		ParkingLotOperationImpl.getOperations().createParkingLot(10);
		assertEquals(outstream.toString().trim().toLowerCase().replace(" ", ""), "parkinglotalreadycreated");
		outstream.reset();

	}

	@Test
	public final void parkvehicle() {

		ParkingLotVehicle vehicle = new Car();
		vehicle.setColor("Blue".toLowerCase());
		vehicle.setRegistration_num("KA-101-HA-1234");
		ParkingLotOperationImpl.getOperations().park_vehicle(vehicle);
		assertEquals(outstream.toString().trim().toLowerCase().replace(" ", ""), "allocatedslotnumber:1");
		ParkingLotOperationImpl.getOperations().leaveParkingLot(1);
		ParkingLotCache.unittestclearcache();
		outstream.reset();
	}

	@Test
	public final void leavevehicle() {
		ParkingLotVehicle vehicle = new Car();
		vehicle.setColor("Red".toLowerCase());
		vehicle.setRegistration_num("KA-101-HA-1294");
		ParkingLotOperationImpl.getOperations().park_vehicle(vehicle);

		outstream.reset();
		ParkingLotOperationImpl.getOperations().leaveParkingLot(1);
		assertEquals(outstream.toString().trim().toLowerCase().replace(" ", ""), "slotnumber1isfree");
		ParkingLotCache.unittestclearcache();
		outstream.reset();
	}

	@Test
	public final void regnum_car_with_color() {

		ParkingLotQueryOperationImpl.getQuery().checkstatus();
		ParkingLotVehicle vehicle = new Car();
		vehicle.setColor("Red".toLowerCase());
		vehicle.setRegistration_num("KA-101-HA-1294");
		ParkingLotOperationImpl.getOperations().park_vehicle(vehicle);

		ParkingLotQueryOperationImpl.getQuery().checkstatus();
		ParkingLotVehicle vehicle1 = new Car();
		vehicle1.setColor("Red".toLowerCase());
		vehicle1.setRegistration_num("KA-101-HA-1295");
		ParkingLotOperationImpl.getOperations().park_vehicle(vehicle1);
		outstream.reset();

		ParkingLotQueryOperationImpl.getQuery().regnum_cars_with_color("Red");
		assertEquals(outstream.toString().trim().replace(" ", ""), "KA-101-HA-1294,KA-101-HA-1295");
		ParkingLotOperationImpl.getOperations().leaveParkingLot(1);
		ParkingLotOperationImpl.getOperations().leaveParkingLot(2);
		ParkingLotCache.unittestclearcache();
		outstream.reset();

	}

	@Test
	public final void slot_car_with_color() {

		ParkingLotVehicle vehicle = new Car();
		vehicle.setColor("Red".toLowerCase());
		vehicle.setRegistration_num("KA-101-HA-1294");
		ParkingLotOperationImpl.getOperations().park_vehicle(vehicle);

		ParkingLotQueryOperationImpl.getQuery().checkstatus();
		ParkingLotVehicle vehicle1 = new Car();
		vehicle1.setColor("Red".toLowerCase());
		vehicle1.setRegistration_num("KA-101-HA-1295");
		ParkingLotOperationImpl.getOperations().park_vehicle(vehicle1);

		outstream.reset();
		ParkingLotQueryOperationImpl.getQuery().slotnum_cars_with_color("Red");
		assertEquals(outstream.toString().trim().toLowerCase().replace(" ", ""), "1,2");
		ParkingLotOperationImpl.getOperations().leaveParkingLot(1);
		ParkingLotOperationImpl.getOperations().leaveParkingLot(2);
		ParkingLotCache.unittestclearcache();
		outstream.reset();

	}

	@Test
	public void slotnumforregnum() {
		ParkingLotQueryOperationImpl.getQuery().checkstatus();
		ParkingLotVehicle vehicle1 = new Car();
		vehicle1.setColor("Red".toLowerCase());
		vehicle1.setRegistration_num("KA-101-HA-1295");
		ParkingLotOperationImpl.getOperations().park_vehicle(vehicle1);

		outstream.reset();
		ParkingLotQueryOperationImpl.getQuery().slotnum_for_regnum("KA-101-HA-1295");
		assertEquals(outstream.toString().trim().toLowerCase().replace(" ", ""), "1");
		ParkingLotOperationImpl.getOperations().leaveParkingLot(1);
		ParkingLotCache.unittestclearcache();
		outstream.reset();
	}

	@Test
	public void getavaliaibleslot() {

		assertEquals(ParkingLotQueryOperationImpl.getQuery().getavalaibleslot(), 1);
		ParkingLotOperationImpl.getOperations().leaveParkingLot(1);
		ParkingLotCache.unittestclearcache();

	}

	public final void check() {

		ParkingLotQueryOperationImpl.getQuery().checkstatus();
		assertEquals(outstream.toString().trim().toLowerCase().replace(" ", ""), "1");
		outstream.reset();
	}

}
