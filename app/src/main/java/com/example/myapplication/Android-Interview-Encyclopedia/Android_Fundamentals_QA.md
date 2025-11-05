# 🟢 Android Fundamentals Q&A

This document provides conceptual and practical Android questions with concise answers and examples for interview preparation.

---

## 🧭 Table of Contents

### 🧩 Section 1: Android Base
* [Why does an Android App lag?](#q-why-does-an-android-app-lag)
* [What is Context?](#q-what-is-context)
* [What are the Android Application Components?](#q-what-are-the-android-application-components)
* [What is the Project Structure of an Android App?](#q-what-is-the-project-structure-of-an-android-app)
* [What is AndroidManifest.xml?](#q-what-is-androidmanifestxml)
* [What is the Application Class?](#q-what-is-the-application-class)

### ⚙️ Section 2: Activity and Fragment
* [Why should you use only the default constructor to create a Fragment?](#q-why-should-you-use-only-the-default-constructor-to-create-a-fragment)
* [What is an Activity and its lifecycle?](#q-what-is-an-activity-and-its-lifecycle)
* [What’s the difference between onCreate() and onStart()?](#q-whats-the-difference-between-oncreate-and-onstart)
* [When is only onDestroy() called without onPause() and onStop()?](#q-when-is-only-ondestroy-called-without-onpause-and-onstop)
* [Why do we need to call setContentView() in onCreate()?](#q-why-do-we-need-to-call-setcontentview-in-oncreate)
* [What is onSaveInstanceState() and onRestoreInstanceState()?](#q-what-is-onsaveinstancestate-and-onrestoreinstancestate)
* [What is a Fragment and its lifecycle?](#q-what-is-a-fragment-and-its-lifecycle)
* [What is a Bundle in Android?](#q-what-is-a-bundle-in-android)
* [What are Launch Modes in Android?](#q-what-are-launch-modes-in-android)
* [FragmentPagerAdapter vs FragmentStatePagerAdapter](#q-fragmentpageradapter-vs-fragmentstatepageradapter)
* [Difference between adding and replacing fragments in back stack](#q-difference-between-adding-and-replacing-fragments-in-back-stack)
* [How to communicate between two Fragments?](#q-how-to-communicate-between-two-fragments)
* [What is a retained Fragment?](#q-what-is-a-retained-fragment)
* [What is the purpose of addToBackStack()?](#q-what-is-the-purpose-of-addtobackstack)

### 🧱 Section 3: Views and ViewGroups
* [What is a View in Android?](#q-what-is-a-view-in-android)
* [Difference between View.GONE and View.INVISIBLE](#q-difference-between-viewgone-and-viewinvisible)
* [What are ViewGroups and how are they different from Views?](#q-what-are-viewgroups-and-how-are-they-different-from-views)
* [What is a Canvas?](#q-what-is-a-canvas)
* [What is a SurfaceView?](#q-what-is-a-surfaceview)
* [RelativeLayout vs LinearLayout](#q-relativelayout-vs-linearlayout)
* [ConstraintLayout optimization](#q-constraintlayout-optimization)
* [What is the view tree and how to optimize its depth?](#q-what-is-the-view-tree-and-how-to-optimize-its-depth)
* [Can you create a custom View?](#q-can-you-create-a-custom-view)

### 🧾 Section 4: Displaying Lists of Content
* [What is the difference between ListView and RecyclerView?](#q-what-is-the-difference-between-listview-and-recyclerview)
* [How does the RecyclerView work?](#q-how-does-the-recyclerview-work)
* [RecyclerView optimization and scrolling performance](#q-recyclerview-optimization-and-scrolling-performance)
* [Optimizing Nested RecyclerView](#q-optimizing-nested-recyclerview)
* [What are the components of a RecyclerView?](#q-what-are-the-components-of-a-recyclerview)
* [What is a LayoutManager in RecyclerView?](#q-what-is-a-layoutmanager-in-recyclerview)
* [How do you handle multiple view types in a single RecyclerView?](#q-how-do-you-handle-multiple-view-types-in-a-single-recyclerview)
* [What is DiffUtil and how does it improve RecyclerView performance?](#q-what-is-diffutil-and-how-does-it-improve-recyclerview-performance)
* [What is SnapHelper?](#q-what-is-snaphelper)

### 💬 Section 5: Dialogs and Toasts
* [What is a Dialog in Android?](#q-what-is-a-dialog-in-android)
* [What is a Toast in Android?](#q-what-is-a-toast-in-android)
* [What is the difference between Dialog and DialogFragment?](#q-what-is-the-difference-between-dialog-and-dialogfragment)
* [When should you use DialogFragment instead of Dialog?](#q-when-should-you-use-dialogfragment-instead-of-dialog)
* [Best practices for Dialog and Toast usage](#q-best-practices-for-dialog-and-toast-usage)

### 📡 Section 6: Intents and Broadcasting
* [What is an Intent?](#q-what-is-an-intent)
* [What is an Implicit Intent?](#q-what-is-an-implicit-intent)
* [What is an Explicit Intent?](#q-what-is-an-explicit-intent)
* [What is a BroadcastReceiver?](#q-what-is-a-broadcastreceiver)
* [How do broadcasts and intents work to pass messages?](#q-how-do-broadcasts-and-intents-work-together)
* [What is a PendingIntent?](#q-what-is-a-pendingintent)
* [What are the different types of Broadcasts?](#q-what-are-the-different-types-of-broadcasts)
* [Best practices for Broadcasts](#q-best-practices-for-broadcasts)

### 🧠 Section 7: Services and Background Work
* [What is a Service in Android?](#q-what-is-a-service-in-android)
* [Explain the Android Service Lifecycle](#q-explain-the-android-service-lifecycle)
* [On which thread does a Service run?](#q-on-which-thread-does-a-service-run)
* [Service vs IntentService](#q-service-vs-intentservice)
* [What is a Foreground Service?](#q-what-is-a-foreground-service)
* [What is a JobScheduler?](#q-what-is-a-jobscheduler)
* [How does WorkManager guarantee task execution?](#q-how-does-workmanager-guarantee-task-execution)
* [Best practices for background work](#q-best-practices-for-background-work)

### 🔗 Section 8: Inter-process Communication (IPC)
* [How can two distinct Android apps interact?](#q-how-can-two-distinct-android-apps-interact)
* [Is it possible to run an Android app in multiple processes?](#q-is-it-possible-to-run-an-android-app-in-multiple-processes)
* [What is AIDL and how does it work?](#q-what-is-aidl-and-how-does-it-work)
* [What are the steps in creating a bounded service through AIDL?](#q-steps-in-creating-a-bounded-service-through-aidl)
* [What can you use for background processing in Android?](#q-what-can-you-use-for-background-processing)
* [What is a ContentProvider and what is it used for?](#q-what-is-a-contentprovider-and-what-is-it-used-for)
* [Best practices for inter-process communication](#q-best-practices-for-ipc)

### ⏱️ Section 9: Long-running Operations
* [How to run parallel tasks and get callback when all complete?](#q-how-to-run-parallel-tasks-and-get-callback-when-all-complete)
* [What is ANR and how to prevent it?](#q-what-is-anr-and-how-to-prevent-it)
* [What are advantages of ThreadPool?](#q-what-are-advantages-of-threadpool)
* [Daemon Threads vs User Threads](#q-daemon-threads-vs-user-threads)
* [Explain Looper, Handler, HandlerThread](#q-explain-looper-handler-handlerthread)
* [What is Garbage Collection?](#q-what-is-garbage-collection)
* [Memory Leak vs OutOfMemory (OOM) Error](#q-memory-leak-vs-outofmemory-oom)
* [Runnable vs Thread](#q-runnable-vs-thread)
* [Best practices for long-running work](#q-best-practices-for-long-running-work)

### 🎨 Section 10: Look and Feel & Performance Optimization
* [What is a Spannable?](#q-what-is-a-spannable)
* [What is a SpannableString?](#q-what-is-a-spannablestring)
* [Best practices for using text](#q-best-practices-for-using-text)
* [How to implement Dark Mode?](#q-how-to-implement-dark-mode)
* [Improve Android app performance](#q-improve-android-app-performance)
* [What is onTrimMemory()?](#q-what-is-ontrimmemory)
* [Identify and fix OOM](#q-identify-and-fix-oom)
* [Find and fix memory leaks](#q-how-to-find-and-fix-memory-leaks)
* [Reduce battery usage](#q-how-to-reduce-battery-usage)
* [What are Doze and App Standby modes?](#q-what-are-doze-and-app-standby-modes)
* [What is Overdraw?](#q-what-is-overdraw)
* [Support different screen sizes](#q-support-different-screen-sizes)
* [Permission protection levels](#q-permission-protection-levels)

---

## 🧩 Section 1: Android Base

### Q: Why does an Android App lag?
Lag happens when the **UI thread** is blocked by heavy work (network, DB, decoding).
Do heavy work on background threads (Coroutines, WorkManager).  
🧠 **Memory Aid:** “UI = sacred — do no heavy work there.”

---

### Q: What is Context?
Provides access to resources and system services.  
| Type | Scope | Used for |
|------|-------|----------|
| **Application** | Whole app | Long-lived, singletons |
| **Activity** | One screen | UI inflation, views |

🧠 **Memory Aid:** “Context = gateway to the Android system.”

---

### Q: What are the Android Application Components?
| Component | Purpose |
|------------|----------|
| **Activity** | Screen with UI |
| **Service** | Background tasks |
| **BroadcastReceiver** | Responds to broadcasts |
| **ContentProvider** | Shares structured data |

🧠 **Memory Aid:** “Four pillars: Activity, Service, Receiver, Provider.”

---

### Q: What is the Project Structure of an Android App?
| Folder | Purpose |
|--------|----------|
| manifests/ | Contains `AndroidManifest.xml` |
| java/ | Kotlin/Java code |
| res/ | Layouts, drawables, strings |
| assets/ | Raw bundled files |
| gradle/ | Build configuration |

🧠 **Memory Aid:** “Manifest → Java → Res → Assets → Gradle.”

---

### Q: What is AndroidManifest.xml?
Defines the app’s components, permissions, and entry points.  
🧠 **Memory Aid:** “Manifest = app’s declaration sheet.”

---

### Q: What is the Application Class?
Global initializer, first to start when the process begins.  
🧠 **Memory Aid:** “Application = first to wake, last to sleep.”

---

## ⚙️ Section 2: Activity and Fragment

### Q: Why should you use only the default constructor to create a Fragment?
Because the system re-creates fragments automatically after configuration changes.  
🧠 **Memory Aid:** “System rebuilds only what it knows.”

---

### Q: What is an Activity and its lifecycle?
Activity = single interactive screen.  
Lifecycle → `onCreate → onStart → onResume → onPause → onStop → onDestroy`  
🧠 **Memory Aid:** “Created → Started → Resumed → Paused → Stopped → Destroyed.”

---

### Q: What’s the difference between onCreate() and onStart()?
`onCreate()` runs once; `onStart()` runs every time it becomes visible.  
🧠 **Memory Aid:** “onCreate = born; onStart = visible again.”

---

### Q: When is only onDestroy() called without onPause() and onStop()?
If destroyed before resuming (e.g., finish() in onCreate).  
🧠 **Memory Aid:** “Die before wake → only onDestroy().”

---

### Q: Why call setContentView() in onCreate()?
Inflates XML into actual UI hierarchy.  
🧠 **Memory Aid:** “onCreate = inflate the face (UI).”

---

### Q: What is onSaveInstanceState() / onRestoreInstanceState()?
Saves transient UI state (scroll, text) across recreation.  
🧠 **Memory Aid:** “Save before sleep, restore when wake.”

---

### Q: What is a Fragment and its lifecycle?
Modular UI unit inside an Activity.  
Lifecycle: `onAttach → onCreate → onCreateView → onViewCreated → onStart → onResume → onPause → onStop → onDestroyView → onDestroy → onDetach`.  
🧠 **Memory Aid:** “View created → used → destroyed — mirrors Activity.”

---

### Q: What is a Bundle in Android?
Key-value map for passing data between components.  
🧠 **Memory Aid:** “Bundle = delivery bag for data.”

---

### Q: What are Launch Modes in Android?
| Mode | Behavior |
|------|-----------|
| standard | Always new instance |
| singleTop | Reuses if already top |
| singleTask | One instance per task |
| singleInstance | Separate task |

🧠 **Memory Aid:** “standard = clone; singleTop = reuse; singleTask = one per task; singleInstance = isolate.”

---

### Q: FragmentPagerAdapter vs FragmentStatePagerAdapter
`PagerAdapter` keeps fragments alive; `StatePagerAdapter` saves & destroys off-screen.  
🧠 **Memory Aid:** “Pager = keep; StatePager = save.”

---

### Q: Difference between add() and replace()
`add()` stacks fragments; `replace()` swaps.  
🧠 **Memory Aid:** “Add = layer; Replace = swap.”

---

### Q: How to communicate between two Fragments?
Shared `ViewModel` via Activity scope or `setFragmentResult()`.  
🧠 **Memory Aid:** “Shared ViewModel = shared talk.”

---

### Q: What is a retained Fragment?
Old way to survive rotation using `setRetainInstance(true)` (now deprecated).  
🧠 **Memory Aid:** “Retain = survive rotation → use ViewModel.”

---

### Q: What is addToBackStack()?
Adds transaction to back stack → back button reverses.  
🧠 **Memory Aid:** “BackStack = undo stack for fragments.”

---

## 🧱 Section 3: Views and ViewGroups

### Q: What is a View in Android?
Smallest UI building block — handles drawing & input.  
🧠 **Memory Aid:** “View = visible widget.”

---

### Q: Difference between View.GONE and View.INVISIBLE
`GONE` removes layout space; `INVISIBLE` keeps it.  
🧠 **Memory Aid:** “Gone = out; Invisible = ghost.”

---

### Q: What are ViewGroups?
Containers for other Views.  
🧠 **Memory Aid:** “ViewGroup = parent; View = child.”

---

### Q: What is a Canvas?
Low-level drawing API for custom graphics.  
🧠 **Memory Aid:** “Canvas = digital board.”

---

### Q: What is a SurfaceView?
Dedicated surface for background-thread drawing (games, video).  
🧠 **Memory Aid:** “SurfaceView = async drawing surface.”

---

### Q: RelativeLayout vs LinearLayout
Linear → one direction; Relative → position by relation.  
🧠 **Memory Aid:** “Linear = straight; Relative = flexible.”

---

### Q: ConstraintLayout optimization
Flat, single-level layout → better performance.  
🧠 **Memory Aid:** “Constraint = flat & fast.”

---

### Q: What is the view tree and how to optimize?
Entire hierarchy of Views.  
Reduce depth → faster measure/draw.  
🧠 **Memory Aid:** “Shallow tree = fast UI.”

---

### Q: Can you create a custom View?
Yes, for reusable or special UIs.  
🧠 **Memory Aid:** “Custom = tailor-made widget.”

---

## 🧾 Section 4: Displaying Lists of Content

### Q: Difference between ListView and RecyclerView
RecyclerView is modern, efficient, supports animations & multiple view types.  
🧠 **Memory Aid:** “RecyclerView = ListView on steroids.”

---

### Q: How does RecyclerView work?
Data → Adapter → ViewHolder → LayoutManager → Display  
🧠 **Memory Aid:** “Adapter feeds, Manager arranges.”

---

### Q: RecyclerView optimization
Use `setHasFixedSize(true)`, `DiffUtil`, cache images, avoid deep nesting.  
🧠 **Memory Aid:** “Less layout work = more FPS.”

---

### Q: Nested RecyclerView optimization
Share `RecycledViewPool()`, prefer horizontal child lists.  
🧠 **Memory Aid:** “One pool = smoother scroll.”

---

### Q: Components of RecyclerView
Adapter, ViewHolder, LayoutManager, ItemAnimator, ItemDecoration.  
🧠 **Memory Aid:** “Five gears — Adapter, Holder, Manager, Animator, Decorator.”

---

### Q: DiffUtil
Smart diff between old/new lists for efficient updates.  
🧠 **Memory Aid:** “DiffUtil = no full refresh.”

---

### Q: SnapHelper
Aligns item after scroll stop → used in carousels.  
🧠 **Memory Aid:** “SnapHelper = magnetic scroll.”

---

## 💬 Section 5: Dialogs and Toasts

### Q: What is a Dialog?
Modal pop-up for info or input.  
🧠 **Memory Aid:** “Dialog = focused interruption.”

---

### Q: What is a Toast?
Non-blocking quick feedback.  
🧠 **Memory Aid:** “Toast = short message, no block.”

---

### Q: Dialog vs DialogFragment
`Dialog` tied to Activity lifecycle; `DialogFragment` = lifecycle-safe wrapper.  
🧠 **Memory Aid:** “DialogFragment = safe Dialog.”

---

### Q: When to use DialogFragment?
When handling rotation, lifecycle, or ViewModel interactions.  
🧠 **Memory Aid:** “Modern apps → DialogFragment.”

---

### Q: Best practices
Use DialogFragment, keep Toasts short, prefer Snackbar for actions.  
🧠 **Memory Aid:** “Dialog = attention; Toast = notice.”

---

## 📡 Section 6: Intents and Broadcasting

### Q: What is an Intent?
Intent = a messaging object used to request an action from another app component.  
🧠 **Memory Aid:** “Intent = purpose messenger.”

---

### Q: What is an Implicit Intent?
Used to perform actions **without specifying** the exact component.  
Example → share text, open web link.  
🧠 **Memory Aid:** “Implicit = system decides who.”

---

### Q: What is an Explicit Intent?
Specifies **exact target component** (Activity/Service).  
Example → `Intent(this, DetailActivity::class.java)`  
🧠 **Memory Aid:** “Explicit = tell exactly who to call.”

---

### Q: What is a BroadcastReceiver?
A component that listens for system-wide or app-wide broadcast messages.  
🧠 **Memory Aid:** “Receiver = listener for global events.”

---

### Q: How do broadcasts and intents work together?
Broadcast sends `Intent`; receivers catch and act on it.  
🧠 **Memory Aid:** “Intent = signal; Receiver = antenna.”

---

### Q: What is a PendingIntent?
A token that allows another app (e.g., NotificationManager) to perform an action on your app’s behalf later.  
🧠 **Memory Aid:** “PendingIntent = permission to act later.”

---

### Q: What are the different types of Broadcasts?
| Type | Description |
|------|--------------|
| **Normal** | Asynchronous, unordered |
| **Ordered** | Delivered in priority order |
| **Sticky** | Remains for future receivers |
| **Local** | App-internal, secure |

🧠 **Memory Aid:** “Normal = fire & forget; Ordered = queue; Sticky = persistent.”

---

### Q: Best practices for Broadcasts
- Use **LocalBroadcastManager** for internal broadcasts.
- Unregister dynamic receivers in `onPause()` or `onStop()`.
- Prefer modern APIs (WorkManager, LiveData) for async events.  
  🧠 **Memory Aid:** “Broadcast less — observe more.”

---

## 🧠 Section 7: Services and Background Work

### Q: What is a Service in Android?
A Service performs long-running operations **without UI**.  
🧠 **Memory Aid:** “Service = background worker.”

---

### Q: Explain the Android Service Lifecycle
`onCreate → onStartCommand → (running) → onDestroy`  
🧠 **Memory Aid:** “Start → Work → Stop.”

---

### Q: On which thread does a Service run?
Main (UI) thread by default — move work to background thread or coroutine.  
🧠 **Memory Aid:** “Service ≠ thread.”

---

### Q: Service vs IntentService
| Feature | Service | IntentService |
|----------|----------|---------------|
| Thread | Main | Background |
| Multiple requests | Manual | Queued |
| Stops itself | ❌ | ✅ |

🧠 **Memory Aid:** “IntentService = auto-managed worker.”

---

### Q: What is a Foreground Service?
Foreground Service runs with a **persistent notification** and higher priority.  
🧠 **Memory Aid:** “Visible = protected from kill.”

---

### Q: What is a JobScheduler?
Schedules deferred, battery-optimized background jobs.  
🧠 **Memory Aid:** “Scheduler = smart background manager.”

---

### Q: How does WorkManager guarantee execution?
Uses combination of **JobScheduler**, **AlarmManager**, and **ForegroundService** internally.  
🧠 **Memory Aid:** “WorkManager = guaranteed doer.”

---

### Q: Best practices for background work
✅ Use WorkManager for reliable jobs.  
✅ Use coroutines over threads.  
✅ Respect Doze & battery limits.  
🧠 **Memory Aid:** “Background = respectful, reliable.”

---

## 🔗 Section 8: Inter-process Communication (IPC)

### Q: How can two distinct Android apps interact?
Through **Intents, ContentProviders, AIDL, or Binder**.  
🧠 **Memory Aid:** “Intent for light, AIDL for complex talk.”

---

### Q: Is it possible to run an Android app in multiple processes?
Yes — add `android:process` in manifest.  
🧠 **Memory Aid:** “Multiple processes = separate memory.”

---

### Q: What is AIDL and how does it work?
Android Interface Definition Language — allows method calls across processes via Binder.  
🧠 **Memory Aid:** “AIDL = contract for remote procedure call.”

---

### Q: Steps in creating a bounded service through AIDL
1. Define `.aidl` interface
2. Implement interface in Service
3. Bind from client using `ServiceConnection`  
   🧠 **Memory Aid:** “Define → Implement → Bind.”

---

### Q: What can you use for background processing?
- Coroutines / WorkManager (modern)
- JobScheduler (deferred)
- ForegroundService (continuous)  
  🧠 **Memory Aid:** “Choose by lifespan and reliability.”

---

### Q: What is a ContentProvider and what is it used for?
Manages shared structured data access between apps (e.g., Contacts, MediaStore).  
🧠 **Memory Aid:** “Provider = shared database bridge.”

---

### Q: Best practices for IPC
- Keep AIDL minimal and version-safe
- Use ContentProvider only when data shared
- Use Messenger or Broadcast for simple IPC  
  🧠 **Memory Aid:** “IPC = simple unless shared process needed.”

---

## ⏱️ Section 9: Long-running Operations

### Q: How to run parallel tasks and get callback when all complete?
Use **coroutines** with `async/await` or `CompletableFuture.allOf()`.  
🧠 **Memory Aid:** “Async + Await = teamwork.”

---

### Q: What is ANR and how to prevent it?
**ANR (Application Not Responding)** occurs when main thread is blocked >5s.  
🧠 **Memory Aid:** “Block UI = trigger ANR.”

---

### Q: What are advantages of ThreadPool?
- Reuses threads
- Reduces creation cost
- Manages concurrency  
  🧠 **Memory Aid:** “Pool = reuse, not recreate.”

---

### Q: Daemon Threads vs User Threads
| Type | Description |
|------|--------------|
| **User Thread** | Keeps JVM alive |
| **Daemon Thread** | Dies when app dies |

🧠 **Memory Aid:** “Daemon = background ghost.”

---

### Q: Explain Looper, Handler, HandlerThread
- **Looper**: keeps thread alive
- **Handler**: posts messages to Looper queue
- **HandlerThread**: background thread with Looper  
  🧠 **Memory Aid:** “Looper waits, Handler talks.”

---

### Q: What is Garbage Collection?
Automatic memory cleanup by Android runtime.  
🧠 **Memory Aid:** “GC = memory janitor.”

---

### Q: Memory Leak vs OutOfMemory (OOM)
| Type | Description |
|------|--------------|
| **Leak** | Memory held unintentionally |
| **OOM** | App requests more than available |

🧠 **Memory Aid:** “Leak = slow poison; OOM = sudden crash.”

---

### Q: Runnable vs Thread
Runnable defines work; Thread runs it.  
🧠 **Memory Aid:** “Runnable = task; Thread = executor.”

---

### Q: Best practices for long-running work
- Offload from main thread
- Use WorkManager / CoroutineScopes
- Monitor with ANR Watchdog  
  🧠 **Memory Aid:** “Async everything heavy.”

---

## 🎨 Section 10: Look and Feel & Performance Optimization

### Q: What is a Spannable?
A `Spannable` lets you style parts of text (bold, color, link).  
🧠 **Memory Aid:** “Spannable = partial style power.”

---

### Q: What is a SpannableString?
Implementation of `Spannable` that supports inline formatting.  
🧠 **Memory Aid:** “SpannableString = decorated text.”

---

### Q: Best practices for using text
- Use `TextAppearance` or `style.xml`
- Avoid hardcoded strings
- Use `string.xml` for localization  
  🧠 **Memory Aid:** “Text = stylized and centralized.”

---

### Q: How to implement Dark Mode?
Use themes (`values-night`), dynamic color via `Material3`, and observe system UI mode.  
🧠 **Memory Aid:** “Night mode = dual palette.”

---

### Q: Improve Android app performance
✅ Reduce overdraw  
✅ Use DiffUtil  
✅ Cache data  
✅ Optimize layout hierarchy  
✅ Profile with Android Studio tools  
🧠 **Memory Aid:** “Measure, then optimize.”

---

### Q: What is onTrimMemory()?
Callback to handle memory pressure — release caches when low memory.  
🧠 **Memory Aid:** “Trim = lighten load.”

---

### Q: Identify and fix OOM
- Compress bitmaps
- Use Glide/Picasso
- Monitor with Profiler  
  🧠 **Memory Aid:** “Bitmap = memory monster.”

---

### Q: How to find and fix memory leaks?
- LeakCanary, Android Profiler
- Avoid static references to Context  
  🧠 **Memory Aid:** “Leak = hold when you shouldn’t.”

---

### Q: How to reduce battery usage?
- Batch background jobs
- Use WorkManager with constraints
- Avoid frequent wake-ups  
  🧠 **Memory Aid:** “Less wake, more life.”

---

### Q: What are Doze and App Standby modes?
System battery optimization modes — delay background syncs.  
🧠 **Memory Aid:** “Idle = save battery.”

---

### Q: What is Overdraw?
Drawing same pixel multiple times → GPU waste.  
🧠 **Memory Aid:** “Overdraw = repaint problem.”

---

### Q: Support different screen sizes
Use `dp`, `sp`, and resource qualifiers (`layout-sw600dp`).  
🧠 **Memory Aid:** “dp for size, sp for text.”

---

### Q: Permission protection levels
| Level | Description |
|--------|--------------|
| **Normal** | Low risk |
| **Dangerous** | Needs user approval |
| **Signature** | Same certificate only |

🧠 **Memory Aid:** “Normal = auto; Dangerous = ask; Signature = trust.”

---

## 🧩 Section Summary

- **Context = system access**
- **Activity/Fragment = UI logic**
- **RecyclerView = modern list**
- **Services = background jobs**
- **IPC = process bridge**
- **Optimization = performance booster**
- **Spannable = styled text**
- **TrimMemory = cleanup signal**

🧠 **Final Memory Aid:** “Master fundamentals → master Android.”

---
