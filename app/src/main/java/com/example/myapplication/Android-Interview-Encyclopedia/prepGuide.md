# 📘 Android Interview Encyclopedia – Cheat Sheet Index

<details>
<summary>🟢 1. Android_Fundamentals_QA.md</summary>

### **Section 1: Android Base**
1. Why does an Android App lag?
2. What is Context?
3. What are the Android Application Components?
4. What is the project structure of an Android App?
5. What is AndroidManifest.xml?
6. What is the Application class?

### **Section 2: Activity and Fragment**
1. Why use only default constructor to create a Fragment?
2. What is Activity and its lifecycle?
3. Difference between onCreate() and onStart()
4. When only onDestroy() is called without onPause()/onStop()?
5. Why call setContentView() in onCreate()?
6. What is onSaveInstanceState()/onRestoreInstanceState()?
7. What is Fragment and its lifecycle?
8. What is a Bundle?
9. What are launchModes (standard, singleTop, singleTask, singleInstance)?
10. FragmentPagerAdapter vs FragmentStatePagerAdapter
11. Adding vs Replacing fragment in backstack
12. Communicating between Fragments
13. What is a retained Fragment?
14. Purpose of addToBackStack()

### **Section 3: Views and ViewGroups**
1. Optimizing layouts in Android
2. What is a View in Android?
3. Difference between View.GONE and View.INVISIBLE
4. How to create a custom view?
5. What are ViewGroups?
6. What is a Canvas?
7. What is a SurfaceView?
8. RelativeLayout vs LinearLayout
9. ConstraintLayout optimization
10. View tree depth and optimization

### **Section 4: Displaying Lists of Content**
1. ListView vs RecyclerView
2. How RecyclerView works internally
3. RecyclerView optimization for smooth scrolling
4. Optimizing Nested RecyclerView
5. Components of RecyclerView
6. Adapter and ViewHolder
7. LayoutManager
8. Handling multiple view types
9. DiffUtil
10. setHasFixedSize(true) purpose
11. Updating specific RecyclerView item
12. SnapHelper

### **Section 5: Dialogs and Toasts**
1. What is a Dialog?
2. What is a Toast?
3. Dialog vs DialogFragment

### **Section 6: Intents and Broadcasting**
1. What is an Intent?
2. Implicit Intent
3. Explicit Intent
4. What is a BroadcastReceiver?
5. How broadcasts and intents pass messages
6. What is a PendingIntent?
7. Types of Broadcasts

### **Section 7: Services and Background Work**
1. What is a Service?
2. Android Service lifecycle
3. On which thread does a Service run?
4. Service vs IntentService
5. What is a Foreground Service?
6. What is a JobScheduler?
7. How does WorkManager guarantee task execution?

### **Section 8: Long-running Operations**
1. Running parallel tasks and callback after all complete
2. What is ANR? How to prevent it?
3. ThreadPool advantages
4. Daemon Threads vs User Threads
5. Looper, Handler, and HandlerThread
6. Garbage Collection
7. Memory Leak vs OutOfMemoryError
8. Runnable vs Thread

### **Section 9: Inter-Process Communication (IPC)**
1. How can two Android apps interact?
2. Running an app in multiple processes
3. What is AIDL and bounded service creation steps
4. Background processing mechanisms in Android
5. What is a ContentProvider and its purpose

</details>
