package com.example.myapplication.test

// Function to find the second maximum element in an array
fun secondMax(arr: IntArray): Int? {
    // If array has less than 2 elements, there cannot be a second maximum
    if (arr.size < 2) return null

    var max = Int.MIN_VALUE        // Variable to store the maximum value found so far
    var secondMax = Int.MIN_VALUE  // Variable to store the second maximum value

    // Iterate through each element in the array
    for (num in arr) {
        when {
            // Case 1: Current number is greater than max
            num > max -> {
                secondMax = max    // Old maximum becomes the second maximum
                max = num          // Update max to current number
            }
            // Case 2: Current number is greater than secondMax but less than max
            num > secondMax && num < max -> {
                secondMax = num    // Update secondMax to current number
            }
            // Case 3: Current number is less than or equal to secondMax → do nothing
        }
    }

    // If secondMax was updated from its initial value, return it; else return null
    return if (secondMax != Int.MIN_VALUE) secondMax else null
}

fun main() {
    val arr = intArrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5)  // Sample array
    val result = secondMax(arr)                        // Call the function
    println("Second maximum element is: $result")      // Output the result
}
