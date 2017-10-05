package com.igalata.opengldemo

import android.opengl.GLES20.*
import android.opengl.GLSurfaceView
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * Created by irinagalata on 10/5/17.
 */
class GLRenderer : GLSurfaceView.Renderer {

    private val vertexData: FloatBuffer
    private val uvData: FloatBuffer
    private var programId = 0

    init {
        val vertices = floatArrayOf(
                -0.5f, -0.2f, 0.0f, 0.2f, 0.5f, -0.2f,
                0.5f, 0.2f, 0.9f, -0.2f, -0.5f, 0.8f
        )
        val uv = floatArrayOf(
                0f, 0f,
                0f, 1f,
                1f, 0f,
                1f, 1f
        )
        vertexData = ByteBuffer.allocateDirect(vertices.size * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer()
        vertexData.put(vertices)

        uvData = ByteBuffer.allocateDirect(uv.size * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer()
        uvData.put(uv)
    }

    override fun onDrawFrame(gl: GL10?) {
        glClear(GL_COLOR_BUFFER_BIT) // clear background on each frame
        glUseProgram(programId)

        val colorPosition = glGetUniformLocation(programId, Shaders.U_COLOR)
        val locationPosition = glGetAttribLocation(programId, Shaders.A_POSITION)
        val uvPosition = glGetAttribLocation(programId, Shaders.A_UV)

        glUniform4f(colorPosition, 0.4f, 0.7f, 0.3f, 1f)
        vertexData.position(0)
        glVertexAttribPointer(locationPosition, 2, GL_FLOAT, false, 0, vertexData)
        glEnableVertexAttribArray(locationPosition)

        uvData.position(0)
        glVertexAttribPointer(uvPosition, 2, GL_FLOAT, false, 0, uvData)
        glEnableVertexAttribArray(uvPosition)

        glDrawArrays(GL_TRIANGLES, 0, 3)

        glUniform4f(colorPosition, 0.9f, 0.1f, 0.9f, 1f)
        // vertexData.position(0)
        glVertexAttribPointer(locationPosition, 2, GL_FLOAT, false, 0, vertexData)
        glEnableVertexAttribArray(locationPosition)

        uvData.position(0)
        glVertexAttribPointer(uvPosition, 2, GL_FLOAT, false, 0, uvData)
        glEnableVertexAttribArray(uvPosition)
        glDrawArrays(GL_TRIANGLES, 3, 3)
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        glViewport(0, 0, width, height)
    }

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        glClearColor(1f, 1f, 1f, 1f) // white background
        programId = ShaderHelper.createProgram(Shaders.fragmentShader, Shaders.vertexShader)
    }

}