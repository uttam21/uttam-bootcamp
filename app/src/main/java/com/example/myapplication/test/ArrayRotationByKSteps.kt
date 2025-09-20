package com.example.myapplication.test

// Function to rotate an array to the right by k positions
fun rotateArray(arr: IntArray, k: Int) {
    val n = arr.size
    if (n == 0) return            // If array is empty, nothing to rotate

    val steps = k % n              // In case k > n, reduce extra rotations
    if (steps == 0) return         // If k is multiple of n, array stays the same

    // Helper function to reverse a part of the array in-place
    fun reverse(start: Int, end: Int) {
        var i = start
        var j = end
        while (i < j) {
            // Swap arr[i] and arr[j]
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            i++
            j--
        }
    }

    // Step 1: Reverse the entire array
    reverse(0, n - 1)

    // Step 2: Reverse the first 'steps' elements to put them in correct order
    reverse(0, steps - 1)

    // Step 3: Reverse the remaining elements to put them in correct order
    reverse(steps, n - 1)
}

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5)
    val k = 2
    rotateArray(arr, k)  // Rotate array by k positions
    println("Rotated Array: ${arr.joinToString()}")  // Output: 4, 5, 1, 2, 3
}
