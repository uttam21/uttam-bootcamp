# 🧪 Android Testing, Tools & Techniques Q&A

This document covers **Android testing fundamentals**, including unit testing, UI testing, mocking, automation tools, and best practices for maintaining reliable and scalable test suites in production-grade Android apps.

---

## 🧭 Table of Contents

### Section 14: Android Testing, Tools & Techniques
* [What are the types of testing in Android?](#q-what-are-the-types-of-testing-in-android)
* [What is Unit Testing and why is it important?](#q-what-is-unit-testing-and-why-is-it-important)
* [What is Instrumentation Testing?](#q-what-is-instrumentation-testing)
* [Explain the difference between Local Unit Tests and Instrumented Tests](#q-explain-the-difference-between-local-unit-tests-and-instrumented-tests)
* [What is Espresso and how is it used?](#q-what-is-espresso-and-how-is-it-used)
* [What is Robolectric and why is it useful?](#q-what-is-robolectric-and-why-is-it-useful)
* [Explain Mockito and its role in testing](#q-explain-mockito-and-its-role-in-testing)
* [Fake vs Mock vs Stub — what’s the difference?](#q-fake-vs-mock-vs-stub--whats-the-difference)
* [How do you test a ViewModel?](#q-how-do-you-test-a-viewmodel)
* [How do you test a Repository or UseCase?](#q-how-do-you-test-a-repository-or-usecase)
* [What are the common testing annotations in Android?](#q-what-are-the-common-testing-annotations-in-android)
* [Explain dependency injection for testing (Hilt/Dagger)](#q-explain-dependency-injection-for-testing-hiltdagger)
* [What is Test-Driven Development (TDD)?](#q-what-is-test-driven-development-tdd)
* [How do you integrate testing in CI/CD pipelines?](#q-how-do-you-integrate-testing-in-cicd-pipelines)
* [What is code coverage and how do you measure it?](#q-what-is-code-coverage-and-how-do-you-measure-it)
* [Best practices for Android testing](#q-best-practices-for-android-testing)

---

## Section 14: Android Testing, Tools & Techniques

---

### Q: What are the types of testing in Android?
Android testing ensures app stability, correctness, and performance.

**Main types:**
1. **Unit Testing:** verifies small code units (e.g., functions, ViewModels).
2. **Integration Testing:** validates interactions between components.
3. **UI / Instrumentation Testing:** checks real device behavior and user flows.
4. **End-to-End (E2E):** ensures entire app flows work correctly.
5. **Performance Testing:** measures speed, memory, and responsiveness.

🧠 **Memory Aid:** “Small to big — Unit → Integration → UI → E2E.”

---

### Q: What is Unit Testing and why is it important?
Unit testing validates individual components in isolation (no Android framework dependencies).  
Helps detect bugs early and improves refactor safety.

**Tools:**
- JUnit
- Mockito / MockK for mocking dependencies

🧠 **Memory Aid:** “Test small, fix early.”

---

### Q: What is Instrumentation Testing?
Instrumentation tests run on a **device or emulator** and interact with the Android framework.  
They test UI elements, lifecycle, and component integration.

**Frameworks:**
- Espresso
- UI Automator

🧠 **Memory Aid:** “Instrumentation = real device, real interaction.”

---

### Q: Explain the difference between Local Unit Tests and Instrumented Tests

| Type | Environment | Speed | Framework | Purpose |
|------|--------------|--------|------------|----------|
| Local Unit Test | JVM (no device) | Fast | JUnit, Mockito | Logic validation |
| Instrumented Test | Device/Emulator | Slow | Espresso | UI & Integration testing |

🧠 **Memory Aid:** “Local = logic; Instrumented = interaction.”

---

### Q: What is Espresso and how is it used?
Espresso is Android’s official UI testing framework.  
It synchronizes with the UI thread and simulates user actions such as clicks, scrolls, and typing.

**Core principles:**
- Automatic synchronization with UI thread
- Fluent API (`onView()`, `perform()`, `check()`)
- Works seamlessly with RecyclerViews, Fragments, and Compose testing

🧠 **Memory Aid:** “Espresso = express UI interactions smoothly.”

---

### Q: What is Robolectric and why is it useful?
Robolectric allows Android tests to run **on JVM** without an emulator.  
It simulates Android framework behavior, speeding up test cycles.

**Benefits:**
- No need for emulator/device
- Runs in CI environments easily
- Fast feedback for unit tests involving Android classes

🧠 **Memory Aid:** “Robolectric = Android emulator for your JVM.”

---

### Q: Explain Mockito and its role in testing
Mockito is a mocking framework that creates fake versions of dependencies.  
You can define how mocks behave and verify method calls.

**Used for:**
- Unit testing ViewModels and UseCases
- Mocking network calls, repositories, or DAOs

🧠 **Memory Aid:** “Mockito = fake collaborator for real testing.”

---

### Q: Fake vs Mock vs Stub — what’s the difference?

| Type | Description | Use Case |
|------|--------------|----------|
| **Fake** | Simplified working implementation | In-memory DB |
| **Mock** | Object with expectations for behavior | Verify interactions |
| **Stub** | Returns pre-defined data | Testing fixed responses |

🧠 **Memory Aid:** “Fake = simple, Mock = check, Stub = static.”

---

### Q: How do you test a ViewModel?
- Test LiveData or StateFlow emissions using `observeForever()` or `runTest`.
- Mock repositories or use fake data sources.
- Verify state transitions for given inputs.

🧠 **Memory Aid:** “Trigger intent → verify state → assert result.”

---

### Q: How do you test a Repository or UseCase?
- Use in-memory database (e.g., Room’s `inMemoryDatabaseBuilder`).
- Mock network calls using `MockWebServer`.
- Validate data flow from data source → repository → domain.

🧠 **Memory Aid:** “Fake network + in-memory DB = perfect test bed.”

---

### Q: What are the common testing annotations in Android?

| Annotation | Purpose |
|-------------|----------|
| `@Test` | Marks a test method |
| `@Before` / `@After` | Setup or teardown methods |
| `@RunWith(AndroidJUnit4::class)` | Defines test runner |
| `@Mock` | Creates mock object in Mockito |
| `@Rule` | Defines test rules (like `InstantTaskExecutorRule`) |

🧠 **Memory Aid:** “Before = prep, After = clean.”

---

### Q: Explain dependency injection for testing (Hilt/Dagger)
Use Hilt test components (`@HiltAndroidTest`) or Dagger test modules to inject mock dependencies.  
You can override real implementations with fakes or mocks easily.

**Hilt test tips:**
- Annotate test class with `@HiltAndroidTest`.
- Use `@BindValue` to inject test dependencies.
- Launch activity via `HiltAndroidRule`.

🧠 **Memory Aid:** “Mock in, real out — Hilt makes it easy.”

---

### Q: What is Test-Driven Development (TDD)?
TDD follows the **Red → Green → Refactor** cycle:
1. Write a failing test (Red).
2. Write code to make it pass (Green).
3. Refactor for clarity and efficiency.

**Benefits:**
- Improves design and confidence
- Prevents regressions

🧠 **Memory Aid:** “Fail first, fix next, polish last.”

---

### Q: How do you integrate testing in CI/CD pipelines?
Use Gradle commands for automation such as  
`./gradlew testDebugUnitTest` or `./gradlew connectedAndroidTest`.  
Integrate these into CI/CD tools like GitHub Actions, Jenkins, or Bitrise to run automatically on pull requests.

🧠 **Memory Aid:** “CI = Continuous Integration; Tests = Continuous Confidence.”

---

### Q: What is code coverage and how do you measure it?
Code coverage shows how much of your code is executed by tests.  
You can measure it using **JaCoCo** or Gradle plugins.

Common Gradle task: `gradlew testDebugUnitTestCoverage`

**Common metrics:**
- Line coverage
- Branch coverage
- Method coverage

🧠 **Memory Aid:** “More green lines = more tested code.”

---

### Q: Best practices for Android testing
✅ Test all layers — ViewModel, Repository, UseCase.  
✅ Keep tests fast and deterministic.  
✅ Use mocks or fakes — no real APIs.  
✅ Automate testing in CI/CD.  
✅ Measure coverage but focus on critical paths.  
✅ Separate test folders: `/test` (unit) vs `/androidTest` (UI).

🧠 **Memory Aid:** “Fast, isolated, automated — the testing mantra.”

---

### 🧩 Section Summary
- Unit Tests = logic
- Instrumentation Tests = UI
- Espresso = real user simulation
- Mockito = dependency mocking
- Robolectric = framework on JVM
- CI/CD = automated confidence

---
