package com.margelo.nitro.nitrovideo

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext

open class VideoViewManager(): SimpleViewManager<HybridVideoView>() {
  override fun getName(): String {
    return "VideoView"
  }

  override fun createViewInstance(context: ThemedReactContext): HybridVideoView {
    val videoView= HybridVideoView(context)
    videoView.loadVideo("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
    videoView.play()
    return videoView
  }

  override fun onDropViewInstance(view: HybridVideoView) {
    super.onDropViewInstance(view)
  }


}
