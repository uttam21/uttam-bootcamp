// Higher-Order Function: takes another function as a parameter
fun operate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    // 'operation' is a function parameter that takes two Ints and returns an Int
    return operation(a, b) // Call the passed-in function with 'a' and 'b'
}

fun main() {
    // Calling 'operate' and passing a lambda directly as 'operation'
    val sum = operate(5, 3) { x, y -> x + y }
    // Here, { x, y -> x + y } is a lambda function:
    // - 'x' corresponds to 'a', 'y' corresponds to 'b'
    // - Returns their sum

    println(sum) // Output: 8
    // The lambda executes inside 'operate', so result is returned and printed
}


//
//Explanation for Interviews
//
//operate is a Higher-Order Function because it accepts a function (operation) as a parameter.
//
//{ x, y -> x + y } is a lambda function passed to operate.
//
//Using HOF + lambda allows writing concise and flexible code.
//
//This pattern is commonly used in Kotlin standard library functions like map, filter, and reduce.