package com.example.myapplication.boot;

class TestClass{
public static void main(String[] args) {

}
}
class Car {

    Engine engine = new Engine();

    public Car() {

    }

    void startCar() {

        engine.start();

        System.out.println("Car started.");

    }

}

class Engine {

    public void start() {

//Engine starts

        System.out.println("Engine started.");

    }

}
