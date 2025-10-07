package com.margelo.nitro.nitrovideo.react

import android.annotation.SuppressLint
import android.util.Log
import com.margelo.nitro.NitroModules
import com.margelo.nitro.nitrovideo.HybridVideoPlayerSpec
import com.margelo.nitro.nitrovideo.HybridVideoViewSpec
import com.margelo.nitro.nitrovideo.core.HybridVideoPlayer

class HybridVideoView: HybridVideoViewSpec() {
  private val context = NitroModules.applicationContext
    ?: throw Error("NitroVideo: Tried to create HybridVideoView but NitroModules.applicationContext is null!")

  private val playerView: CustomPlayerView = CustomPlayerView(context)

  override var player: HybridVideoPlayerSpec? = null
    set(value) {
      // Detach previous player if any
      val oldPlayer = field
      if (oldPlayer is HybridVideoPlayer) {
        oldPlayer.detachFromView()
      }

      field = value

      // Attach new player using ExoPlayer's switchTargetView pattern
      if (value is HybridVideoPlayer) {
        playerView.player = value.exoPlayer
        value.attachToView(playerView)
      }
    }

  override val view: CustomPlayerView = playerView

  @SuppressLint("UnsafeOptInUsageError")
  private fun onAppear() {
    if(player!=null){
      Log.d("HybridVideoView", "onAppear ${player!!.uri}")
    }else{
      Log.d("HybridVideoView", "Creating player")
    }
//    playerView.player?.let {
//      val mediaItem = MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
//      it.setMediaItem(mediaItem)
//      it.prepare()
//    }
  }


  private fun onDisappear() {
    player?.pause()
  }

}
