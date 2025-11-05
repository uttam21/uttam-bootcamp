# Advanced Android Q&A

This document dives deep into **advanced Android internals**, covering performance optimization, threading, services, custom components, and real-world debugging concepts — crafted for senior-level Android interviews.

---

## Table of Contents

### Section 1: Multithreading & Performance
* [What is the main thread in Android and why is it important?](#q-what-is-the-main-thread-in-android-and-why-is-it-important)
* [What causes ANR (Application Not Responding)?](#q-what-causes-anr-application-not-responding)
* [How can ANR be prevented?](#q-how-can-anr-be-prevented)
* [Difference between Thread, Handler, and AsyncTask](#q-difference-between-thread-handler-and-asynctask)
* [How does Looper and MessageQueue work?](#q-how-does-looper-and-messagequeue-work)
* [What is HandlerThread?](#q-what-is-handlerthread)
* [How to perform parallel API calls efficiently?](#q-how-to-perform-parallel-api-calls-efficiently)
* [What are ThreadPools and their advantages?](#q-what-are-threadpools-and-their-advantages)

### Section 2: Memory & Optimization
* [What is Garbage Collection in Android?](#q-what-is-garbage-collection-in-android)
* [What causes Memory Leaks and how to prevent them?](#q-what-causes-memory-leaks-and-how-to-prevent-them)
* [Difference between Memory Leak and OutOfMemoryError](#q-difference-between-memory-leak-and-outofmemoryerror)
* [How to detect memory leaks in Android apps?](#q-how-to-detect-memory-leaks-in-android-apps)
* [What tools are used for performance analysis?](#q-what-tools-are-used-for-performance-analysis)

### Section 3: Custom Components & Drawing
* [How to create a Custom View?](#q-how-to-create-a-custom-view)
* [What is the difference between Canvas and SurfaceView?](#q-what-is-the-difference-between-canvas-and-surfaceview)
* [What are View drawing phases?](#q-what-are-view-drawing-phases)
* [What is overdraw and how to reduce it?](#q-what-is-overdraw-and-how-to-reduce-it)

### Section 4: Background Services
* [Explain the Service lifecycle](#q-explain-the-service-lifecycle)
* [Difference between Service, IntentService, and ForegroundService](#q-difference-between-service-intentservice-and-foregroundservice)
* [When to use JobScheduler vs WorkManager?](#q-when-to-use-jobscheduler-vs-workmanager)
* [How to ensure reliable background work in Android?](#q-how-to-ensure-reliable-background-work-in-android)

---

## Section 1: Multithreading & Performance

---

### Q: What is the main thread in Android and why is it important?
The **main thread (UI thread)** handles all user interactions and drawing operations.  
Blocking it causes app lags or ANR.

🧠 *Memory Aid:* “Main thread = sacred, never block it.”

---

### Q: What causes ANR (Application Not Responding)?
Occurs when the **UI thread** is blocked for too long:
- Network or database operations on main thread
- Heavy computation
- Infinite loops or deadlocks

🧠 *Memory Aid:* “Block UI for 5 seconds → Android loses patience.”

---

### Q: How can ANR be prevented?
✅ Move heavy tasks to background threads (Coroutines/WorkManager)  
✅ Keep layouts lightweight  
✅ Optimize I/O and computation  
✅ Use `StrictMode` to detect blocking operations

🧠 *Memory Aid:* “Offload work, keep UI breathing.”

---

### Q: Difference between Thread, Handler, and AsyncTask
| Concept | Purpose | Lifecycle |
|----------|----------|-----------|
| Thread | Executes parallel tasks | Manual management |
| Handler | Posts messages to a thread’s queue | Controlled via Looper |
| AsyncTask | Simplified background task (deprecated) | Tied to Activity lifecycle |

🧠 *Memory Aid:* “Thread = worker, Handler = messenger, AsyncTask = retired helper.”

---

### Q: How does Looper and MessageQueue work?
Each thread can have one **Looper** managing a **MessageQueue**.  
The main thread’s Looper continuously polls and processes messages posted by Handlers.

🧠 *Memory Aid:* “Looper loops, Queue feeds, Handler talks.”

---

### Q: What is HandlerThread?
A **background thread with its own Looper**, used for message-based work without blocking UI.

🧠 *Memory Aid:* “HandlerThread = Looper-powered background worker.”

---

### Q: How to perform parallel API calls efficiently?
Use Coroutines with:
- `async` + `awaitAll()` for parallel execution
- `Dispatchers.IO` for network work

🧠 *Memory Aid:* “Parallel = async in action.”

---

### Q: What are ThreadPools and their advantages?
ThreadPools reuse existing threads to execute tasks concurrently.

Advantages:
- Prevents thread explosion
- Improves resource utilization
- Reduces context switching overhead

🧠 *Memory Aid:* “ThreadPool = team of reusable workers.”

---

## Section 2: Memory & Optimization

---

### Q: What is Garbage Collection in Android?
Automatic process that removes unused objects from memory.  
Triggers during high memory pressure, potentially causing UI hiccups.

🧠 *Memory Aid:* “GC cleans, but don’t make it sweep too often.”

---

### Q: What causes Memory Leaks and how to prevent them?
Leaks occur when objects hold references longer than needed.

Common causes:
- Static references to Context or Views
- Anonymous inner classes
- Unregistered receivers or callbacks

Prevention:
✅ Use WeakReferences  
✅ Unregister listeners in `onDestroy()`  
✅ Use LeakCanary

🧠 *Memory Aid:* “Leaks grow quietly, fix them early.”

---

### Q: Difference between Memory Leak and OutOfMemoryError
| Issue | Description |
|--------|-------------|
| Memory Leak | Unused objects not released |
| OutOfMemoryError | App runs out of heap space |

🧠 *Memory Aid:* “Leak fills the bucket, OOM spills it.”

---

### Q: How to detect memory leaks in Android apps?
Use:
- **LeakCanary** for runtime leak detection
- **Android Profiler** for heap analysis
- **ADB shell dumpsys meminfo** for memory stats

🧠 *Memory Aid:* “Profiler shows usage; LeakCanary shows culprit.”

---

### Q: What tools are used for performance analysis?
- Android Studio Profiler
- Systrace
- CPU Profiler
- GPU Rendering Monitor
- StrictMode

🧠 *Memory Aid:* “Profile before you optimize.”

---

## Section 3: Custom Components & Drawing

---

### Q: How to create a Custom View?
Extend `View` or `ViewGroup` and override methods like `onDraw()` and `onMeasure()`.  
Used for unique UI behavior.

🧠 *Memory Aid:* “Custom View = your canvas, your rules.”

---

### Q: What is the difference between Canvas and SurfaceView?
| Component | Purpose |
|------------|----------|
| Canvas | UI thread drawing | 
| SurfaceView | Separate thread drawing (better for real-time) |

🧠 *Memory Aid:* “Canvas = main thread art; SurfaceView = background painter.”

---

### Q: What are View drawing phases?
1. **Measure** → determines size
2. **Layout** → positions children
3. **Draw** → renders to screen

🧠 *Memory Aid:* “Measure, layout, draw — the UI’s heartbeat.”

---

### Q: What is overdraw and how to reduce it?
Overdraw happens when the same pixel is drawn multiple times per frame.

Fix by:
✅ Removing unnecessary backgrounds  
✅ Flattening nested layouts  
✅ Using `ConstraintLayout`

🧠 *Memory Aid:* “Less paint, faster canvas.”

---

## Section 4: Background Services

---

### Q: Explain the Service lifecycle
Flow:
onCreate() → onStartCommand() → (Running) → onDestroy()

🧠 *Memory Aid:* “Create → Start → Work → Destroy.”

---

### Q: Difference between Service, IntentService, and ForegroundService
| Type | Thread | Auto-stop | Use case |
|------|---------|-----------|-----------|
| Service | Main thread | No | Ongoing background tasks |
| IntentService | Worker thread | Yes | Short async work |
| ForegroundService | Main thread | No | Visible tasks (music, upload) |

🧠 *Memory Aid:* “IntentService = auto worker; Foreground = protected worker.”

---

### Q: When to use JobScheduler vs WorkManager?
| Feature | JobScheduler | WorkManager |
|----------|---------------|--------------|
| API Level | 21+ | All (backward compatible) |
| Reliability | System-managed | Guaranteed execution |
| Use case | System tasks | App-specific background tasks |

🧠 *Memory Aid:* “WorkManager = JobScheduler 2.0.”

---

### Q: How to ensure reliable background work in Android?
✅ Use **WorkManager** for deferrable tasks  
✅ Use **ForegroundService** for active tasks  
✅ Respect battery and network constraints  
✅ Chain tasks for order and reliability

🧠 *Memory Aid:* “Work smart, not endless — background wisely.”

---

### 🧩 Section Summary
- UI thread = never block
- Looper + Handler = message-driven threading
- ThreadPool = efficient concurrency
- GC cleans but leaks kill
- Custom Views = flexible UI
- Services = background engines
- WorkManager = modern background scheduler

---

✅ **Notes**
- Fully `.md` formatted (GitHub-ready)
- Clean tables, emoji aids, lifecycle clarity
- Consistent with encyclopedia visual flow  
