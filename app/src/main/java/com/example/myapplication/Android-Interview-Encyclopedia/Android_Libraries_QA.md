# 🧩 Android Libraries Q&A

This document explains key Android libraries — OkHttp, Retrofit, Dagger/Hilt, RxJava, Glide, and more — focusing on internal concepts, use cases, and best practices for interviews.

---

## 🧭 Table of Contents

### Section 12: Android Libraries
* [Explain OkHttp Interceptor](#q-explain-okhttp-interceptor)
* [How does OkHttp handle HTTP caching?](#q-how-does-okhttp-handle-http-caching)
* [How to enable logging in OkHttp?](#q-how-to-enable-logging-in-okhttp)
* [Why do we use Dependency Injection frameworks like Dagger/Hilt?](#q-why-do-we-use-dependency-injection-frameworks-like-daggerhilt)
* [Explain @Inject, @Module, @Provides, and @Component in Dagger 2](#q-explain-inject-module-provides-and-component-in-dagger-2)
* [How does Dagger work internally?](#q-how-does-dagger-work-internally)
* [When to use Dagger 2 vs Hilt?](#q-when-to-use-dagger-2-vs-hilt)
* [What is a Component in Dagger?](#q-what-is-a-component-in-dagger)
* [What is a Module in Dagger?](#q-what-is-a-module-in-dagger)
* [How does custom scope work in Dagger?](#q-how-does-custom-scope-work-in-dagger)
* [When to call dispose() and clear() on CompositeDisposable in RxJava?](#q-when-to-call-dispose-and-clear-on-compositedisposable-in-rxjava)
* [What is a Multipart Request in Networking?](#q-what-is-a-multipart-request-in-networking)
* [Tell something about RxJava and its key use cases](#q-tell-something-about-rxjava-and-its-key-use-cases)
* [How do you handle errors in RxJava?](#q-how-do-you-handle-errors-in-rxjava)
* [Difference between FlatMap and Map in RxJava](#q-difference-between-flatmap-and-map-in-rxjava)
* [Explain Subject and its types in RxJava](#q-explain-subject-and-its-types-in-rxjava)
* [Explain Glide and Fresco libraries](#q-explain-glide-and-fresco-libraries)
* [Schedulers.io() vs Schedulers.computation() in RxJava](#q-schedulersio-vs-schedulerscomputation-in-rxjava)
* [Best practices for third-party libraries](#q-best-practices-for-third-party-libraries)

---

## Section 12: Android Libraries

---

### Q: Explain OkHttp Interceptor
Interceptors in OkHttp allow you to inspect, modify, or retry network requests and responses before they reach the app or server.  
Commonly used for logging, authentication, and adding headers.

🧠 **Memory Aid:** “Interceptor = request/response checkpoint.”

---

### Q: How does OkHttp handle HTTP caching?
OkHttp supports transparent response caching based on cache headers.  
It stores responses on disk and serves them when valid, reducing network calls.  
You can customize caching behavior via Cache-Control headers or Cache class.

🧠 **Memory Aid:** “Cache first, call later — OkHttp saves bandwidth.”

---

### Q: How to enable logging in OkHttp?
Add an `HttpLoggingInterceptor` to the OkHttpClient to log request and response details (headers, body, duration).

🧠 **Memory Aid:** “LoggingInterceptor = network x-ray.”

---

### Q: Why do we use Dependency Injection frameworks like Dagger/Hilt?
Dependency Injection simplifies object creation and improves modularity, scalability, and testability.  
It removes manual dependency wiring and reduces boilerplate.

🧠 **Memory Aid:** “DI = less glue, more flow.”

---

### Q: Explain @Inject, @Module, @Provides, and @Component in Dagger 2
- **@Inject:** Marks where dependencies are requested or provided.
- **@Module:** Class that provides dependencies.
- **@Provides:** Defines how to construct a dependency.
- **@Component:** Connects modules and injection targets.

🧠 **Memory Aid:** “Inject = need; Provides = supply; Component = connect.”

---

### Q: How does Dagger work internally?
Dagger uses compile-time annotation processing to generate dependency graphs and factories.  
It avoids reflection and performs dependency injection at compile time — faster and safer.

🧠 **Memory Aid:** “Dagger = compile-time dependency assembler.”

---

### Q: When to use Dagger 2 vs Hilt?
- **Dagger 2:** For custom setups, modular libraries, or non-Android projects.
- **Hilt:** Simplified version built on Dagger for Android, with lifecycle integration and annotations.

🧠 **Memory Aid:** “Hilt = Dagger made Android-friendly.”

---

### Q: What is a Component in Dagger?
A Component is the bridge between dependency providers (Modules) and consumers (injected classes).  
It defines what to inject and where.

🧠 **Memory Aid:** “Component = connector of dependencies.”

---

### Q: What is a Module in Dagger?
A Module provides concrete implementations of dependencies using `@Provides` or `@Binds`.  
It tells Dagger how to create objects not automatically injectable.

🧠 **Memory Aid:** “Module = dependency factory.”

---

### Q: How does custom scope work in Dagger?
Custom scopes (e.g., `@ActivityScope`, `@FragmentScope`) define how long dependencies live.  
They ensure single instances within that lifecycle, preventing redundant creation.

🧠 **Memory Aid:** “Scope = lifespan control of dependency.”

---

### Q: When to call dispose() and clear() on CompositeDisposable in RxJava?
- `dispose()` completely stops all ongoing subscriptions and cannot be reused.
- `clear()` removes current disposables but allows adding new ones.  
  Call them in `onStop()` or `onDestroy()` to avoid leaks.

🧠 **Memory Aid:** “Dispose = kill; Clear = reset.”

---

### Q: What is a Multipart Request in Networking?
Multipart requests send multiple parts of data (text, files, etc.) in one HTTP request.  
Each part has its own content type and headers — commonly used for file uploads.

🧠 **Memory Aid:** “Multipart = many parts, one request.”

---

### Q: Tell something about RxJava and its key use cases
RxJava enables **reactive programming** — working with asynchronous streams of data/events.  
Used for:
- Chaining dependent API calls
- Combining multiple sources
- Handling asynchronous workflows

🧠 **Memory Aid:** “RxJava = reactive flow control.”

---

### Q: How do you handle errors in RxJava?
- Use `onErrorResumeNext()` or `retry()` to recover gracefully.
- Implement global error handlers to prevent silent crashes.
- Avoid swallowing exceptions.

🧠 **Memory Aid:** “Catch, resume, retry — never crash silently.”

---

### Q: Difference between FlatMap and Map in RxJava
- **Map:** transforms emitted items one-to-one.
- **FlatMap:** converts each emission into a new Observable, merging results concurrently.

🧠 **Memory Aid:** “Map = replace; FlatMap = explode.”

---

### Q: Explain Subject and its types in RxJava
Subjects act as both **Observable** and **Observer**.

Types:
- **PublishSubject:** emits items to current subscribers only.
- **BehaviorSubject:** emits latest item and new ones.
- **ReplaySubject:** replays all previous items.
- **AsyncSubject:** emits last value after completion.

🧠 **Memory Aid:** “Subject = both speaker and listener.”

---

### Q: Explain Glide and Fresco libraries
Both libraries efficiently handle image loading, caching, and memory management.

- **Glide:** lightweight, easy to integrate, supports GIFs and transformations.
- **Fresco:** Facebook’s advanced pipeline, great for handling large or complex images.

🧠 **Memory Aid:** “Glide = smooth; Fresco = powerful.”

---

### Q: Schedulers.io() vs Schedulers.computation() in RxJava
- **Schedulers.io():** for I/O-bound tasks (network, disk, DB).
- **Schedulers.computation():** for CPU-bound tasks (math, data processing).

🧠 **Memory Aid:** “IO = network; Computation = math.”

---

### Q: Best practices for third-party libraries
- Use the latest stable versions.
- Avoid unnecessary dependencies to reduce APK size.
- Keep libraries updated for security.
- Monitor performance (memory, network).

🧠 **Memory Aid:** “Few, fast, and updated — smart library usage.”

---

### 🧩 Section Summary
- **OkHttp** = efficient network engine
- **Dagger/Hilt** = dependency management
- **RxJava** = reactive streams
- **Glide/Fresco** = optimized image loaders
- Use libraries wisely — **quality > quantity**

---
