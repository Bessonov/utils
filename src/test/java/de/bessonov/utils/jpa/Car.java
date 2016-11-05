package de.bessonov.utils.jpa;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Car {

	// Define a one-to-many manager.
	// public static is important here, because this
	// manager is used by many-to-one manager
	public static final OneToManyManager<Car, Wheel> WHEELS_MANAGER = new OneToManyManager<>(
			Wheel::setCar,
			// it's important to get modificable collection here
			car -> car.wheels);

	private Set<Wheel> wheels = new HashSet<>();

	public Set<Wheel> getWheels() {
		// it's a good idea to return unmodifiable collection
		// because it's ensure no calls like car.getWheels().add(wheel)
		// are successed and bring entities to inconsistent state
		return Collections.unmodifiableSet(wheels);
	}

	public Car addWheel(Wheel wheel) {
		return WHEELS_MANAGER.add(this, wheel);
	}

	public Car removeWheel(Wheel wheel) {
		WHEELS_MANAGER.remove(wheel);
		return this;
	}
}
