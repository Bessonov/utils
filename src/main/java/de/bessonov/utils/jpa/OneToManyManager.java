package de.bessonov.utils.jpa;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Manager for OneToMany relationships
 *
 * <pre class="code">
	public class Car {

		// Define a one-to-many manager.
		// public static is important here, because this
		// manager is used by many-to-one manager
		public static final OneToManyManager&lt;Car, Wheel&gt; WHEELS_MANAGER = new OneToManyManager&lt;&gt;(
				Wheel::setCar,
				// it's important to get modificable collection here
				car -&gt; car.wheels);

		private Set&lt;Wheel&gt; wheels = new HashSet&lt;&gt;();

		public Set&lt;Wheel&gt; getWheels() {
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
 * </pre>
 *
 * @param O "one" side of relationship
 * @param M "many" side of relationship
 *
 * @author Anton Bessonov
 */
public class OneToManyManager<O, M> {

	private BiConsumer<M, O> setter;
	private Function<O, Collection<M>> oneToMany;

	/**
	 * @param setter is used to set "one" in "many", like
	   class Wheel {
	   	void setCar(Car car) {
	   		this.car = car;
	   	}
	   }
	 * @param oneToMany is function to get modifiable "many" from "one", like
	   class Car {
	   	Collection&lt;Wheel&gt; getWheels() {
	   		return this.wheels;
	   	}
	   }
	 */
	public OneToManyManager(BiConsumer<M, O> setter, Function<O, Collection<M>> oneToMany) {
		this.setter = setter;
		this.oneToMany = oneToMany;
	}

	public O add(O one, M many) {
		setter.accept(many, one);
		return one;
	}

	public void remove(M many) {
		setter.accept(many, null);
	}

	public Collection<M> get(O one) {
		return oneToMany.apply(one);
	}
}
