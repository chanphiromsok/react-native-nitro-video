package com.margelo.nitro.nitrovideo

import com.facebook.react.BaseReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfoProvider
import com.facebook.react.uimanager.ViewManager
import com.margelo.nitro.nitrovideo.views.HybridVideoViewManager

class NitroVideoPackage : BaseReactPackage() {
    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
        return null
    }

    override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
        return ReactModuleInfoProvider { HashMap() }
    }

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        val viewManager = ArrayList<ViewManager<*,*>>();
        viewManager.add(HybridVideoViewManager())
        return viewManager
    }

    companion object {
        init {
            System.loadLibrary("nitrovideo")
        }
    }
}
