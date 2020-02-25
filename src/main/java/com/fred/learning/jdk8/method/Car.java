package com.fred.learning.jdk8.method;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  zzf
 * Time     :  2019-12-22
 * Desc     :  方法引用
 */
public class Car {

    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car );

        cars.forEach( Car::collide );
        cars.forEach( Car::repair );

        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );
    }
}
