# EPAM Android Developer Interview - Conceptual and Situation-Based Q\&A

This document provides a curated set of conceptual, situation-based, and coding questions for Android developer interviews at EPAM. All topics and questions are clickable for quick navigation.

---

## Table of Contents

### Kotlin Fundamentals

* [Explain the difference between `val` and `var`](#q-explain-the-difference-between-val-and-var-in-kotlin)
* [What is the purpose of the `lateinit` keyword\`](#q-what-is-the-purpose-of-the-lateinit-keyword)
* [How does Kotlin handle null safety?](#q-how-does-kotlin-handle-null-safety)
* [What is the significance of the `companion object` in Kotlin?](#q-what-is-the-significance-of-the-companion-object-in-kotlin)

### Android Architecture

* [Describe the MVVM architecture](#q-describe-the-mvvm-architecture)
* [What is the role of LiveData in MVVM](#q-what-is-the-role-of-livedata-in-mvvm)
* [Explain the difference between ViewModel and Presenter](#q-explain-the-difference-between-viewmodel-and-presenter)
* [How do you manage background tasks in Android?](#q-how-do-you-manage-background-tasks-in-android)

### Concurrency & Coroutines

* [Difference between `launch` and `async`](#q-what-is-the-difference-between-launch-and-async-in-kotlin-coroutines)
* [Explain Dispatchers in Kotlin Coroutines](#q-explain-the-concept-of-dispatchers-in-kotlin-coroutines)
* [How to handle exceptions in coroutines?](#q-how-do-you-handle-exceptions-in-coroutines)
* [What is the purpose of `withContext`?](#q-what-is-the-purpose-of-withcontext-in-coroutines)

### Dependency Injection

* [What is Dependency Injection?](#q-what-is-dependency-injection-di)
* [Constructor injection vs Field injection](#q-explain-the-difference-between-constructor-injection-and-field-injection)
* [How does Dagger/Hilt facilitate DI?](#q-how-does-daggerhilt-facilitate-di-in-android)
* [Benefits of using DI in Android](#q-what-are-the-benefits-of-using-di-in-android-applications)

### Design Patterns

* [Explain the Singleton pattern](#q-explain-the-singleton-design-pattern)
* [What is the Factory pattern?](#q-what-is-the-factory-design-pattern)
* [Describe the Observer pattern](#q-describe-the-observer-pattern-and-its-use-in-android)
* [How does the Adapter pattern work in Android?](#q-how-does-the-adapter-pattern-work-in-android)

### Situation-Based Questions

* [Handling configuration changes](#q-how-would-you-handle-configuration-changes-like-screen-rotation-in-android)
* [Preserving data during configuration changes](#q-how-do-you-preserve-data-during-configuration-changes)
* [Perform a network request in the background](#q-you-need-to-perform-a-network-request-in-the-background-how-would-you-implement-this-in-android)
* [Background tasks when app is in background or killed](#q-explain-how-you-would-handle-background-tasks-when-the-app-is-in-the-background-or-killed)
* [Long-running task updates UI](#q-you-have-a-long-running-task-that-updates-the-ui-how-do-you-ensure-ui-remains-responsive)
* [Local data storage](#q-how-would-you-implement-local-data-storage-in-android)
* [Error handling in network request](#q-describe-how-you-would-handle-errors-in-a-network-request)

### Coding Challenge Example

* [Find duplicate elements in an array](#q-write-a-kotlin-function-to-find-duplicate-elements-in-an-array)

### Preparation Tips

* [Preparation tips](#q-preparation-tips)

---

## Kotlin Fundamentals

### Q: Explain the difference between `val` and `var` in Kotlin

* `val` is read-only; once assigned, cannot be changed.
* `var` is mutable; it can be reassigned.

### Q: What is the purpose of the `lateinit` keyword

* Allows late initialization of non-nullable properties, often used in dependency injection or Android views.

### Q: How does Kotlin handle null safety?

* Nullable types (`String?`) vs Non-nullable types (`String`).
* Use `?.`, `?:`, and `!!` operators to handle null safely.

### Q: What is the significance of the `companion object` in Kotlin?

* Defines static-like members tied to the class, not instance.

---

## Android Architecture

### Q: Describe the MVVM architecture

* Separates View, ViewModel, and Model.
* View observes LiveData from ViewModel for automatic UI updates.

### Q: What is the role of LiveData in MVVM?

* Holds observable data.
* Updates the UI automatically when data changes.

### Q: Explain the difference between ViewModel and Presenter

* ViewModel is lifecycle-aware and works with LiveData.
* Presenter is part of MVP and directly updates the View.

### Q: How do you manage background tasks in Android?

* Use Coroutines, WorkManager, or Executors depending on task type and lifecycle.

---

## Concurrency & Coroutines

### Q: What is the difference between `launch` and `async` in Kotlin Coroutines

* `launch`: runs coroutine, does not return result.
* `async`: returns Deferred, can be awaited for result.

### Q: Explain the concept of Dispatchers in Kotlin Coroutines

* `Dispatchers.Main`: UI thread
* `Dispatchers.IO`: network/file operations
* `Dispatchers.Default`: CPU-intensive tasks

### Q: How do you handle exceptions in coroutines?

* Use `try-catch` inside coroutine or `CoroutineExceptionHandler`.

### Q: What is the purpose of `withContext` in coroutines?

* Switch coroutine context, e.g., Main <-> IO, to safely perform tasks.

---

## Dependency Injection

### Q: What is Dependency Injection (DI)?

* DI provides class dependencies externally instead of creating them internally.

### Q: Explain the difference between constructor injection and field injection

* Constructor injection: dependencies passed via constructor (preferred).
* Field injection: use annotations to inject into class properties.

### Q: How does Dagger/Hilt facilitate DI in Android?

* Generates code for managing object creation and lifecycle automatically.

### Q: What are the benefits of using DI in Android applications?

* Improves testability, reduces boilerplate, and separates concerns.

---

## Design Patterns

### Q: Explain the Singleton design pattern

* Ensures only one instance exists and provides global access.

### Q: What is the Factory design pattern?

* Creates objects without exposing instantiation logic; provides interface for creation.

### Q: Describe the Observer pattern and its use in Android

* Objects subscribe to changes in another object.
* LiveData and event listeners implement this.

### Q: How does the Adapter pattern work in Android?

* Bridges data source and UI component like RecyclerView, converting data into views.

---

## Situation-Based Questions

### Q: How would you handle configuration changes (like screen rotation) in Android?

* Use ViewModel to store UI data.
* Temporary UI state: `onSaveInstanceState`.

### Q: How do you preserve data during configuration changes?

* Store important data in ViewModel or persist in Bundle.

### Q: You need to perform a network request in the background. How would you implement this in Android?

* Use Kotlin Coroutines with `Dispatchers.IO` or WorkManager.

### Q: Explain how you would handle background tasks when the app is in the background or killed

* Use WorkManager, JobScheduler, or foreground services depending on task importance.

### Q: You have a long-running task that updates the UI. How do you ensure UI remains responsive?

* Run the task on background thread using Coroutines, update UI on Main thread with `withContext(Dispatchers.Main)`.

### Q: How would you implement local data storage in Android?

* SharedPreferences for small key-value pairs.
* SQLite or Room for structured data.
* File storage for custom needs.

### Q: Describe how you would handle errors in a network request

* Use `try-catch`, display user-friendly messages, implement retry strategies.

---

## Coding Challenge Example

### Q: Write a Kotlin function to find duplicate elements in an array

```kotlin
fun findDuplicates(arr: IntArray): Set<Int> {
    val seen = mutableSetOf<Int>()
    val duplicates = mutableSetOf<Int>()

    for (num in arr) {
        if (!seen.add(num)) {
            duplicates.add(num)
        }
    }
    return duplicates
}

fun main() {
    val arr = intArrayOf(1, 2, 3, 2, 4, 5, 1, 6, 3)
    val result = findDuplicates(arr)
    println("Duplicate elements: $result")
}
```

**Answer Explanation:**

* `seen` tracks unique elements.
* If `add` returns false, element is duplicate.
* Efficient and easy to explain in interviews.

---

## Preparation Tips

### Q: Preparation tips

* Review Android lifecycle and Jetpack components.
* Practice Kotlin features: higher-order functions, lambdas, coroutines.
* Prepare past projects challenges and solutions.
* Solve coding problems on arrays, strings, and collections.
* Understand Dependency Injection, Singleton, and common design patterns in Android.

---

**End of Document**
