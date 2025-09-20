package com.example.myapplication.test

// Lazy-initialized Singleton class
class SingletonExample private constructor() {

    // Companion object holds the singleton instance
    companion object {
        // 'by lazy' ensures instance is created only when accessed first time
        val instance: SingletonExample by lazy { SingletonExample() }
    }

    // Example function
    fun log(message: String) {
        println("Log: $message")
    }
}

fun main() {
    // Access the singleton instance and call function
    SingletonExample.instance.log("Hello SingletonExample")
    // Output: Log: Hello SingletonExample
}



//Explanation
//
//private constructor()
//Prevents creating multiple instances from outside the class.
//
//companion object + by lazy
//Ensures a single instance exists.
//Created lazily, only on first access.
//
//Accessing the singleton
//Use SingletonExample.instance anywhere in the app.
//
//Function call
//log() demonstrates using the singleton instance.
//