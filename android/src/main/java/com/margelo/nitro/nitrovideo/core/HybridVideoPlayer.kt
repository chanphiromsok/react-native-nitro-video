package com.margelo.nitro.nitrovideo.core

import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import android.util.Log
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.margelo.nitro.nitrovideo.HybridVideoPlayerSpec
import com.margelo.nitro.nitrovideo.VideoPlayerSourceBase
import com.margelo.nitro.nitrovideo.utils.Threading
import java.lang.ref.WeakReference

class HybridVideoPlayer(context: Context) : HybridVideoPlayerSpec() {

  @SuppressLint("UnsafeOptInUsageError")
  private val player = ExoPlayer.Builder(context)
    .setLooper(Looper.getMainLooper())
    .build()

  private var currentPlayerView: WeakReference<PlayerView>? = null

  // Expose the ExoPlayer instance so it can be connected to PlayerView
  val exoPlayer: ExoPlayer get() = player

  /**
   * Attach this player to a PlayerView.
   * Uses ExoPlayer's switchTargetView to properly handle view transitions.
   */
  @SuppressLint("UnsafeOptInUsageError")
  fun attachToView(newView: PlayerView) {
    Threading.runOnMainThread {
      PlayerView.switchTargetView(player, currentPlayerView?.get(), newView)
      currentPlayerView = WeakReference(newView)
      Log.d("HybridVideoPlayer", "Player attached to view with URI: $uri")
    }
  }

  /**
   * Detach this player from its current view.
   */
  @SuppressLint("UnsafeOptInUsageError")
  fun detachFromView() {
    Threading.runOnMainThread {
      PlayerView.switchTargetView(player, currentPlayerView?.get(), null)
      currentPlayerView = null
      Log.d("HybridVideoPlayer", "Player detached from view")
    }
  }

  override var uri: String? = null
    set(value) {
      field = value
      if(value != null){
        Threading.runOnMainThread {
          val mediaItem = MediaItem.fromUri(value)
          player.setMediaItem(mediaItem)
          player.prepare()
          Log.d("HybridVideoPlayer", "Media source set with URI: $value")
        }
      }
    }

  override fun replaceVideoSource(source: VideoPlayerSourceBase) {
    if(source.uri != null){
      Log.d("HybridVideoPlayer", "Replacing video source with URI: ${source.uri}")
      Threading.runOnMainThread {
        val mediaItem = MediaItem.fromUri(source.uri)
        player.setMediaItem(mediaItem)
        player.prepare()
        uri = source.uri
      }
    }
  }

  override fun play() {
    Threading.runOnMainThread {
      Log.d("HybridVideoPlayer", "play()")
      player.play()
    }
  }

  override fun pause() {
    Threading.runOnMainThread {
      Log.d("HybridVideoPlayer", "pause()")
      player.pause()
    }
  }

  override fun stop() {
    Threading.runOnMainThread {
      Log.d("HybridVideoPlayer", "stop()")
      player.stop()
    }
  }

  override fun release() {
    Threading.runOnMainThread {
      Log.d("HybridVideoPlayer", "release()")
      detachFromView()
      player.release()
    }
  }

}
