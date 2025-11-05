# Architecture and Design Q&A

This document explains key Android architecture and design principles — focusing on MVVM, Clean Architecture, Repository patterns, Dependency Inversion, and practical design best practices for scalable apps.

---

## Table of Contents

### Section 1: App Architecture Principles
* [What is the importance of architecture in Android apps?](#q-what-is-the-importance-of-architecture-in-android-apps)
* [Explain the MVVM architecture](#q-explain-the-mvvm-architecture)
* [What is the Clean Architecture approach?](#q-what-is-the-clean-architecture-approach)
* [Explain the layered architecture of an Android app](#q-explain-the-layered-architecture-of-an-android-app)
* [Difference between MVC, MVP, and MVVM](#q-difference-between-mvc-mvp-and-mvvm)
* [How do you decide between MVVM and MVI?](#q-how-do-you-decide-between-mvvm-and-mvi)
* [What is Dependency Inversion and why is it important?](#q-what-is-dependency-inversion-and-why-is-it-important)
* [Explain the Repository pattern and its role in Android apps](#q-explain-the-repository-pattern-and-its-role-in-android-apps)
* [What is the role of UseCases in Clean Architecture?](#q-what-is-the-role-of-usecases-in-clean-architecture)
* [How does Dependency Injection support architecture?](#q-how-does-dependency-injection-support-architecture)
* [What are some best practices for app architecture design?](#q-what-are-some-best-practices-for-app-architecture-design)

---

## Section 1: App Architecture Principles

---

### Q: What is the importance of architecture in Android apps?
Architecture ensures **code maintainability, testability, and scalability**.  
It separates UI logic from business logic, preventing spaghetti code as apps grow.

🧠 *Memory Aid:* “Architecture = blueprint for long-term survival.”

---

### Q: Explain the MVVM architecture
**MVVM (Model–View–ViewModel)** separates UI, business logic, and data.  
It promotes **lifecycle awareness**, **testability**, and **data binding**.

**Flow:**  
UI (View, ViewModel) <-> Domain (UseCases) <-> Data (Repository, Local, Remote)

| Layer | Role |
|--------|------|
| View | Displays data & observes ViewModel |
| ViewModel | Holds UI state, processes logic, communicates with UseCases |
| Model | Manages data sources (repository, DB, network) |

🧠 *Memory Aid:* “View listens, ViewModel thinks, Model delivers.”

---

### Q: What is the Clean Architecture approach?
Proposed by Robert C. Martin (Uncle Bob), Clean Architecture emphasizes separation of concerns using **independent layers**.

**Recommended layers:**
- **Presentation Layer:** UI (Activity, Fragment, Compose) + ViewModel
- **Domain Layer:** Business logic and use cases
- **Data Layer:** Repository, local DB, and network sources
- **Dependency Injection Layer:** Hilt or Dagger for dependency management

**Flow:**  
UI (View, ViewModel) <-> Domain (UseCases) <-> Data (Repository, Local, Remote)

🧠 *Memory Aid:* “Outer depends on inner, never the reverse.”

---

### Q: Explain the layered architecture of an Android app
Android apps typically follow a **3-layered architecture**:
1. **Presentation:** Handles UI (Activity, Fragment, Compose)
2. **Domain:** Contains pure Kotlin logic (UseCases)
3. **Data:** Manages repositories, DAOs, and APIs

Each layer interacts through **interfaces** to maintain abstraction.

🧠 *Memory Aid:* “Top talks down, bottom never looks up.”

---

### Q: Difference between MVC, MVP, and MVVM
| Pattern | View responsibility | Logic handling | Testability | Android Fit |
|----------|---------------------|----------------|--------------|--------------|
| MVC | Heavy View | Controller | Low | Legacy |
| MVP | Presenter manages logic | View passive | Medium | OK |
| MVVM | ViewModel observes LiveData/Flow | View observes data | High | ✅ Best for Jetpack |

🧠 *Memory Aid:* “MVC = tangled, MVP = managed, MVVM = modern.”

---

### Q: How do you decide between MVVM and MVI?
| Feature | MVVM | MVI |
|----------|------|-----|
| Data flow | Two-way binding | Unidirectional |
| Complexity | Moderate | Higher |
| State handling | Simple LiveData/StateFlow | Single immutable state |
| Use case | General apps | Predictable state-driven UI |

🧠 *Memory Aid:* “MVVM = two-way simplicity; MVI = single truth power.”

---

### Q: What is Dependency Inversion and why is it important?
Part of SOLID principles — it ensures **high-level modules** do not depend on **low-level implementations**, but on **abstractions (interfaces)**.

It improves:
- Flexibility
- Testability
- Scalability

🧠 *Memory Aid:* “Depend on contracts, not concretes.”

---

### Q: Explain the Repository pattern and its role in Android apps
The Repository acts as a **single source of truth** that abstracts data operations.  
It decides whether data comes from **local (Room)** or **remote (API)** sources.

**Flow:**  
ViewModel <-> Repository <-> (Local DB / Network)

🧠 *Memory Aid:* “Repository = data traffic controller.”

---

### Q: What is the role of UseCases in Clean Architecture?
UseCases encapsulate **single units of business logic** and keep ViewModels lightweight.  
They make the **Domain layer** reusable and framework-independent.

🧠 *Memory Aid:* “UseCase = one job, done right.”

---

### Q: How does Dependency Injection support architecture?
DI frameworks like **Hilt** and **Dagger** automatically provide dependencies at runtime.  
They ensure separation of concerns and simplify testing.

Benefits:
- Decoupled components
- Easier mocking in tests
- Automatic lifecycle-scoped injection

🧠 *Memory Aid:* “DI = architecture’s silent helper.”

---

### Q: What are some best practices for app architecture design?
✅ Follow **Clean Architecture principles**  
✅ Keep **ViewModels UI-focused**, **UseCases logic-focused**  
✅ Use **Repository pattern** for data abstraction  
✅ Separate **network models** and **domain models**  
✅ Leverage **Hilt** for dependency management  
✅ Add **unit tests** at Domain level  
✅ Keep **UI reactive** with Flow/LiveData

🧠 *Memory Aid:* “Decouple, delegate, and test.”

---

### 🧩 Section Summary
- MVVM = recommended Jetpack architecture
- Clean Architecture = clear layer separation
- Dependency Inversion = code flexibility
- Repository = unified data access
- UseCases = single logic responsibility
- DI = testable, modular structure
- Flow: `UI (View, ViewModel) <-> Domain (UseCases) <-> Data (Repository, Local, Remote)`

---

✅ **Notes**
- GitHub-ready Markdown with inline arrows
- Consistent emoji memory aids
- Perfectly aligned with your `android-interview-prep` style
- Real-world architecture flow for diagrammatic understanding  
