package com.margelo.nitro.nitrovideo

import com.facebook.proguard.annotations.DoNotStrip
import com.margelo.nitro.NitroModules

@DoNotStrip
class NitroVideo : HybridNitroVideoSpec() {

  override fun createPlayer(uri: String): HybridVideoPlayerSpec {
    val context = NitroModules.applicationContext
      ?: throw IllegalStateException("NitroModules application context is not available")
    return HybridVideoPlayer(uri, context)
  }
}
