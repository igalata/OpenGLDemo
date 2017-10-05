package com.igalata.opengldemo

/**
 * Created by irinagalata on 10/5/17.
 */
object Shaders {

    const val U_COLOR = "u_Color"
    const val A_POSITION = "a_Position"
    const val A_UV = "a_UV"

    //language=GLSL
    val fragmentShader = """
        precision mediump float;
        uniform vec4 u_Color;
        varying vec2 v_UV;

        void main()
        {
            gl_FragColor = u_Color;
        }
    """

    //language=GLSL
    val vertexShader = """
        attribute vec4 a_Position;
        attribute vec2 a_UV;
        varying vec2 v_UV;

        void main()
        {
            gl_Position = a_Position;
            v_UV = a_UV;
        }
    """

}