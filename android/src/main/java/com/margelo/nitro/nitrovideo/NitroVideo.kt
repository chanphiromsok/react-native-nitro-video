package com.margelo.nitro.nitrovideo

import androidx.media3.common.util.UnstableApi
import com.facebook.proguard.annotations.DoNotStrip
import com.margelo.nitro.NitroModules
import com.margelo.nitro.nitrovideo.core.HybridVideoPlayer

@DoNotStrip
@UnstableApi
class NitroVideo : HybridNitroVideoSpec() {

  override fun createPlayer(uri: String): HybridVideoPlayerSpec {
    val player = HybridVideoPlayer(context)
    player.uri = uri  // Set the initial URI
    return player
  }
  private val context = NitroModules.applicationContext
    ?: throw IllegalStateException("NitroModules application context is not available")
}
