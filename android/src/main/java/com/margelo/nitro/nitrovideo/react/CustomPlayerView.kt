package com.margelo.nitro.nitrovideo.react

import android.content.Context
import android.util.AttributeSet
import androidx.media3.ui.PlayerView

class CustomPlayerView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : PlayerView(context, attrs, defStyleAttr) {

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
  }

  override fun onDetachedFromWindow() {
    super.onDetachedFromWindow()
  }

}

