package test;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

public class Meteors {
	public Shape circle1 = null;
	public Shape circle2 = null;
	public Shape circle3 = null;
	public Shape circle4 = null;
	public Shape circle5 = null;
	public Shape circle6 = null;
	private float radius1 = 30;
	
	/*
	 * On startup 6 meteors are created.
	 */
	public void startUp(GameContainer container){
		circle1 = new Circle (300, 600, radius1);
		circle2 = new Circle (600, 300, radius1);
		circle3 = new Circle (0, 0, 0);
		circle4 = new Circle (0, 0, 0);
		circle5 = new Circle (0, 0, 0);
		circle6 = new Circle (0, 0, 0);
	}
	
	/*
	 * In update the meteors are set to 'orbit'
	 */
	public void update(){
		circle1 = circle1.transform(Transform.createRotateTransform((float)(Math.PI/300), 250, 400));
		circle2 = circle2.transform(Transform.createRotateTransform((float)(Math.PI/400), 600, 450));
		circle3 = circle3.transform(Transform.createRotateTransform((float)(Math.PI/300), 250, 400));
		circle4 = circle4.transform(Transform.createRotateTransform((float)(-Math.PI/400), 250, 400));
		circle5 = circle5.transform(Transform.createRotateTransform((float)(Math.PI/300), 600, 450));
		circle6 = circle6.transform(Transform.createRotateTransform((float)(-Math.PI/400), 600, 450));
		
	}
	
	public void drawing (GameContainer container, Graphics g) throws SlickException{
		g.draw(circle1);
		g.draw(circle2);
		g.draw(circle3);
		g.draw(circle4);
		g.draw(circle5);
		g.draw(circle6);
		
	}
	
	public void setCircle1(float x, float y, float r){
		this.circle1 = new Circle (x, y, r);
	}
	public void setCircle2(float x, float y, float r){
		this.circle2 = new Circle (x, y, r);
	}
	public void setCircle3(float x, float y, float r){
		this.circle3 = new Circle (x, y, r);
	}
	public void setCircle4(float x, float y, float r){
		this.circle4 = new Circle (x, y, r);
	}
	public void setCircle5(float x, float y, float r){
		this.circle5 = new Circle (x, y, r);
	}
	public void setCircle6(float x, float y, float r){
		this.circle6 = new Circle (x, y, r);
	}
	
}
