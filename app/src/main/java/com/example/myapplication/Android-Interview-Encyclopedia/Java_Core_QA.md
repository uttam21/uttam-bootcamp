# ☕ Java Core Q&A

This document compiles **Java fundamentals and advanced concepts** relevant for Android developer interviews — focusing on OOP, SOLID principles, concurrency, collections, and JVM internals.

---

## 🧭 Table of Contents

### Section 15: Java Core
* [Explain SOLID principles in Java](#q-explain-solid-principles-in-java)
* [Explain OOP concepts](#q-explain-oop-concepts)
* [Difference between abstract class and interface](#q-difference-between-abstract-class-and-interface)
* [Difference between method overloading and overriding](#q-difference-between-method-overloading-and-overriding)
* [Explain String Pool and immutability](#q-explain-string-pool-and-immutability)
* [Access modifiers in Java](#q-access-modifiers-in-java)
* [Interface extending another interface](#q-interface-extending-another-interface)
* [Explain Polymorphism and Inheritance](#q-explain-polymorphism-and-inheritance)
* [Collections and Generics overview](#q-collections-and-generics-overview)
* [Primitive vs Wrapper classes](#q-primitive-vs-wrapper-classes)
* [Java Memory Model and Garbage Collector](#q-java-memory-model-and-garbage-collector)
* [Threading and Concurrency](#q-threading-and-concurrency)
* [Explain Exceptions in Java](#q-explain-exceptions-in-java)
* [Reflection and Dependency Injection](#q-reflection-and-dependency-injection)
* [final, finally, finalize keywords](#q-final-finally-finalize-keywords)
* [throw vs throws](#q-throw-vs-throws)
* [Static keyword and usage](#q-static-keyword-and-usage)
* [Shallow vs Deep copy](#q-shallow-vs-deep-copy)
* [Serialization and Deserialization](#q-serialization-and-deserialization)
* [StringBuffer vs StringBuilder](#q-stringbuffer-vs-stringbuilder)
* [Fail-fast vs Fail-safe iterators](#q-fail-fast-vs-fail-safe-iterators)
* [Volatile and Synchronization concepts](#q-volatile-and-synchronization-concepts)
* [Monitor and Lock concepts](#q-monitor-and-lock-concepts)
* [Memory Aid Summary](#memory-aid-summary)

---

## Section 15: Java Core

---

### Q: Explain SOLID principles in Java
**S** — Single Responsibility: each class should have one purpose.  
**O** — Open/Closed: open for extension, closed for modification.  
**L** — Liskov Substitution: subclasses should substitute base classes safely.  
**I** — Interface Segregation: multiple small interfaces > one big interface.  
**D** — Dependency Inversion: depend on abstractions, not concretions.

🧠 **Memory Aid:** “SOLID = design that doesn’t crack.”

---

### Q: Explain OOP concepts
- **Encapsulation:** data + methods wrapped together.
- **Inheritance:** reuse behavior via parent-child relationship.
- **Polymorphism:** one interface, many implementations.
- **Abstraction:** hide complex implementation behind simple interface.

🧠 **Memory Aid:** “E-I-P-A = OOP’s DNA.”

---

### Q: Difference between abstract class and interface
| Feature | Abstract Class | Interface |
|----------|----------------|------------|
| Implementation | Can have both concrete and abstract methods | Only abstract (Java 7); default/static allowed (Java 8+) |
| Inheritance | Single | Multiple |
| Use case | Common base logic | Contract definition |

🧠 **Memory Aid:** “Abstract = partial plan; Interface = full contract.”

---

### Q: Difference between method overloading and overriding
- **Overloading:** same method name, different parameters (compile-time polymorphism).
- **Overriding:** same signature in subclass (runtime polymorphism).

🧠 **Memory Aid:** “Overload = same name, new params; Override = same name, new behavior.”

---

### Q: Explain String Pool and immutability
Strings are immutable and stored in a special pool.  
Creating a literal reuses existing references to save memory.  
`new String("abc")` forces a new object; `"abc"` reuses the pool.

🧠 **Memory Aid:** “String pool = memory savings vault.”

---

### Q: Access modifiers in Java
| Modifier | Scope |
|-----------|--------|
| private | Within the class only |
| default (no keyword) | Within package |
| protected | Package + subclasses |
| public | Everywhere |

🧠 **Memory Aid:** “Private → Default → Protected → Public = least to most open.”

---

### Q: Interface extending another interface
Yes. Interfaces can extend multiple other interfaces (using `extends`) and add new methods, but cannot remove any.

🧠 **Memory Aid:** “Interfaces grow upward, never backward.”

---

### Q: Explain Polymorphism and Inheritance
Polymorphism enables one interface to have multiple implementations.  
Inheritance allows code reuse and hierarchy design.

🧠 **Memory Aid:** “Inheritance gives, polymorphism changes.”

---

### Q: Collections and Generics overview
**Collections:** dynamic data structures (List, Set, Map).  
**Generics:** enforce type safety at compile time (`List<String>` prevents wrong types).

🧠 **Memory Aid:** “Generics = type guard; Collections = data playground.”

---

### Q: Primitive vs Wrapper classes
| Primitive | Wrapper |
|------------|----------|
| int | Integer |
| char | Character |
| boolean | Boolean |
| float | Float |
| double | Double |
| long | Long |
| byte | Byte |
| short | Short |

Wrappers provide utility methods and can be `null`.

🧠 **Memory Aid:** “Primitives are light; Wrappers are smart.”

---

### Q: Java Memory Model and Garbage Collector
Java memory = Heap + Stack + Metaspace.  
GC automatically reclaims unreachable objects.  
Common collectors: Serial, Parallel, G1.

🧠 **Memory Aid:** “Heap holds, Stack tracks, GC cleans.”

---

### Q: Threading and Concurrency
- **synchronized** keyword ensures mutual exclusion.
- **volatile** ensures visibility of variable updates.
- **ThreadPoolExecutor** manages worker threads efficiently.

🧠 **Memory Aid:** “Thread safety = visibility + atomicity + order.”

---

### Q: Explain Exceptions in Java
- **Checked Exceptions:** must be declared or handled (`IOException`).
- **Unchecked Exceptions:** runtime (`NullPointerException`).
- **finally block:** always executes for cleanup.

🧠 **Memory Aid:** “Checked = compile; Unchecked = runtime.”

---

### Q: Reflection and Dependency Injection
**Reflection:** inspecting or modifying classes, methods, or fields at runtime.  
Used by DI frameworks (Dagger/Hilt) to wire dependencies dynamically.

🧠 **Memory Aid:** “Reflection = runtime mirror of code.”

---

### Q: final, finally, finalize keywords
| Keyword | Purpose |
|----------|----------|
| final | Constant or prevent override |
| finally | Cleanup block after try-catch |
| finalize | Called before GC (deprecated) |

🧠 **Memory Aid:** “Final stops, Finally cleans, Finalize ends.”

---

### Q: throw vs throws
- **throw:** actually throws an exception.
- **throws:** declares that a method might throw an exception.

🧠 **Memory Aid:** “throw = act; throws = warn.”

---

### Q: Static keyword and usage
Static members belong to the class, not instances.  
Used for constants, utility methods, or shared resources.

🧠 **Memory Aid:** “Static = one for all.”

---

### Q: Shallow vs Deep copy
- **Shallow:** copies references (changes affect both).
- **Deep:** copies values recursively (independent clone).

🧠 **Memory Aid:** “Shallow shares; Deep separates.”

---

### Q: Serialization and Deserialization
Converting objects to byte streams (and back).  
Used in Android for passing data via Intents or saving to disk.  
`transient` keyword skips non-serializable fields.

🧠 **Memory Aid:** “Serialize = freeze; Deserialize = revive.”

---

### Q: StringBuffer vs StringBuilder
- **StringBuffer:** thread-safe (synchronized).
- **StringBuilder:** faster, not thread-safe.  
  Both mutable unlike `String`.

🧠 **Memory Aid:** “Buffer = safe; Builder = speed.”

---

### Q: Fail-fast vs Fail-safe iterators
| Type | Behavior | Example |
|------|-----------|----------|
| Fail-fast | Throws `ConcurrentModificationException` | ArrayList, HashMap |
| Fail-safe | Works on copy | CopyOnWriteArrayList |

🧠 **Memory Aid:** “Fast fails, Safe survives.”

---

### Q: Volatile and Synchronization concepts
**volatile:** ensures variable updates are visible across threads.  
**synchronized:** locks a block to prevent concurrent access.

🧠 **Memory Aid:** “Volatile = visibility; Sync = control.”

---

### Q: Monitor and Lock concepts
Every Java object has an intrinsic monitor (lock).  
Used in synchronization to allow only one thread access at a time.

🧠 **Memory Aid:** “One lock, one thread, one peace.”

---

### Memory Aid Summary
- SOLID = structured design
- OOP = 4 pillars
- GC = automatic cleanup
- Threads = concurrency control
- Reflection = runtime power
- Exceptions = predictable handling
- Static & final = shared and sealed

---
