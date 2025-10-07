package com.margelo.nitro.nitrovideo

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.uimanager.ThemedReactContext
import androidx.media3.ui.PlayerView
import com.facebook.react.views.view.ReactViewManager
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.common.MediaItem
import androidx.media3.common.Player

@DoNotStrip
class HybridVideoView : FrameLayout {
  private val playerView: PlayerView
  private var player: ExoPlayer? = null

  constructor(context: Context) : super(context) {
    playerView = PlayerView(context)
    init()
  }

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    playerView = PlayerView(context)
    init()
  }

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    playerView = PlayerView(context)
    init()
  }

  private fun init() {
    addView(playerView)
    setupPlayer()
  }

  private fun setupPlayer() {
    player = ExoPlayer.Builder(context).build().apply {
      playerView.player = this
      // Set default playback settings
      playWhenReady = false
      repeatMode = Player.REPEAT_MODE_OFF
    }
  }

  fun loadVideo(uri: String) {
    player?.let {
      val mediaItem = MediaItem.fromUri(uri)
      it.setMediaItem(mediaItem)
      it.prepare()
    }
  }

  fun play() {
    player?.play()
  }

  fun pause() {
    player?.pause()
  }

  fun seekTo(positionMs: Long) {
    player?.seekTo(positionMs)
  }

  fun setVolume(volume: Float) {
    player?.volume = volume.coerceIn(0f, 1f)
  }

  fun release() {
    player?.release()
    player = null
  }

  override fun onDetachedFromWindow() {
    super.onDetachedFromWindow()
    release()
  }
}
