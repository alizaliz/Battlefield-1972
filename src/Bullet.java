/* 
  * 
  *
  * 
  * author: Zain Ali 1298523
  * 
  *
  * This class creates the Bullet objects, it contains the methods to draw the bullets 
  * and set their speeds/positions.
*/ 

import java.awt.*;

public class Bullet{

	private Rectangle jacket;//Jacket of the bullet
	private int speed, direction, size, headX, headY;//speed, dierecion and head position of the bullet
	private Point pos;//Where the bullet is

	////////////////////////////////////////////////////////
	//the constants below are for the rotation/orientation//
	////////////////////////////////////////////////////////
	private final int RIGHT = 0;
	private final int LEFT = 1;
	private final int UP = 2;
	private final int DOWN = 3;
	
	
	///////////////////////////////////////////////////
	//these are the Bullet object constructor methods//
	///////////////////////////////////////////////////
	public Bullet(int size, int posX, int posY, int direction){
		this.jacket = new Rectangle ();
		if (size != 10){
			this.speed = 10;
		} else {
			this.speed = 5;
		}
		this.size = size;
		this.direction = direction;
		this.pos = new Point (posX,posY);
		this.headX = headX;
		this.headY = headY;
		this.jacket = new Rectangle ();
		
	}
	
	public Point getPos(){
		return pos;
	}
	
	public Rectangle getBullet(){
		return jacket;
	}
	
	//////////////////////////////////
	//this method creates the bullet//
	//////////////////////////////////
	public void makeBullet(){
		if (direction == UP){
			jacket = new Rectangle (pos.x - size/2, pos.y - size, size, 2*size);
			headX = pos.x - size/2;
			headY = pos.y - (int)(size * 1.5);
		} else if (direction == RIGHT) {
			jacket = new Rectangle (pos.x - size, pos.y - size/2, 2* size, size);
			headX = pos.x + size/2;
			headY = pos.y - size/2;
		} else if (direction == DOWN){
			jacket = new Rectangle (pos.x - size/2, pos.y - size, size, 2*size);
			headX = pos.x - size/2;
			headY = pos.y + size/2;
		} else if (direction == LEFT){
			jacket = new Rectangle (pos.x - size, pos.y - size/2, 2* size, size);
			headX = pos.x - (int)(size * 1.5);
			headY = pos.y - size/2;
		}
	}
		
	//////////////////////////////////////////////
	//method relating to the speed of the bullet//
	//////////////////////////////////////////////
	
	public void setSpeed(int newSpeed){
		speed = newSpeed;
	}
	
	public void moveBullet(){
		if (direction == UP){
			pos.y -= speed;
		} else if (direction == RIGHT){
			pos.x += speed;
		} else if  (direction == DOWN){
			pos.y += speed;
		} else if (direction == LEFT){
			pos.x -= speed;
		}
		
	}
	
	//////////////////////////////
	//methods to draw the bullet//
	//////////////////////////////
	public void drawBullet(Graphics g){
		if (direction == UP){
			jacket = new Rectangle (pos.x - size/2, pos.y - size, size, 2*size);
			headX = pos.x - size/2;
			headY = pos.y - (int)(size * 1.5);
		} else if (direction == RIGHT) {
			jacket = new Rectangle (pos.x - size, pos.y - size/2, 2* size, size);
			headX = pos.x + size/2;
			headY = pos.y - size/2;
		} else if (direction == DOWN){
			jacket = new Rectangle (pos.x - size/2, pos.y - size, size, 2*size);
			headX = pos.x - size/2;
			headY = pos.y + size/2;
		} else if (direction == LEFT){
			jacket = new Rectangle (pos.x - size, pos.y - size/2, 2* size, size);
			headX = pos.x - (int)(size * 1.5);
			headY = pos.y - size/2;
		}
		g.setColor(Color.DARK_GRAY);
		g.fillOval(headX,headY,size,size);
		g.setColor(Color.black);
		g.drawOval(headX,headY,size,size);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(jacket.x,jacket.y,jacket.width,jacket.height);
		g.setColor(Color.black);
		g.drawRect(jacket.x,jacket.y,jacket.width,jacket.height);
		
	
	}

	
}