package com.example.myapplication.test

// Function to count and print numbers formed from given digits that are less than 'limit'
fun countAndPrintNumbers(digits: IntArray, limit: Int): Int {
    val limitStr = limit.toString() // Convert limit to string for comparison
    val resultNumbers = mutableListOf<Int>() // Store all valid numbers

    // Recursive helper function
    fun generate(current: String) {
        // Base case: if number formed >= limit, stop recursion
        if (current.isNotEmpty() && current.toInt() >= limit) return

        // If current string is not empty, it's a valid number
        if (current.isNotEmpty()) {
            resultNumbers.add(current.toInt()) // Add number to the list
        }

        // Try appending each digit and recurse
        for (digit in digits) {
            generate(current + digit)
        }
    }

    generate("") // Start recursion with empty string

    // Print all valid numbers
    println("Numbers formed less than $limit: ${resultNumbers.joinToString(", ")}")

    return resultNumbers.size // Return total count
}

fun main() {
    val digits = intArrayOf(1, 3, 7, 9) // Digits to form numbers
    val limit = 37                        // Upper limit

    val count = countAndPrintNumbers(digits, limit)
    println("Total numbers less than $limit: $count")
}
