package src.display3D.utilities3D;

public class Pose {
    private float x;
    private float y;
    private float z;
    private float angleX;
    private float angleY;
    private float angleZ;
    
    
	/**
		Cette méthode permet de retenir une position precedente.
		@param x est le float qui definit le point sur son abcisse
		@param y est le float qui definit le point sur son ordonnée
		@param z est le float qui definit le point sur sa profondeur
		@param length est le float qui definit la longeur du cylindre
		@param size est le float qui definit taille
		@param angle est le float qui definit le nombre de cotés que posséde le cylindre
		
      		@require angleX <= 360 && angleX >= 0
     		@require angleY <= 360 && angleY >= 0
      		@require angleZ <= 360 && angleZ >= 0
		*/
    public Pose(float x, float y, float z, float angleX, float angleY, float angleZ) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.angleX = angleX;
        this.angleY = angleY;
        this.angleZ = angleZ;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getAngleX() {
        return angleX;
    }

    public float getAngleY() {
        return angleY;
    }

    public float getAngleZ() {
        return angleZ;
    }
}
