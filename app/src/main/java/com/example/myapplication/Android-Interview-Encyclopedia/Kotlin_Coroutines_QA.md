# Kotlin Coroutines Q&A

This document provides a deep-dive into Kotlin Coroutines — the backbone of modern Android concurrency — focusing on concepts, structure, scope management, and interview-ready examples.

---

## Table of Contents

### Section 1: Coroutine Fundamentals
* [What are Coroutines in Kotlin?](#q-what-are-coroutines-in-kotlin)
* [Why are Coroutines better than Threads?](#q-why-are-coroutines-better-than-threads)
* [What is a CoroutineScope?](#q-what-is-a-coroutinescope)
* [What is a Job in Coroutines?](#q-what-is-a-job-in-coroutines)
* [What are Dispatchers in Kotlin Coroutines?](#q-what-are-dispatchers-in-kotlin-coroutines)

### Section 2: Coroutine Builders & Context
* [Difference between launch and async](#q-difference-between-launch-and-async)
* [What is withContext and when to use it?](#q-what-is-withcontext-and-when-to-use-it)
* [How to switch between Dispatchers?](#q-how-to-switch-between-dispatchers)
* [What is runBlocking and where to use it?](#q-what-is-runblocking-and-where-to-use-it)
* [What is the difference between coroutineScope and supervisorScope?](#q-what-is-the-difference-between-coroutinescope-and-supervisorscope)

### Section 3: Structured Concurrency & Exception Handling
* [What is Structured Concurrency?](#q-what-is-structured-concurrency)
* [How does Coroutine cancellation work?](#q-how-does-coroutine-cancellation-work)
* [What happens if an exception occurs inside a Coroutine?](#q-what-happens-if-an-exception-occurs-inside-a-coroutine)
* [How to handle exceptions using CoroutineExceptionHandler?](#q-how-to-handle-exceptions-using-coroutineexceptionhandler)

### Section 4: Real-World Coroutine Usage
* [How to make parallel API calls using Coroutines?](#q-how-to-make-parallel-api-calls-using-coroutines)
* [How to cancel long-running tasks in Coroutines?](#q-how-to-cancel-long-running-tasks-in-coroutines)
* [How to handle timeouts in Coroutines?](#q-how-to-handle-timeouts-in-coroutines)
* [How to integrate Coroutines with ViewModel and LiveData?](#q-how-to-integrate-coroutines-with-viewmodel-and-livedata)
* [Best practices for Coroutine usage](#q-best-practices-for-coroutine-usage)

---

## Section 1: Coroutine Fundamentals

---

### Q: What are Coroutines in Kotlin?
Coroutines are **lightweight threads** that enable asynchronous, non-blocking programming.  
They simplify concurrent operations like network calls, database access, or complex workflows.

🧠 *Memory Aid:* “Coroutines = concurrency made simple.”

---

### Q: Why are Coroutines better than Threads?
| Feature | Threads | Coroutines |
|----------|----------|------------|
| Creation cost | High (OS-level) | Low (language-level) |
| Blocking | Yes | No |
| Context switching | Expensive | Lightweight |
| Quantity | Limited | Thousands possible |

🧠 *Memory Aid:* “Threads are heavyweight soldiers; Coroutines are agile ninjas.”

---

### Q: What is a CoroutineScope?
A **CoroutineScope** defines the **lifecycle and context** for launched coroutines.  
When the scope is canceled, all coroutines inside are also canceled.

Common scopes:
- `GlobalScope` – lives for app lifetime (avoid in most cases)
- `viewModelScope` – tied to ViewModel lifecycle
- `lifecycleScope` – tied to Activity/Fragment lifecycle

🧠 *Memory Aid:* “Scope = boundary of coroutine’s life.”

---

### Q: What is a Job in Coroutines?
A Job represents a **unit of work** in a coroutine.  
It can be canceled, joined, or tracked for completion.

🧠 *Memory Aid:* “Job = task ticket for coroutines.”

---

### Q: What are Dispatchers in Kotlin Coroutines?
Dispatchers define **which thread** a coroutine runs on:
- `Dispatchers.Main` → UI updates
- `Dispatchers.IO` → network, database, or file I/O
- `Dispatchers.Default` → CPU-heavy tasks
- `Dispatchers.Unconfined` → starts on caller thread

🧠 *Memory Aid:* “Main = UI, IO = data, Default = compute.”

---

## Section 2: Coroutine Builders & Context

---

### Q: Difference between launch and async
| Builder | Returns | Usage |
|----------|----------|-------|
| `launch` | Job | Fire-and-forget tasks |
| `async` | Deferred<T> | Returns a result via `await()` |

🧠 *Memory Aid:* “launch = do it; async = do it and give result.”

---

### Q: What is withContext and when to use it?
Switches execution context while keeping structured concurrency.  
Used to move between threads safely (e.g., IO → Main).

🧠 *Memory Aid:* “withContext = thread hop with structure.”

---

### Q: How to switch between Dispatchers?
Use `withContext()` or `launch(Dispatchers.IO)` inside a scope.  
Kotlin automatically handles thread switching without blocking.

🧠 *Memory Aid:* “Dispatchers change lanes, not threads.”

---

### Q: What is runBlocking and where to use it?
`runBlocking` starts a new coroutine and **blocks the current thread** until it finishes.  
Used mainly in **unit tests** or `main()` functions — not recommended in production.

🧠 *Memory Aid:* “runBlocking = main-thread stopper.”

---

### Q: What is the difference between coroutineScope and supervisorScope?
| Feature | coroutineScope | supervisorScope |
|----------|----------------|----------------|
| Child failure | Cancels parent and siblings | Does not cancel siblings |
| Use case | Strict structured concurrency | Independent child jobs |

🧠 *Memory Aid:* “coroutineScope = all for one; supervisorScope = one for all.”

---

## Section 3: Structured Concurrency & Exception Handling

---

### Q: What is Structured Concurrency?
Ensures all child coroutines complete before the parent finishes.  
Prevents “fire-and-forget” leaks or unfinished tasks.

🧠 *Memory Aid:* “Structured = no orphaned coroutines.”

---

### Q: How does Coroutine cancellation work?
Cancellation is **cooperative** — coroutines must check for `isActive` or use cancellable functions (like `delay()` or `withContext()`).

🧠 *Memory Aid:* “Cancel = request, coroutine must cooperate.”

---

### Q: What happens if an exception occurs inside a Coroutine?
- In `launch`, exception cancels the scope.
- In `async`, exception is deferred until `await()`.

🧠 *Memory Aid:* “launch = crash now; async = crash later.”

---

### Q: How to handle exceptions using CoroutineExceptionHandler?
Attach a `CoroutineExceptionHandler` to handle uncaught exceptions globally in `launch` coroutines.  
Not applicable to `async` (since it needs `await()`).

🧠 *Memory Aid:* “Handler = crash shield for coroutines.”

---

## Section 4: Real-World Coroutine Usage

---

### Q: How to make parallel API calls using Coroutines?
Use `async` for concurrent network calls and `awaitAll()` to wait for results.  
This avoids blocking and speeds up execution.

🧠 *Memory Aid:* “Parallelism = async + awaitAll.”

---

### Q: How to cancel long-running tasks in Coroutines?
Keep a reference to the `Job` and call `job.cancel()`.  
Always ensure proper cleanup after cancellation.

🧠 *Memory Aid:* “Cancel = signal stop, not force kill.”

---

### Q: How to handle timeouts in Coroutines?
Use `withTimeout()` or `withTimeoutOrNull()` to automatically cancel coroutines after a given time.

🧠 *Memory Aid:* “Timeout = safety net for hanging tasks.”

---

### Q: How to integrate Coroutines with ViewModel and LiveData?
Use `viewModelScope.launch` for tasks tied to ViewModel lifecycle.  
Update LiveData on `Dispatchers.Main` safely.

🧠 *Memory Aid:* “ViewModelScope = lifecycle-safe launchpad.”

---

### Q: Best practices for Coroutine usage
✅ Use **structured concurrency** always  
✅ Use `withContext(IO)` for heavy operations  
✅ Never use `GlobalScope` in production  
✅ Cancel coroutines on `onCleared()` (ViewModel) or `onDestroy()` (Activity)  
✅ Wrap API calls in `try-catch` for exception safety

🧠 *Memory Aid:* “Scope smart, switch right, cancel clean.”

---

### 🧩 Section Summary
- Coroutines = lightweight concurrency
- Scope = lifecycle boundary
- Dispatcher = thread strategy
- launch vs async = fire vs return
- SupervisorScope = isolate child failures
- Cancellation = cooperative
- ExceptionHandler = safety net
- Parallel calls = async/awaitAll
- Structured concurrency = no leaks

---

✅ **Notes**
- Fully formatted `.md` (GitHub-ready)
- Includes lifecycle-aware patterns (`viewModelScope`, `lifecycleScope`)
- Clear tables + memory cues + interview keywords
- Consistent style with other encyclopedia files  
