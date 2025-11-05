# 🏗️ Android System Design Q&A

This document explains **Android app system design principles**, including scalable architectures, modularization, caching, offline strategies, and system optimization techniques used in production Android applications.

---

## 🧭 Table of Contents

### Section 13: Android System Design
* [How would you design a scalable Android app architecture?](#q-how-would-you-design-a-scalable-android-app-architecture)
* [What is the difference between MVC, MVP, and MVVM?](#q-what-is-the-difference-between-mvc-mvp-and-mvvm)
* [How would you structure a large, multi-module Android project?](#q-how-would-you-structure-a-large-multi-module-android-project)
* [Explain Clean Architecture in Android](#q-explain-clean-architecture-in-android)
* [What is the Repository pattern and why is it used?](#q-what-is-the-repository-pattern-and-why-is-it-used)
* [How do you design an offline-first Android app?](#q-how-do-you-design-an-offline-first-android-app)
* [How do you handle network retries and backoff strategies?](#q-how-do-you-handle-network-retries-and-backoff-strategies)
* [Explain caching strategies in Android](#q-explain-caching-strategies-in-android)
* [What is pagination and how is it implemented efficiently?](#q-what-is-pagination-and-how-is-it-implemented-efficiently)
* [How do you design push notification architecture?](#q-how-do-you-design-push-notification-architecture)
* [How do you design a scalable image loading and caching system?](#q-how-do-you-design-a-scalable-image-loading-and-caching-system)
* [Explain how you would optimize startup time in a large Android app](#q-explain-how-you-would-optimize-startup-time-in-a-large-android-app)
* [How do you ensure modularization and feature isolation?](#q-how-do-you-ensure-modularization-and-feature-isolation)
* [What are the main layers in a modern Android system design?](#q-what-are-the-main-layers-in-a-modern-android-system-design)
* [Best practices for scalable Android system design](#q-best-practices-for-scalable-android-system-design)

---

## Section 13: Android System Design

---

### Q: How would you design a scalable Android app architecture?

A scalable architecture separates concerns, improves testability, and supports independent evolution of each module.

**Recommended layers:**
- **Presentation Layer:** UI (Activity, Fragment, Compose) + ViewModel
- **Domain Layer:** Business logic and use cases
- **Data Layer:** Repository, local DB, and network sources
- **Dependency Injection Layer:** Hilt or Dagger for dependency management

**Flow:**

`UI (View, ViewModel) <-> Domain (UseCases) <-> Data (Repository, Local, Remote)`

🧠 **Memory Aid:** “UI asks → Domain decides → Data delivers.”

---

### Q: What is the difference between MVC, MVP, and MVVM?

| Pattern | View’s Role | Logic Holder | Communication |
|----------|-------------|---------------|----------------|
| **MVC** | View + Controller mixed | Controller | Tight coupling |
| **MVP** | View is passive | Presenter | Interface callbacks |
| **MVVM** | View observes data | ViewModel | LiveData / StateFlow |

🧠 **Memory Aid:** “MVVM = reactive, lifecycle-aware, and testable.”

---

### Q: How would you structure a large, multi-module Android project?

Split the project into **independent modules** for scalability, faster builds, and team parallelization.

**Typical structure:**
- `:app` → Main entry point (navigation host)
- `:core` → Common utilities (network, DB, shared UI)
- `:data` → Repository and API layer
- `:domain` → UseCases and pure business logic
- `:feature_x` → Independent app features (auth, profile, cart, etc.)

**Benefits:**
- Parallel feature development
- Reusable components
- Reduced build time

🧠 **Memory Aid:** “Divide modules — multiply efficiency.”

---

### Q: Explain Clean Architecture in Android

**Clean Architecture** enforces a clear separation of concerns.  
Each layer is independent and communicates in one direction — inward.

**Structure:**

`UI (View, ViewModel) <-> Domain (UseCases) <-> Data (Repository, Local, Remote)`

**Layer responsibilities:**
- **UI Layer:** Displays data, observes LiveData or StateFlow.
- **Domain Layer:** Pure Kotlin logic, independent from frameworks.
- **Data Layer:** Handles data from network or local DB.

**Benefits:**
- Highly testable
- Framework independent
- Maintainable and scalable

🧠 **Memory Aid:** “Flow inward, depend upward.”

---

### Q: What is the Repository pattern and why is it used?

A **Repository** abstracts data sources and provides a clean API for the rest of the app.

**Advantages:**
- Hides data source complexity (network vs. DB).
- Acts as a single source of truth.
- Simplifies mocking for testing.

🧠 **Memory Aid:** “Repository = unified data gateway.”

---

### Q: How do you design an offline-first Android app?

Ensure app reliability with **offline-first architecture** that prioritizes local data.

**Steps:**
1. Fetch data from cache (Room / DataStore).
2. Display cached content immediately.
3. Sync changes with backend when online.
4. Use timestamps or version control for conflict resolution.

🧠 **Memory Aid:** “Offline-first = serve local, sync remote.”

---

### Q: How do you handle network retries and backoff strategies?

Use **exponential backoff** for controlled retries after network failures.

**Methods:**
- Retrofit custom interceptor or `CallAdapter`.
- WorkManager’s built-in `setBackoffCriteria()`.
- Retry intervals: 1s → 2s → 4s → 8s...

🧠 **Memory Aid:** “Retry slow, recover steady.”

---

### Q: Explain caching strategies in Android

**Caching** improves speed and minimizes network use.

**Types:**
- **Memory Cache:** Fast, volatile (LruCache).
- **Disk Cache:** Persistent, slower (Room, SharedPrefs).
- **Hybrid:** Combination for balance.

🧠 **Memory Aid:** “RAM for speed, disk for persistence.”

---

### Q: What is pagination and how is it implemented efficiently?

**Pagination** loads data in chunks to improve performance and user experience.

**Best practice:** Use **Paging 3** library
- `PagingSource` for incremental data loading.
- `RemoteMediator` for combining DB + network.
- `PagingDataAdapter` with DiffUtil for smooth updates.

🧠 **Memory Aid:** “Load small, scroll smooth.”

---

### Q: How do you design push notification architecture?

**Flow:**
1. App registers FCM token.
2. Backend stores tokens per user.
3. Backend triggers notification via FCM.
4. Client receives via `FirebaseMessagingService`.

**Key parts:** FCM, server message router, app receiver.

🧠 **Memory Aid:** “Token → FCM → Device.”

---

### Q: How do you design a scalable image loading and caching system?

Use an image library (Glide / Coil / Fresco) with:
- Memory + Disk caching.
- Request deduplication.
- Placeholder + prefetching.

🧠 **Memory Aid:** “Cache smart, draw fast.”

---

### Q: Explain how you would optimize startup time in a large Android app

**Approach:**
- Lazy-load heavy SDKs (Firebase, Ads).
- Use **App Startup** library for on-demand init.
- Create **Baseline Profiles** for faster JIT/AOT startup.
- Defer background sync until post-launch.

🧠 **Memory Aid:** “Start light, load later.”

---

### Q: How do you ensure modularization and feature isolation?

Use **Dynamic Feature Modules** or clear Gradle boundaries:
- Isolate data + UI per feature.
- Shared contracts via interfaces.
- Limit cross-module dependencies.

🧠 **Memory Aid:** “Each feature = independent island.”

---

### Q: What are the main layers in a modern Android system design?

1. **Presentation Layer:** UI, ViewModel
2. **Domain Layer:** UseCases, business rules
3. **Data Layer:** Repository, local + remote
4. **DI Layer:** Hilt / Dagger for dependency graph
5. **Core Layer:** Utilities, shared components

🧠 **Memory Aid:** “Five layers of clean Android.”

---

### Q: Best practices for scalable Android system design

- Follow MVVM + Clean Architecture.
- Apply modularization early.
- Use WorkManager for reliable background work.
- Cache data effectively.
- Optimize network and image performance.
- Continuously profile startup and memory.

🧠 **Memory Aid:** “Structure + simplicity = scale.”

---

### 🧩 Section Summary

- Clean Architecture = modular + testable
- Repository = unified data source
- Offline-first + caching = resilient apps
- Modularization = scalable codebase
- Design for performance, not just features

---
