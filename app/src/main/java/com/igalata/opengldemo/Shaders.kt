package com.igalata.opengldemo

/**
 * Created by irinagalata on 10/5/17.
 */
object Shaders {

    const val U_COLOR = "u_Color"
    const val A_POSITION = "u_Position"

    //language=GLSL
    val fragmentShader = """
        uniform vec4 u_Color;

        void main()
        {
            gl_FragColor = u_Color;
        }
    """

    //language=GLSL
    val vertexShader = """
        attribute vec4 a_Position;

        void main()
        {
            gl_Position = a_Position;
        }
    """

}