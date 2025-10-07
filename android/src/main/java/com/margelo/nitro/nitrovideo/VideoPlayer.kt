package com.margelo.nitro.nitrovideo

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class HybridVideoPlayer(override val uri: String, context: Context) : HybridVideoPlayerSpec() {
  private val player = ExoPlayer.Builder(context).build()

  init {
    // Set initial media source
    val mediaItem = MediaItem.fromUri(uri)
    player.setMediaItem(mediaItem)
    player.prepare()
  }

  override fun replaceVideoSource(source: VideoPlayerSourceBase) {
    val mediaItem = MediaItem.fromUri(source.uri)
    player.setMediaItem(mediaItem)
    player.prepare()
  }

//  override fun setLooping(isLooping: Boolean) {
//    player.repeatMode = if (isLooping) {
//      ExoPlayer.REPEAT_MODE_ONE
//    } else {
//      ExoPlayer.REPEAT_MODE_OFF
//    }
//  }

//  override fun setVolume(volume: Double) {
//    // Clamp volume to valid range (0.0 to 1.0)
//    player.volume = volume.toFloat().coerceIn(0f, 1f)
//  }

  override fun play() = player.play()
  override fun pause() = player.pause()
  override fun stop() {
    player.stop()
  }

  override fun release() {
    player.release()
  }

  val exoPlayer get() = player

}
