package com.example.myapplication.test

// Function to find duplicates in an array
fun findDuplicates(arr: IntArray): Set<Int> {
    val seen = HashSet<Int>()       // Keeps track of unique elements we have already seen
    val duplicates = HashSet<Int>() // Stores duplicate elements (final result)

    for (num in arr) {
        // Try to add the number to 'seen'
        // -> If 'num' is new, it gets added successfully (returns true)
        // -> If 'num' already exists, add() returns false → so it's a duplicate
        if (!seen.add(num)) {
            duplicates.add(num)     // Store the duplicate in 'duplicates'
        }
    }
    return duplicates
}

fun main() {
    // Sample array with duplicate values
    val arr = intArrayOf(1, 2, 3, 2, 4, 5, 1, 6, 3)

    // Call function to get all duplicates
    val duplicates = findDuplicates(arr)

    // Print result
    println("Duplicate elements: $duplicates")
}
