package com.example.myapplication.test

fun main(){
    Car().start()
    Car().move()

}

abstract class Vehicle {
    fun start() = println("Starting engine...")
    abstract fun move()
}

class Car : Vehicle() {
    override fun move() = println("Car is moving")
}
