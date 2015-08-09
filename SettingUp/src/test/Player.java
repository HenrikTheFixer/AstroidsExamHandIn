package test;

import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
//import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Transform;



public class Player {
	public Shape player = null; 
	private float tipX = 600; 
	private float tipY = 415;
	private float speed = 0.10f;
	private float moveX;
	private float moveY;
	private float[] points = new float[] {tipX, tipY, tipX-50, tipY-15, tipX-50, tipY+15};
	private float rotation = 0.0f;
	
	public void startUp (GameContainer container){
		player = new Polygon(points);		
		
	}
	
	public void movement(boolean forward, boolean turn){
	
		/*
		 * The following if-statement calculates the forward motion.
		 */
		if (forward){
			moveX = (player.getPoint(0)[0] - player.getCenterX())*speed;
			moveY = (player.getPoint(0)[1] - player.getCenterY())*speed;
		}
			player = player.transform(Transform.createTranslateTransform(moveX, moveY));
					
		/*
		 * The following if-statement applies the rotation of the player.	
		 */
		if (turn){
			player = player.transform(Transform.createRotateTransform(rotation, player.getCenterX(), player.getCenterY()));
		
		}
		
			
	}
	
	public void drawing (GameContainer container, Graphics g) throws SlickException {
		g.draw(player);
	}
	
	public void setRotation(float f){
		this.rotation = f;
	}
	public float getRotation(){
		return rotation;
	}
	public void setTipX(float x){
		this.tipX = x;
	}
	public float getTipX(){
		return tipX;
	}
	public void setTipY(float y){
		this.tipY = y;
	}
	public float getTipY(){
		return tipY;
	}
	public void setSpeed(float newSpeed){
		this.speed = newSpeed;
	}
	public float getSpeed(){
		return speed;
	}
	public void setMoveX(float newX){
		this.moveX = newX;
	}
	public float getMoveX(){
		return moveX;
	}
	public void setMoveY(float newY){
		this.moveY = newY;
	}
	public float getMoveY(){
		return moveY;
	}

}

