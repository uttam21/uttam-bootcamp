package com.example.myapplication.test

fun findDuplicates(arr: IntArray): Set<Int> {
    val seen = HashSet<Int>()
    val duplicates = HashSet<Int>()

    for (num in arr) {
        if (!seen.add(num)) {  // if already present, it's a duplicate
            duplicates.add(num)
        }
    }
    return duplicates
}

fun main() {
    val arr = intArrayOf(1, 2, 3, 2, 4, 5, 1, 6, 3)
    val duplicates = findDuplicates(arr)
    println("Duplicate elements: $duplicates")
}
