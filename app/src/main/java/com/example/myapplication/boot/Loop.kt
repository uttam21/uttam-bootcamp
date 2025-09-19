package com.example.myapplication.boot

fun main(){

    val number = 2
    var index = 1
    while (index<=10){
        //print table of 2
        val result = "${number*index}"
        val findLength = "|| $number x $index = $result ||".length
        println("|| $number x $index = $result ||")
        if (result.length == 1 ){
            var space : String=" "
            for (i in 11..findLength){
                space.apply { "*" }
            }
            println("||$space||")
            println("===============")
        }else{
            println("================")
            println("||            ||")
        }

        index++
    }
    println("out of while loop at index $index")
    do {
        println("do while $index")
    }while(index>11)

    println("for loop")
    for (i in 1..5){
        for (j in 1..i) {
            //print("* ")
            setName(j)
        }
        for (k in 1..5-i){
            print("    ")
        }
        for (k in 1..i){
            //print("* ")
            setSurname(k)
        }
        println(" ")
    }
    for (i in 5 downTo 1){
        for (j in 1..i ) {
            //print("* ")
            setName(j)
        }
        for (k in 1..5-i){
            print("    ")
        }
        for (j in 1..i ) {
            //print("* ")
            setSurname(j)
        }
        println(" ")
    }
}

fun setName(iteration: Int){
    when(iteration){
        1 -> print("U ")
        2 -> print("t ")
        3 -> print("t ")
        4 -> print("a ")
        5 -> print("m ")
    }
}

fun setSurname(iteration: Int){
    when(iteration){
        1 -> print("R ")
        2 -> print("a ")
        3 -> print("b ")
        4 -> print("h ")
        5 -> print("a ")

    }
}