# Relationship manager

With JPA or like you must synchronize both sides of OneToMany-Relation to avoid side effects. Therefore I build a relationship manager to avoid a boiler plate and error prone code. Because it's not depend on JPA, it can be used every time to synchronize relations.

## Usage

Entities can be used like normal [objects](../../../../../../test/java/de/bessonov/utils/jpa/OneToManyToOneManagerTest.java).

To use managers, define a one-to-many manager first, like this [Car](../../../../../../test/java/de/bessonov/utils/jpa/Car.java) and add add/remove methods.

After that, use it to define a many-to-one manager, like this [Wheel](../../../../../../test/java/de/bessonov/utils/jpa/Wheel.java).

Define managers is a little bit tricky. But to think "one car have many wheels" helps to interpolate the example.