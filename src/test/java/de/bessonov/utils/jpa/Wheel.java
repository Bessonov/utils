package de.bessonov.utils.jpa;

public class Wheel {

	private static final ManyToOneManager<Wheel, Car> CAR_MANAGER = new ManyToOneManager<>(
			Car.WHEELS_MANAGER,
			wheel -> wheel.car,
			(wheel, car) -> wheel.car = car);

	private Car car;

	public Car getCar() {
		return car;
	}

	public Wheel setCar(Car car) {
		return CAR_MANAGER.set(this, car);
	}
}
