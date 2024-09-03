package src.display3D.utilities3D;
import static org.lwjgl.opengl.GL33.*;

public class Cylinder {


	
	/**
		Cette méthode permet l'affichage d'un Cylindre 3D dans une fenetre.
		@param abscissa est le float qui definit le point d'origine du centre du cube sur son abcisse
		@param ordinate est le float qui definit le point d'origine du centre du cube sur son ordonnée
		@param depth est le float qui definit le point d'origine du centre du cube sur sa profondeur
		@param length est le float qui definit la longeur du cylindre
		@param size est le float qui definit taille
		@param angle est le float qui definit le nombre de cotés que posséde le cylindre
		@require abscissa <= 1 && abscissa >= -1 
		@require ordinate <= 1 && ordinate >= -1 
		@require depth <= 1 && depth >= -1 
		@require length*size*0.5 <= 1
		@require 360%angle == 0 
		@ensure DrawAllCylinder(abscissa, ordinate, depth, length, size, angle,  angleX,  angleY, angleZ)
		*/
	public Cylinder(float abscissa, float ordinate, float depth,float length,float size, float angle){
		DrawAllCylinder(abscissa, ordinate, depth, length, size, angle);
	}
	public Cylinder(float abscissa, float ordinate, float depth,float length,float size){
		DrawAllCylinder(abscissa, ordinate, depth, length, size, 20f);
	}
	public Cylinder(float abscissa, float ordinate, float depth){
		DrawAllCylinder(abscissa,ordinate,depth, 4, 0.1f, 20f);
	}
	/**
		Cette méthode permet l'affichage d'un Cylindre 3D dans une fenetre.
		@param abscissa est le float qui definit le point d'origine du centre du Cylindre sur son abcisse
		@param ordinate est le float qui definit le point d'origine du centre du Cylindre sur son ordonnée
		@param depth est le float qui definit le point d'origine du centre du Cylindre sur sa profondeur
		@param length est le float qui definit la longeur du cylindre
		@param size est le float qui definit taille
		@param angle est le float qui definit le nombre de cotés que posséde le cylindre
		@require abscissa <= 1 && abscissa >= -1 
		@require ordinate <= 1 && ordinate >= -1 
		@require depth <= 1 && depth >= -1 
		@require length*size*0.5 <= 1
		@require 360%angle == 0
		*/
	
	public void DrawAllCylinder(float x,float y,float z,float length,float size, float angle) {
		glPushMatrix();

		int j;
		
		//new Rotate3D( angleX, angleY, angleZ);
		glBegin(GL_QUAD_STRIP);
		for (j=0;j<360+angle;j+=angle) {
			double rad = Math.toRadians(j);
			glColor3f(0.44f,0.21f,0.06f);
			glVertex3f((x+(float)Math.cos(rad)*(0.5f*size)),(y+length*(0.5f*size/15)),(z+(float)Math.sin(rad)*(0.5f*size)));
			glColor3f(0.25f,0.10f,0.04f);
			glVertex3f((x+(float)Math.cos(rad)*(0.5f*size)),(y-length*(0.5f*size-0.002f)),(z+(float)Math.sin(rad)*(0.5f*size)));
			}
		glEnd();

		glPopMatrix();
	}
}

