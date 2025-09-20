package com.example.myapplication.test

// Higher-order function: takes another function as parameter
fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b) // Call the passed function
}

// Simple functions to pass
fun sum(x: Int, y: Int) = x + y
fun multiply(x: Int, y: Int) = x * y

fun main() {
    val result1 = operateOnNumbers(5, 3, ::sum)       // Pass sum function
    val result2 = operateOnNumbers(5, 3, ::multiply)  // Pass multiply function

    println("Sum: $result1")        // Output: Sum: 8
    println("Multiply: $result2")   // Output: Multiply: 15
}
