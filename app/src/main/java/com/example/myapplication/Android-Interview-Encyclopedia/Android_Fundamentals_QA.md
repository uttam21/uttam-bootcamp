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
* [How does RecyclerView improve performance over ListView?](#q-how-does-recyclerview-improve-performance-over-listview)
* [What are the components of a RecyclerView?](#q-what-are-the-components-of-a-recyclerview)
* [What is a LayoutManager in RecyclerView?](#q-what-is-a-layoutmanager-in-recyclerview)
* [How do you handle multiple view types in a single RecyclerView?](#q-how-do-you-handle-multiple-view-types-in-a-single-recyclerview)
* [What is DiffUtil and how does it improve RecyclerView performance?](#q-what-is-diffutil-and-how-does-it-improve-recyclerview-performance)
* [What is the purpose of RecyclerView.setHasFixedSize(true)?](#q-what-is-the-purpose-of-recyclerviewsethasfixedsizetrue)
* [How do you update a specific item in RecyclerView?](#q-how-do-you-update-a-specific-item-in-recyclerview)
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
* [How do broadcasts and intents work to pass messages?](#q-how-do-broadcasts-and-intents-work-to-pass-messages)
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
* [What are the steps in creating a bounded service through AIDL?](#q-what-are-the-steps-in-creating-a-bounded-service-through-aidl)
* [What can you use for background processing in Android?](#q-what-can-you-use-for-background-processing-in-android)
* [What is a ContentProvider and what is it used for?](#q-what-is-a-contentprovider-and-what-is-it-used-for)
* [Best practices for inter-process communication](#q-best-practices-for-inter-process-communication)

### ⏱️ Section 9: Long-running Operations
* [How to run parallel tasks and get a callback when all are complete?](#q-how-to-run-parallel-tasks-and-get-a-callback-when-all-are-complete)
* [What is ANR and how can it be prevented?](#q-what-is-anr-and-how-can-it-be-prevented)
* [What are the advantages of ThreadPool?](#q-what-are-the-advantages-of-threadpool)
* [Daemon Threads vs User Threads](#q-daemon-threads-vs-user-threads)
* [Explain Looper, Handler, and HandlerThread](#q-explain-looper-handler-and-handlerthread)
* [What is Garbage Collection?](#q-what-is-garbage-collection)
* [Memory Leak vs OutOfMemory (OOM) Error](#q-memory-leak-vs-outofmemory-oom-error)
* [Difference between Runnable and Thread in Android](#q-difference-between-runnable-and-thread-in-android)
* [Best practices for long-running operations](#q-best-practices-for-long-running-operations)

### 🎨 Section 10: Look and Feel & Performance Optimization
* [What is a Spannable?](#q-what-is-a-spannable)
* [What is a SpannableString?](#q-what-is-a-spannablestring)
* [Best practices for using text in Android](#q-best-practices-for-using-text-in-android)
* [How to implement Dark Mode in an application?](#q-how-to-implement-dark-mode-in-an-application)
* [Improve Android app performance](#q-improve-android-app-performance)
* [What is the onTrimMemory() method?](#q-what-is-the-ontrimmemory-method)
* [How to identify and fix OutOfMemory issues?](#q-how-to-identify-and-fix-outofmemory-issues)
* [How to find and fix memory leaks in Android applications?](#q-how-to-find-and-fix-memory-leaks-in-android-applications)
* [How to reduce battery usage in an Android application?](#q-how-to-reduce-battery-usage-in-an-android-application)
* [What are Doze and App Standby modes?](#q-what-are-doze-and-app-standby-modes)
* [What is overdraw?](#q-what-is-overdraw)
* [How do you support different screen sizes and resolutions?](#q-how-do-you-support-different-screen-sizes-and-resolutions)
* [What are permission protection levels?](#q-what-are-permission-protection-levels)

---

*(Full section content follows below — already written in your document.)*
