// Higher-order function returning another function
fun greeter(prefix: String): (String) -> String {
    return { name -> "$prefix $name" } // Lambda returned
}

fun main() {
    val greetHello = greeter("Hello")
    val greetHi = greeter("Hi")

    println(greetHello("Uttam"))  // Output: Hello Uttam
    println(greetHi("Bro"))       // Output: Hi Bro
}
