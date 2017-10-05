package com.igalata.opengldemo

import android.opengl.GLES20.*

/**
 * Created by irinagalata on 10/5/17.
 */
object ShaderHelper {

    fun createProgram(fragmentShader: String, vertexShader: String): Int {
        return glCreateProgram().let { programId ->
            glAttachShader(programId, createShader(GL_VERTEX_SHADER, vertexShader))
            glAttachShader(programId, createShader(GL_FRAGMENT_SHADER, fragmentShader))
            glLinkProgram(programId)
            programId
        }
    }

    fun createShader(type: Int, code: String): Int {
        return glCreateShader(type).let { shaderId ->
            glShaderSource(shaderId, code)
            glCompileShader(shaderId)
            shaderId
        }

    }

}