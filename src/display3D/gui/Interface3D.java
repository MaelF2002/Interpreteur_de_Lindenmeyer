package src.display3D.gui;

//----------------------------------------------------//
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import src.display3D.utilities3D.TreeDrawer3D;
import src.utilities.*;
//----------------------------------------------------//

public class Interface3D {
  private TreeDrawer3D treeDrawer;

    /**
      Cette méthode permet de d'afficher un arbre 3D.
      @param word est un Word créer grace a la classe Word
      @param angle est l'angle de rotation generique dans l'arbre.
      @require angle <= 360 && angle >= 0
    */
    public Interface3D(Word word,float angle){
        this.treeDrawer = new TreeDrawer3D(angle, word);

        // Initialisation de GLFW
        GLFWErrorCallback.createPrint(System.err).set();
        if(!glfwInit())
          throw new IllegalStateException("Impossible d'initialiser GLFW");

        // Configuration de la fenêtre
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        long window = glfwCreateWindow(750, 750, "Arbre 3D", NULL, NULL);
        if( window == NULL )
          throw new RuntimeException("Impossible de créer la fenêtre GLFW");

        // Get the thread stack and push a new frame
        try( MemoryStack stack = stackPush() ) {
          IntBuffer pWidth = stack.mallocInt(1); // int*
          IntBuffer pHeight = stack.mallocInt(1); // int*

      		// Get the window size passed to glfwCreateWindow
      		glfwGetWindowSize(window, pWidth, pHeight);

      		// Get the resolution of the primary monitor
      		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

      	  // Center the window
      		glfwSetWindowPos( window, (vidmode.width() - pWidth.get(0)) / 2, (vidmode.height() - pHeight.get(0)) / 2);
        }

        // Centre la fenêtre sur l'écran
        // Création du contexte OpenGL
        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        // Affiche la fenêtre
        glfwShowWindow(window);
        // Boucle de rendu
        
        while ( !glfwWindowShouldClose(window) ) {
            // Efface le tampon de couleur et le tampon de profondeur
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            glEnable(GL_DEPTH_TEST);
            /////////////////ICI IL FAUT FAIRE LE DESSIN DE L'ARBRE
            glRotatef(1f, 0f, 1f, 0f);
            this.treeDrawer.paintTree3D();
            
          
            glfwSwapBuffers(window); // Rafraîchit la fenêtre
            glfwPollEvents(); // Gère les événements de la fenêtre

        }

        // Fermeture de la fenêtre et libération des ressources
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

}
