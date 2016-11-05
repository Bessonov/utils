package de.bessonov.utils.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class OneToManyToOneManagerTest {

	@Test
	public void testSetCarToWheel() {
		Car car = new Car();
		Wheel wheel = new Wheel();
		wheel.setCar(car);

		assertEquals(car, wheel.getCar());
		assertEquals(wheel, car.getWheels().iterator().next());
		assertEquals(1, car.getWheels().size());
	}

	@Test
	public void testSetSameCarToWheel() {
		Car car = new Car();
		Wheel wheel = new Wheel();
		wheel.setCar(car);
		// no difference
		wheel.setCar(car);

		assertEquals(car, wheel.getCar());
		assertEquals(wheel, car.getWheels().iterator().next());
		assertEquals(1, car.getWheels().size());
	}

	@Test
	public void testAddWheelToCar() {
		Car car = new Car();
		Wheel wheel = new Wheel();
		car.addWheel(wheel);

		assertEquals(car, wheel.getCar());
		assertEquals(wheel, car.getWheels().iterator().next());
		assertEquals(1, car.getWheels().size());
	}

	@Test
	public void testSetCarInWheelToNull() {
		Car car = new Car();
		Wheel wheel = new Wheel();
		car.addWheel(wheel);

		wheel.setCar(null);

		assertNull(wheel.getCar());
		assertEquals(0, car.getWheels().size());
	}

	@Test
	public void testRemoveWheelFromCar() {
		Car car = new Car();
		Wheel wheel = new Wheel();
		car.addWheel(wheel);
		car.removeWheel(wheel);

		assertNull(wheel.getCar());
		assertEquals(0, car.getWheels().size());
	}

	@Test
	public void testExchangeCar() {
		Car car = new Car();
		Wheel wheel = new Wheel();
		car.addWheel(wheel);

		Car car2 = new Car();
		car2.addWheel(wheel);

		assertEquals(car2, wheel.getCar());
		assertEquals(0, car.getWheels().size());
		assertEquals(1, car2.getWheels().size());
	}
}
