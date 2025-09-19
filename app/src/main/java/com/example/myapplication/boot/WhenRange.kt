package com.example.myapplication.boot

fun main(){
    val number = 14
    val result = when(number){
        10 -> "Ten"
        11 -> "eleven"
        12 -> "Twelve"
        in 13..19 -> "Teen"
        20 -> "Twenty"
        in 21 until 25 -> "21<=x<25"
        25 -> "TwentyFive"
        26 -> "TwentySix"
        else -> "Not in range"
    }
    println(result)
}