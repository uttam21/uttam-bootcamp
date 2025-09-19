package com.example.myapplication.test
//Syntax is correct but how can we do this better in design perspective


// ANSWER is : DEPENDENCY injection
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
