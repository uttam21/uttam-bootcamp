package com.example.myapplication.test

// Function to count numbers formed from given digits that are less than 'limit'
fun countNumbers(digits: IntArray, limit: Int): Int {
    val limitStr = limit.toString() // Convert limit to string for easy comparison

    // Recursive helper function
    // 'current' stores the number being formed as a string
    fun count(current: String): Int {
        // Base case: If number formed is >= limit, stop recursion
        if (current.isNotEmpty() && current.toInt() >= limit) return 0

        // Count 1 if current string is a valid number (>0 digits)
        var total = if (current.isNotEmpty()) 1 else 0

        // Try appending each digit and count recursively
        for (digit in digits) {
            total += count(current + digit) // Build next number and recurse
        }

        return total
    }

    return count("") // Start recursion with empty string
}

fun main() {
    val digits = intArrayOf(1, 3, 7, 9) // Digits to form numbers
    val limit = 37                        // Upper limit
    val result = countNumbers(digits, limit)
    println("Total numbers less than $limit: $result") // Output: 6
}
