package src.display3D.utilities3D;

import src.utilities.*;
import static org.lwjgl.opengl.GL11.*;
import java.util.*;

public class TreeDrawer3D{
  private float angle;
  private Word word;
  private float length;


	
	
    /**
      Cette méthode permet de deffinire certaine variables utiles pour l'arbre 3D.
      @param word est un Word créer grace a la classe Word
      @param angle est l'angle de rotation generique dans l'arbre.
      @require angle <= 360 && angle >= 0
		  @ensure length == 10f
    */

  public TreeDrawer3D(float angle, Word word){
    this.angle=angle;
    this.word = word;
    this.length=10f;
  }

    /**
      Cette méthode permet de créer un arbre 3D.
    */
  public void paintTree3D(){
    Stack<Pose> poseStack = new Stack<>();
    String rtt="";
    boolean isFirstCylinder = true;
    float posX = 0, posY = 0, posZ = 0;
    float angleX = 0, angleY = 0, angleZ = 0;
    for (int i=0; i < this.word.getWord().length(); i++) {
      if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "forward"){
        if (rtt == "pitch") {
          float dy = (float) Math.cos(Math.toRadians(angleX)) * length / 100;
          float dz = (float) Math.sin(Math.toRadians(angleX)) * length / 100;
          posY += dy;
          posZ += dz;    
        } 
        else if (rtt == "roll") {
          float dx = (float) Math.sin(Math.toRadians(angleZ)) * length / 100;
          float dy = (float) Math.cos(Math.toRadians(angleZ)) * length / 100;
          posY -= dx;
          posX -= dy;
        } 
        else if  (rtt == "Turn"){
          float dx = (float) Math.sin(Math.toRadians(angleY)) * length / 100;
          float dz = (float) Math.cos(Math.toRadians(angleY)) * length / 100;
          posZ += dx;
          posX += dz;
        }
        else if(rtt=="btp"){
          Pose pose = poseStack.pop();
          posX = pose.getX();
          posY = pose.getY();
          posZ = pose.getZ();
          angleX = pose.getAngleX();
          angleY = pose.getAngleY();
          angleZ = pose.getAngleZ();
        }
        else{
          float dy = (float) Math.cos(Math.toRadians(angleX)) * length / 100;
          float dz = (float) Math.sin(Math.toRadians(angleX)) * length / 100;
          posY -= dy;
          posZ += dz;
        }
        if (isFirstCylinder) {
          posY -= 0.6;
          isFirstCylinder = false;
        }
        glPushMatrix();
        glTranslatef(posX, posY, posZ);
        glRotatef(angleX, 1, 0, 0);
        glRotatef(angleY, 0, 1, 0);
        glRotatef(angleZ, 0, 0, 1);
        new Cylinder( 0, 0, 0, this.length , 0.025f);
        glPopMatrix();
      }
      else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "turnLeft"){
        rtt="Turn";
        angleY += angle;
      }
      else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "turnRight"){
        rtt="Turn";
        angleY -= angle;
      }
      else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "pitchDown"){
        rtt="pitch";
        angleX += angle;
      }
      else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "pitchUp"){
        rtt="pitch";
        angleX -= angle;
      }
      else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "rollLeft"){
        rtt="roll";
        angleZ += angle;
      }
      else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "rollRight"){
        rtt="roll";
        angleZ -= angle;
      }
      else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "turnAround") {
        rtt="Turn";
        angleY += 180;

      }
      else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "savePose") {
        poseStack.push(new Pose(posX, posY, posZ, angleX, angleY, angleZ));
      }
      else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "backToPose") {
        rtt+="btp"; 
      }
    }
  }
}
