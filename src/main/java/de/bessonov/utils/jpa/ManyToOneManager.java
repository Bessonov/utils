package de.bessonov.utils.jpa;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Manager for ManyToOne relationships
 *
 * <pre class="code">
	public class Wheel {

		private static final ManyToOneManager&lt;Wheel, Car&gt; CAR_MANAGER = new ManyToOneManager&lt;&gt;(
				Car.WHEELS_MANAGER,
				wheel -&gt; wheel.car,
				(wheel, car) -&gt; wheel.car = car);

		private Car car;

		public Car getCar() {
			return car;
		}

		public Wheel setCar(Car car) {
			return CAR_MANAGER.set(this, car);
		}
	}
 * </pre>
 *
 * @param M "many" side of relationship
 * @param O "one" side of relationship
 *
 * @author Anton Bessonov
 */
public class ManyToOneManager<M, O> {

	private OneToManyManager<O, M> oneToManyManager;
	private BiConsumer<M, O> setter;
	private Function<M, O> manyToOne;

	public ManyToOneManager(OneToManyManager<O, M> oneToManyManager, Function<M, O> manyToOne, BiConsumer<M, O> setter) {
		this.oneToManyManager = oneToManyManager;
		this.manyToOne = manyToOne;
		this.setter = setter;
	}

	public M set(M many, O one) {
		// get this.one from "many"
		O thisOne = manyToOne.apply(many);

		// do nothing, if same object
		if (thisOne == one) {
			return many;
		}

		// remove from original collection
		if (thisOne != null) {
			oneToManyManager.get(thisOne).remove(many);
		}

		// this.one = one
		setter.accept(many, one);

		// add to new collection
		if (one != null) {
			oneToManyManager.get(one).add(many);
		}

		return many;
	}
}
