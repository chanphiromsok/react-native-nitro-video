package com.margelo.nitro.nitrovideo

import android.view.View
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.uimanager.ThemedReactContext
import androidx.media3.ui.PlayerView

@DoNotStrip
class HybridVideoView(val context: ThemedReactContext) : HybridVideoViewSpec() {
  private val playerView = PlayerView(context)

  override var player: HybridVideoPlayerSpec? = null
    set(value) {
      field = value
      playerView.player = (value as? HybridVideoPlayer)?.exoPlayer
    }

  // View
  override val view: View = playerView

}
