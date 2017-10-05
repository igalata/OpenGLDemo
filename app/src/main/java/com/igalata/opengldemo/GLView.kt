package com.igalata.opengldemo

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet

/**
 * Created by irinagalata on 10/5/17.
 */
class GLView: GLSurfaceView {

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setEGLContextClientVersion(2)
        setRenderer(GLRenderer())
        renderMode = RENDERMODE_CONTINUOUSLY
    }

}