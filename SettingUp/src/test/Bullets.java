package test;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Transform;

public class Bullets {
	public Shape bull = null;
	private float x1;
	private float y1;
	private float x2;
	private float y2;
	private float x3;
	private float y3;
	private float bulSpeed = 0.1f;
	
	public void startUp() {
		bull = new Line(x1,y1, x2, y2);
	}
	/*
	 * The shoot function gets the current location and direction of the player
	 * and fires shots in the direction the player is turned.
	 */
	public void shoot(boolean shooting){
		bull = new Line(x1,y1, x2, y2);
			if (shooting){
			x3 = (x1-x2)*bulSpeed;
			y3 = (y1-y2)*bulSpeed;
			}
			bull = bull.transform(Transform.createTranslateTransform(x3, y3));
			bulSpeed = bulSpeed+0.2f;

		bull = bull.transform(Transform.createTranslateTransform(x3, y3));
		bulSpeed = bulSpeed+0.2f;
	}
		
	public void drawing (GameContainer container, Graphics g) throws SlickException {
		g.draw(bull);
	}
	
	public void setX1(float newX1){
		this.x1 = newX1;
	}
	public float getX1(){
		return x1;
	}
	public void setY1(float newY1){
		this.y1 = newY1;
	}
	public float getY1(){
		return y1;
	}
	public void setX2(float newX2){
		this.x2 = newX2;
	}
	public float getX2(){
		return x2;
	}
	public void setY2(float newY2){
		this.y2 = newY2;
	}
	public float getY2(){
		return y2;
	}
	public void setBulSpeed(float newSpeed){
		this.bulSpeed = newSpeed;
	}
	public float getBulSpeed(){
		return bulSpeed;
	}

}
