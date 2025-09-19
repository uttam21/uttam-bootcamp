package com.example.myapplication.test

fun main() {
    println(longestPalindrome("cabbabbaaabb"))
}

/**
 * Function to find the longest palindromic substring in a given string
 */
fun longestPalindrome(string: String): String {
    if (string.isEmpty()) return ""

    var start = 0   // left boundary of longest palindrome found so far
    var end = 0     // right boundary of longest palindrome found so far

    // Try every index in the string as a potential palindrome center
    for (i in string.indices) {

        // Case 1: Odd-length palindrome → expand around single character (i)
        val oddLength = expandCenterAndReturnItsLength(string, i, i)   // e.g. "aba"

        // Case 2: Even-length palindrome → expand around two characters (i, i+1)
        val evenLength = expandCenterAndReturnItsLength(string, i, i + 1) // e.g. "abba"

        // Take the larger of the two palindromes
        val maxLen = maxOf(oddLength, evenLength)

        // If we found a longer palindrome, update start and end indices
        if (maxLen > end - start) {
            // Compute new start index
            // (maxLen - 1) / 2 ensures correct calculation for both odd and even palindromes
            start = i - (maxLen - 1) / 2

            // Compute new end index
            end = i + maxLen / 2
        }
    }

    // substring(start, end+1) → because end index is exclusive in Kotlin
    return string.substring(start, end + 1)
}

/**
 * Expands around the given left and right indices and returns
 * the length of the longest palindrome centered at (left, right).
 */
fun expandCenterAndReturnItsLength(string: String, left: Int, right: Int): Int {
    var l = left
    var r = right

    // Expand outwards while characters match
    while (l >= 0 && r < string.length && string[l] == string[r]) {
        l-- // move left pointer outward
        r++ // move right pointer outward
    }

    // After loop ends, l and r are one step outside the palindrome boundaries
    // So length = (r-1) - (l+1) + 1 = r - l - 1
    return r - l - 1
}
