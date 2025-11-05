# Kotlin Core Q&A

This document covers Kotlin language essentials and practical interview-ready explanations for Android developers.

---

## Table of Contents

### Section 1: Kotlin Basics
* [What is the difference between `val` and `var`?](#q-what-is-the-difference-between-val-and-var)
* [What is the purpose of `lateinit`?](#q-what-is-the-purpose-of-lateinit)
* [How does Kotlin handle null safety?](#q-how-does-kotlin-handle-null-safety)
* [What is the Elvis operator?](#q-what-is-the-elvis-operator)
* [What is the `when` expression?](#q-what-is-the-when-expression)
* [Difference between `==` and `===` in Kotlin?](#q-difference-between--and--in-kotlin)
* [What is the purpose of `companion object`?](#q-what-is-the-purpose-of-companion-object)
* [Explain `data class` in Kotlin.](#q-explain-data-class-in-kotlin)

### Section 2: Functions & Lambdas
* [What are higher-order functions?](#q-what-are-higher-order-functions)
* [What are extension functions?](#q-what-are-extension-functions)
* [What are inline functions and why use them?](#q-what-are-inline-functions-and-why-use-them)
* [What are lambda expressions in Kotlin?](#q-what-are-lambda-expressions-in-kotlin)

### Section 3: Collections & Generics
* [Difference between List, Set, and Map in Kotlin.](#q-difference-between-list-set-and-map-in-kotlin)
* [Mutable vs Immutable collections.](#q-mutable-vs-immutable-collections)
* [What are generics in Kotlin?](#q-what-are-generics-in-kotlin)
* [What is variance (`in`, `out`, `*`) in Kotlin Generics?](#q-what-is-variance-in-out--in-kotlin-generics)

### Section 4: Classes, Objects & Interfaces
* [Difference between abstract class and interface.](#q-difference-between-abstract-class-and-interface)
* [What is object declaration vs object expression?](#q-what-is-object-declaration-vs-object-expression)
* [Explain sealed classes and their use.](#q-explain-sealed-classes-and-their-use)
* [What are data classes and why are they useful?](#q-what-are-data-classes-and-why-are-they-useful)

### Section 5: Kotlin Advanced Topics
* [What are coroutines in simple terms?](#q-what-are-coroutines-in-simple-terms)
* [What are inline, crossinline, and noinline keywords?](#q-what-are-inline-crossinline-and-noinline-keywords)
* [What is delegation in Kotlin?](#q-what-is-delegation-in-kotlin)
* [What is the difference between const and val?](#q-what-is-the-difference-between-const-and-val)
* [Explain Kotlin’s smart casts.](#q-explain-kotlins-smart-casts)

---

## Section 1: Kotlin Basics

---

### Q: What is the difference between `val` and `var`?
- **`val`** → Immutable reference (read-only).
- **`var`** → Mutable reference (value can be reassigned).

🧠 *Memory Aid:* “`val` = value fixed; `var` = variable reassignable.”

---

### Q: What is the purpose of `lateinit`?
Used to initialize a non-nullable variable later (e.g., dependency injection or views).  
Cannot be used with primitive types or inside constructors.

🧠 *Memory Aid:* “Late but guaranteed.”

---

### Q: How does Kotlin handle null safety?
Kotlin distinguishes nullable (`String?`) and non-nullable (`String`) types.  
Operators:
- `?.` → safe call
- `?:` → Elvis operator
- `!!` → force unwrap

🧠 *Memory Aid:* “? means maybe null, !! means crash if wrong.”

---

### Q: What is the Elvis operator?
`val result = value ?: "default"`  
If `value` is null, `"default"` is returned.  
A shorthand for null checking.

🧠 *Memory Aid:* “If null, fallback — that’s Elvis.”

---

### Q: What is the `when` expression?
Replaces `switch`. Returns a value and supports complex conditions.

🧠 *Memory Aid:* “`when` = expressive `switch` with brains.”

---

### Q: Difference between `==` and `===` in Kotlin?
- `==` → structural equality (compares values via `equals()`).
- `===` → referential equality (compares memory references).

🧠 *Memory Aid:* “Double equals for value, triple for identity.”

---

### Q: What is the purpose of `companion object`?
Acts like static members of a class.  
Holds constants, factories, or helper methods.

🧠 *Memory Aid:* “Companion = static friend of the class.”

---

### Q: Explain `data class` in Kotlin.
Used to store data with automatic `equals()`, `hashCode()`, and `toString()`.  
Primary constructor defines properties.

🧠 *Memory Aid:* “Data class = value holder with free utilities.”

---

## Section 2: Functions & Lambdas

---

### Q: What are higher-order functions?
Functions that accept functions as parameters or return functions.  
Example: `map`, `filter`, `reduce`.

🧠 *Memory Aid:* “Functions that play with functions.”

---

### Q: What are extension functions?
Let you add new behavior to existing classes without inheritance.  
Declared as `fun ClassName.newFunction() { ... }`.

🧠 *Memory Aid:* “Add skill to class without changing DNA.”

---

### Q: What are inline functions and why use them?
Inline functions copy the lambda body into the call site, reducing overhead of function objects and call stacks.  
Useful in performance-critical code.

🧠 *Memory Aid:* “Inline = cut, paste, run faster.”

---

### Q: What are lambda expressions in Kotlin?
Anonymous functions that can be passed as parameters.  
Syntax: `{ x, y -> x + y }`.

🧠 *Memory Aid:* “Lambda = nameless function with arrows.”

---

## Section 3: Collections & Generics

---

### Q: Difference between List, Set, and Map in Kotlin.
| Type | Description |
|------|--------------|
| List | Ordered, allows duplicates |
| Set | Unordered, unique elements |
| Map | Key-value pairs |

🧠 *Memory Aid:* “List repeats, Set filters, Map pairs.”

---

### Q: Mutable vs Immutable collections.
Immutable collections (`listOf()`, `mapOf()`) cannot change after creation.  
Mutable ones (`mutableListOf()`, `mutableMapOf()`) can add/remove elements.

🧠 *Memory Aid:* “Immutable = fixed; Mutable = flexible.”

---

### Q: What are generics in Kotlin?
Generics allow writing reusable code with type parameters.  
Example: `class Box<T>(val item: T)`

🧠 *Memory Aid:* “T = type placeholder.”

---

### Q: What is variance (`in`, `out`, `*`) in Kotlin Generics?
- `out` → Covariant (producer)
- `in` → Contravariant (consumer)
- `*` → Star projection (unknown type)

🧠 *Memory Aid:* “Out = give; In = take; * = mystery.”

---

## Section 4: Classes, Objects & Interfaces

---

### Q: Difference between abstract class and interface.
| Feature | Abstract Class | Interface |
|----------|----------------|-----------|
| State | Can hold state | Cannot (except `val`) |
| Constructors | Allowed | Not allowed |
| Multiple inheritance | Single only | Multiple allowed |

🧠 *Memory Aid:* “Abstract = partial class; Interface = contract.”

---

### Q: What is object declaration vs object expression?
- **Object declaration:** singleton instance (e.g., `object NetworkManager`).
- **Object expression:** anonymous object for one-time use.

🧠 *Memory Aid:* “Declaration = forever; Expression = temporary.”

---

### Q: Explain sealed classes and their use.
Sealed classes restrict class hierarchies — all subclasses must be declared in the same file.  
Used with `when` for exhaustive conditions.

🧠 *Memory Aid:* “Sealed = closed hierarchy.”

---

### Q: What are data classes and why are they useful?
Hold immutable data and auto-generate useful methods.  
Ideal for DTOs, models, or state containers.

🧠 *Memory Aid:* “Data class = auto-generated boilerplate killer.”

---

## Section 5: Kotlin Advanced Topics

---

### Q: What are coroutines in simple terms?
Lightweight threads for asynchronous programming.  
Run tasks without blocking the main thread.

🧠 *Memory Aid:* “Coroutines = concurrency made simple.”

---

### Q: What are inline, crossinline, and noinline keywords?
| Keyword | Purpose |
|----------|----------|
| inline | Replaces function calls with body code |
| noinline | Prevents inlining specific lambdas |
| crossinline | Prevents non-local returns in inline lambdas |

🧠 *Memory Aid:* “Inline faster; Crossinline safer; Noinline flexible.”

---

### Q: What is delegation in Kotlin?
A class can delegate method calls to another class using `by`.  
Simplifies wrapper or decorator patterns.

🧠 *Memory Aid:* “Delegate = pass the work along.”

---

### Q: What is the difference between const and val?
- `const` → compile-time constant (top-level or object only)
- `val` → runtime assigned, read-only reference

🧠 *Memory Aid:* “const = compile; val = runtime.”

---

### Q: Explain Kotlin’s smart casts.
The compiler automatically casts a variable to its correct type after type checks.  

