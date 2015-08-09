package test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class SetupClass extends BasicGame{
	private static int width  = 1200;
	private static int height = 900;
	Player player = new Player();
	private boolean forward = false;
	private boolean turn = false;
	Bullets bullets = new Bullets();
	private boolean fire = false;
	Meteors meteors = new Meteors();
	public Shape board = null;
	public static boolean collidesWithWall = false;
	private boolean collidesWithCircle1 = false;
	private boolean collidesWithCircle2 = false;
	private boolean collidesWithCircle3 = false;
	private boolean collidesWithCircle4 = false;
	private boolean collidesWithCircle5 = false;
	private boolean collidesWithCircle6 = false;
	private boolean checkin11 = false;
	private boolean checkin12 = false;
	private boolean checkin21 = false;
	private boolean checkin22 = false;
	private boolean playerCircle1 = false;
	private boolean playerCircle2 = false;
	private boolean playerCircle3 = false;
	private boolean playerCircle4 = false;
	private boolean playerCircle5 = false;
	private boolean playerCircle6 = false;
	
	public SetupClass(String astroids) {
		super(astroids);
		
	}
	
	public void init(GameContainer container) throws SlickException {
		/*
		 *player.startUp creates the character for the user.
		 *the character is defined by the tip of the triangle.
		 */
		player.startUp(container);
		/*
		 * The board is set up to kill the player if it moves outside the visible sheet.
		 */
		board = new Rectangle(0, 0, 1200, 900);
		/*
		 * Two meteors are created on startup along with invisible ones for later use.
		 */
		meteors.startUp(container);
		/*
		 * The bullets are made on start up to work around a null-exception.
		 */
		bullets.startUp();
	}
	
	
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		float temp = 0;		
		/*
		 * the following code is the controls for the game, it changes values in player
		 * to control the character.
		 */
		if (input.isKeyDown(Input.KEY_A)){
			temp = player.getRotation();
			temp = temp - (float)(Math.PI/1800);
			player.setRotation(temp);
			turn = true;
		}
		if (input.isKeyDown(Input.KEY_D)){
			temp = player.getRotation();
			temp = temp + (float)(Math.PI/1800);
			player.setRotation(temp);
			turn = true;
		}
		else {
			player.setRotation(temp);
		}
		
		if (input.isKeyDown(Input.KEY_W)){
			forward = true;
		}else{
			forward = false;
		}		
		/*
		 * the fire key 'I' initializes the shooting mechanism in Bullets.
		 */
		if (input.isKeyPressed(Input.KEY_I)){
			bullets.setBulSpeed(0.1f);
			bullets.setX1(player.player.getPoint(0)[0]);
			bullets.setY1(player.player.getPoint(0)[1]);
			bullets.setX2(player.player.getCenterX());
			bullets.setY2(player.player.getCenterY());
			fire = true;
		}
		
		
		/*
		 * the following code describes when the game is lost if the player
		 * either intersects with the board or with a meteor.
		 */
		collidesWithWall = player.player.intersects(board);
		playerCircle1 = player.player.intersects(meteors.circle1);
		playerCircle2 = player.player.intersects(meteors.circle2);
		playerCircle3 = player.player.intersects(meteors.circle3);
		playerCircle4 = player.player.intersects(meteors.circle4);
		playerCircle5 = player.player.intersects(meteors.circle5);
		playerCircle6 = player.player.intersects(meteors.circle6);
		
		/*
		 * the following code stores is a bullet hits a meteor and
		 * which meteor is hit.
		 */
		collidesWithCircle1 = bullets.bull.intersects(meteors.circle1);
		collidesWithCircle2 = bullets.bull.intersects(meteors.circle2);
		collidesWithCircle3 = bullets.bull.intersects(meteors.circle3);
		collidesWithCircle4 = bullets.bull.intersects(meteors.circle4);
		collidesWithCircle5 = bullets.bull.intersects(meteors.circle5);
		collidesWithCircle6 = bullets.bull.intersects(meteors.circle6);
		
		/*
		 * The following code spawns new meteors and destroys old ones.
		 * If a large meteor (1 & 2) is destroyed two new will spawn.
		 * If two small meteors are destroyed a large will spawn.
		 */
		if (collidesWithCircle1){
			meteors.setCircle3(meteors.circle1.getCenterX(), meteors.circle1.getCenterY(), 15f);
			meteors.setCircle4(meteors.circle1.getCenterX(), meteors.circle1.getCenterY(), 15f);
			meteors.setCircle1(0, 0, 0);
			collidesWithCircle1 = false;
		}
		if (collidesWithCircle2){
			meteors.setCircle5(meteors.circle2.getCenterX(), meteors.circle2.getCenterY(), 15f);
			meteors.setCircle6(meteors.circle2.getCenterX(), meteors.circle2.getCenterY(), 15f);
			meteors.setCircle2(0, 0, 0);
			collidesWithCircle2 = false;
		}
		if (collidesWithCircle3){
			meteors.setCircle3(0, 0, 0);
			collidesWithCircle3 = false;
			checkin11 = true;
		}
		if (collidesWithCircle4){
			meteors.setCircle4(0, 0, 0);
			collidesWithCircle4 = false;
			checkin12 = true;
		}
		if (collidesWithCircle5){
			meteors.setCircle5(0, 0, 0);
			collidesWithCircle5 = false;
			checkin21 = true;
		}
		if (collidesWithCircle6){
			meteors.setCircle6(0, 0, 0);
			collidesWithCircle6 = false;
			checkin22 = true;
		}
		if (checkin11 && checkin12){
			meteors.setCircle1(300f, 600f, 30f);
			checkin11 = false;
			checkin12 = false;
		}
		if (checkin21 && checkin22){
			meteors.setCircle2(600f, 300f, 30f);
			checkin21 = false;
			checkin22 = false;
		}
		
		/*
		 * When the player collides with the walls or a meteor the game stops,
		 * as long as the player does not, it will keep going and enable all the
		 * functions of the program.
		 */
		if (collidesWithWall || playerCircle1 || playerCircle2 || playerCircle3 || playerCircle4 || playerCircle5 || playerCircle6){
			container.exit();	
		}else{
			meteors.update();
			player.movement(forward, turn);
			bullets.shoot(fire);
		}
		
	}

	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawString("Press 'A' to rotate counter clockwise, press 'D' to rotate clockwise, press 'W' to move forward, and Press 'I' to fire", 10, 870);
		player.drawing(container, g);
		meteors.drawing(container, g);
		if (fire){
			bullets.drawing(container, g);
		}		
		
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test"));
		app.setDisplayMode(width, height, false);
		app.setAlwaysRender(true);
		app.start();
	}


}
