package com.margelo.nitro.nitrovideo.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Callable
import java.util.concurrent.FutureTask

object Threading {
  @JvmStatic
  fun runOnMainThread(action: () -> Unit) {
    // We are already on the main thread, run and return
    if (Looper.myLooper() == Looper.getMainLooper()) {
      action()
      return
    }

    // Post the action to the main thread
    Handler(Looper.getMainLooper()).post {
      action()
    }
  }

  @JvmStatic
  fun <T> runOnMainThreadSync(action: Callable<T>): T {
    return if (Looper.myLooper() == Looper.getMainLooper()) {
      // Already on the main thread, run and return the result
      action.call()
    } else {
      // Post the action to the main thread and wait for the result
      val futureTask = FutureTask(action)
      Handler(Looper.getMainLooper()).post(futureTask)
      futureTask.get()
    }
  }
}
