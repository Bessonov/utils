# Helpful utilities that make life easier and save your ass
=============================
[![Project is](https://img.shields.io/badge/Project%20is-fantastic-ff69b4.svg)](https://github.com/Bessonov/utils)
[![Build Status](https://travis-ci.org/Bessonov/utils.svg?branch=master)](https://travis-ci.org/Bessonov/utils)
[![Coverage Status](https://coveralls.io/repos/github/Bessonov/utils/badge.svg?branch=master)](https://coveralls.io/github/Bessonov/utils?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.bessonov/utils/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.bessonov/utils/)
[![License](http://img.shields.io/:license-MIT-blue.svg)](https://raw.githubusercontent.com/Bessonov/utils/master/LICENSE.txt)


## Relationship manager

With JPA or like you must synchronize both sides of OneToMany-Relation to avoid side effects. Therefore I build a relationship manager to avoid a boiler plate and error prone code. Because it's not depend on JPA, it can be used every time to synchronize relations.

### Usage

Entities can be used like normal [objects](src/test/java/de/bessonov/utils/jpa/OneToManyToOneManagerTest.java).

To use managers, define a one-to-many manager first, like this [Car](src/test/java/de/bessonov/utils/jpa/Car.java) and add add/remove methods.

After that, use it to define a many-to-one manager, like this [Wheel](src/test/java/de/bessonov/utils/jpa/Wheel.java).

Define managers is a little bit tricky. But to think "one car have many wheels" helps to interpolate the example.

# License

The MIT License (MIT)

Copyright (c) 2016, Anton Bessonov

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
