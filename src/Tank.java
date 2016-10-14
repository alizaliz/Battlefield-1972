/* 
  * 
  *
  * author: Zain Ali 
  * 
  *
  * This class creates the Tank objects, also contains methods to move the tanks
  * It contains the methods to draw the tanks.
*/
import java.awt.*;
import java.awt.event.*;

public class Tank {
	
	private Point pos; //center of the tanks body
	private int speed, orientation, rotation, size, red, green, blue, explosionCount, bulletSize, turretX, turretY; //colour, size, level and direction values of tank and its turret and some bullet parameters
	private boolean fire, exploding, shouldCharge; //whether the tank is in firing/exploding
	private Rectangle body, turret, test; //rectangles around the tank
	private Bullet ammo;
	private Collision col;
	
	////////////////////////////////////////////////////////
	//the constants below are for the rotation/orientation//
	////////////////////////////////////////////////////////
	private final int RIGHT = 0;
	private final int LEFT = 1;
	private final int UP = 2;
	private final int DOWN = 3;
	
	/////////////////////////////////////////////////
	//these are the Tank object constructor methods//
	/////////////////////////////////////////////////
	public Tank( int speed, int posX, int posY, int size, int orientation, int rotation, int red, int green, int blue) {
		this.speed = speed;
		this.pos = new Point(posX,posY);
		this.size = size;
		this.orientation = orientation;
		this.rotation = rotation;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.body = new Rectangle();
		this.turret = new Rectangle();
		this.explosionCount = 0;
		this.exploding = false;
		this.fire = false;
		this.bulletSize = bulletSize;
		this.col = new Collision();
		
	}
	
	/////////////////////////////////////////////////////
	//these are the set/get methods for the tank object//
	/////////////////////////////////////////////////////
	
	public Point getPos(){
		return pos;
	}
	
	public void setPos(int x, int y){
		pos.x += x;
		pos.y += y;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int newSize) {
		size = newSize;
	}
	
	public int getOrientation() {
		return orientation;
	}
	
	public void setOrientation(int currentOrientation) {
		 orientation = currentOrientation;
	}
	
	public int getRotation (){
		return rotation;
	}
	
	public void setRotation(int currentRotation) {
		rotation = currentRotation;
	}
	
	public boolean getFire(){
		return fire;
	}
	
	public void setFire(boolean firing) {
		fire = firing;
	}
	
	public Rectangle getBody(){
		return body.getBounds();
	}
	
	public void setBody(int x, int y, int width, int height){
		body.setBounds(x, y, width, height);
	}
	
	public Rectangle getTurret(){
		return turret.getBounds();
	}
	
	public void setTurret(int x, int y, int width, int height){
		turret.setBounds(x, y, width, height);
	}
	
	public void setExploding( boolean state){
		exploding = state;
	}
	
	public boolean getExploding (){
		return exploding;
	}
	
	public boolean getExploded(){
		return 15 == explosionCount;
	}
	
	public void resetExplosion(){
		explosionCount = 0;
		exploding = false;
	}
	
	public boolean isExploding(){
		return exploding;
	}
	
	public void moveTankBullet(){
		ammo.moveBullet();
	}
	
	public Rectangle getTankBullet(){
		return ammo.getBullet();
	}
	
	///////////////////////////////////////////
	//these are the draw methods for the tank//
	///////////////////////////////////////////
	public void drawTank(Graphics g) {
		
		
		int r,gr,b,newSize,x,y;
		r = red;
		gr = green;
		b = blue;
		newSize = size;
		x = pos.x;
		y = pos.y;
	
		g.setColor(Color.black);
		if (orientation == UP){
			
			g.fillRect(x - 2 * size - 2, y - 3 * size + 2, 4* size + 4, 6 * size -4);
			body.setBounds(x - 2 * size - 2, y - 3 * size , 4* size + 4, 6 * size);
			for (int i = 0; i < size/2 ; i++) {
				g.setColor(new Color (r, gr, b));
				g.fillRect(x - 2 * size, y - 3 *newSize, 4 * size, 6 * newSize);
				r += 5;
				gr += 5;
				b += 5;
				newSize --;
			}
			g.setColor(Color.black);
			g.drawRect(x - 2 * size, y - 3 * size, 4* size, 6 * size);
			g.setColor(new Color (red, green, blue));
			g.fillRect(x - (int)(1.5 * size), y - (int)(2.5 * size), 3* size, 2 * size);
			g.setColor(Color.black);
			g.drawRect(x - (int)(1.5 * size), y - (int)(2.5 * size), 3* size, 2 * size);
			drawTurret(g, x , y + 1 * size, size, rotation, red, green, blue);
			
		} else if (orientation == DOWN){
			
			g.fillRect(x - 2 * size - 2, y - 3 * size + 2, 4* size + 4, 6 * size -4);
			body.setBounds(x - 2 * size - 2, y - 3 * size, 4* size + 4, 6 * size );
			for (int i = 0; i < size/2 ; i++) {
				g.setColor(new Color (r, gr, b));
				g.fillRect(x - 2 * size, y - 3 *newSize, 4 * size, 6 * newSize);
				r += 5;
				gr += 5;
				b += 5;
				newSize --;
			}
			g.setColor(Color.black);
			g.drawRect(x - 2 * size, y - 3 * size, 4* size, 6 * size);
			g.setColor(new Color (red, green, blue));
			g.fillRect(x - (int)(1.5 * size), y + (int)(0.5 * size), 3* size, 2 * size);
			g.setColor(Color.black);
			g.drawRect(x - (int)(1.5 * size), y + (int)(0.5 * size), 3* size, 2 * size);
			drawTurret(g, x , y - 1 * size, size, rotation, red, green, blue);
		
		} else if (orientation == RIGHT){
			
			g.fillRect(x - 3 * size + 2, y - 2 * size - 2, 6 * size -4, 4* size + 4);
			body.setBounds(x - 3 * size,y - 2 * size - 2, 6 * size , 4* size + 4);
			for (int i = 0; i < size/2 ; i++) {
				g.setColor(new Color (r, gr, b));
				g.fillRect(x - 3 *newSize, y - 2 * size , 6 * newSize, 4 * size);
				r += 5;
				gr += 5;
				b += 5;
				newSize --;
			}
			g.setColor(Color.black);
			g.drawRect(x - 3 * size, y - 2 * size, 6 * size, 4* size);
			g.setColor(new Color (red, green, blue));
			g.fillRect(x + (int)(0.5 * size), y - (int)(1.5 * size) , 2 * size, 3* size);
			g.setColor(Color.black);
			g.drawRect(x + (int)(0.5 * size), y - (int)(1.5 * size) , 2 * size, 3* size);
			drawTurret(g, x - 1 * size , y, size, rotation, red, green, blue);

		} else if (orientation == LEFT){
		
			g.fillRect(x - 3 * size + 2, y - 2 * size - 2, 6 * size -4, 4* size + 4);
			body.setBounds(x - 3 * size, y - 2 * size - 2, 6 * size , 4* size + 4);
			for (int i = 0; i < size/2 ; i++) {
				g.setColor(new Color (r, gr, b));
				g.fillRect(x - 3 *newSize, y - 2 * size , 6 * newSize, 4 * size);
				r += 5;
				gr += 5;
				b += 5;
				newSize --;
			}
			g.setColor(Color.black);
			g.drawRect(x - 3 * size, y - 2 * size, 6 * size, 4* size);
			g.setColor(new Color (red, green, blue));
			g.fillRect(x - (int)(2.5 * size), y - (int)(1.5 * size) , 2 * size, 3* size);
			g.setColor(Color.black);
			g.drawRect(x - (int)(2.5 * size), y - (int)(1.5 * size) , 2 * size, 3* size);
			drawTurret(g, x + 1 * size , y, size, rotation, red, green, blue);
			
		}
		if(exploding){
			drawExplosion(g, x - 3 * size - 2, y - 3 * size + 2, x + 3 * size + 2,  y + 3 * size - 2, size * 15);
			explosionCount ++;
		}
		if  (fire){
				ammo.drawBullet(g);
		}
	}
	
	private void drawTurret(Graphics g, int x, int y, int size, int rotation, int red, int green, int blue ) {
		int r,gr,b,newSize;
		r = red;
		gr = green;
		b = blue;
		newSize = size + size/10 ;
		bulletSize = 3*newSize/5;
		turretX = x;
		turretY = y;
		
		g.setColor(new Color (205, 205, 180));
		if (rotation == UP){
			if (!fire){
				ammo = new Bullet (bulletSize, x - 3 * newSize /10 + bulletSize/2, y - 4 * newSize + 1 - bulletSize/2, UP);
				ammo.makeBullet();
			}
			turret.setBounds(x - 3 * newSize /10, y - 4 * newSize + 1, 3 * newSize/5, 3 * newSize);
			g.fillRect(x - 3 * newSize /10, y - 4 * newSize + 1, 3 * newSize/5, 3 * newSize);
			g.setColor(Color.white);
			g.fillRect(x - newSize/10, y - 4 * newSize  + 1, newSize/5, 3 * newSize);
			g.setColor(Color.black);
			g.drawRect(x - 3 * newSize /10, y - 4 * newSize + 1, 3 * newSize/5, 3 * newSize);
			
		} else if (rotation == DOWN) {
			if (!fire){
				ammo = new Bullet (bulletSize, x - 3 * newSize /10 + bulletSize/2, y + 4 * newSize + 1 - bulletSize/2, DOWN);
				ammo.makeBullet();
			}
			turret.setBounds(x - 3 * newSize /10, y + newSize - 1, 3 * newSize/5, 3 * newSize);
			g.fillRect(x - 3 * newSize /10, y + newSize - 1, 3 * newSize/5, 3 * newSize);
			g.setColor(Color.white);
			g.fillRect(x - newSize/10, y + newSize - 1, newSize/5, 3 * newSize);
			g.setColor(Color.black);
			g.drawRect(x - 3 * newSize /10, y + newSize - 1, 3 * newSize/5, 3 * newSize);

		} else if (rotation == RIGHT) {
			if (!fire){
				ammo = new Bullet (bulletSize, x + 4* newSize - 1 + bulletSize,  y - 3 * newSize /10 + bulletSize/2 , RIGHT);
				ammo.makeBullet();
			}
			turret.setBounds(x + newSize - 1, y - 3 * newSize /10, 3 * newSize, 3 * newSize/5);
			g.fillRect(x + newSize - 1, y - 3 * newSize /10, 3 * newSize, 3 * newSize/5);
			g.setColor(Color.white);
			g.fillRect(x + newSize - 1, y - newSize/10, 3 * newSize, newSize/5);
			g.setColor(Color.black);
			g.drawRect(x + newSize - 1, y - 3 * newSize /10, 3 * newSize, 3 * newSize/5);
			
		} else if (rotation == LEFT) {
			if (!fire){
			ammo = new Bullet (bulletSize, x - 4 * newSize + 1 - bulletSize,  y - 3 * newSize /10 + bulletSize/2, LEFT);
			ammo.makeBullet();
			}
			turret.setBounds(x - 4 * newSize + 1, y - 3 * newSize /10, 3 * newSize, 3 * newSize/5);
			g.fillRect(x - 4 * newSize + 1, y - 3 * newSize /10, 3 * newSize, 3 * newSize/5);
			g.setColor(Color.white);
			g.fillRect(x - 4 * newSize + 1 , y - newSize/10, 3 * newSize, newSize/5);
			g.setColor(Color.black);
			g.drawRect(x - 4 * newSize + 1, y - 3 * newSize /10, 3 * newSize, 3 * newSize/5);
		}
		
		for (int i = 0; i < 20 ; i++) {
			g.setColor(new Color (r, gr, b));
			g.fillOval(x - newSize, y - newSize, 2 * newSize, 2 * newSize);
			r += 5;
			gr += 5;
			b += 5;
			newSize --;
		}
		g.setColor(Color.black);
		g.drawOval(x - (size + size/10), y - (size + size/10), 2 * (size + size/10), 2 * (size + size/10));
	}
	
	//this draws the explosion graphics
	private void drawExplosion(Graphics g, int lowx, int lowy, int highx, int highy,  int density){
		int x,y,r,gr,size,b, newSize;
		
		for(int i = 0; i < density; i++){
			x = ((int)(Math.random()*(highx - lowx +1) + lowx));
			y = ((int)(Math.random()*(highy - lowy +1) + lowy));
			size = ((int)(Math.random()*(9) + 1));
			newSize = size;
			g.setColor(new Color(255,215,0));
			g.fillOval(x - size, y - size, 2* size, 2 *size);
			r = 255;
			gr = 205;
			b = 0;
			for (int e = 0; e < 10 ; e++) {
				g.setColor(new Color (r, gr, b));
				g.fillOval(x - newSize, y - newSize, 2 * newSize, 2 * newSize);
				b += 5;
				gr += 5;
			
				newSize --;
			}
			g.setColor(new Color(184,134,11));
			g.drawOval(x - size, y - size, 2* size, 2 *size);
		}
	}
	
	///////////////////////////////////////////////////////////////
	//The methods below relate to the movement of the tank object//
	///////////////////////////////////////////////////////////////
	public void keyMove(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			test = new Rectangle (pos.x - 2 * size - 2, pos.y - 3 * size  , 4* size + 4, 6 * size);
			if (!col.checkBuildingCollision(test)){
				orientation = UP;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			test = new Rectangle (pos.x - 3 * size, pos.y - 2 * size - 2, 6 * size , 4* size + 4);
			if (!col.checkBuildingCollision(test)){
				orientation = RIGHT;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
				test = new Rectangle (pos.x - 2 * size - 2, pos.y - 3 * size, 4* size + 4, 6 * size );
			if (!col.checkBuildingCollision(test)){
				orientation = DOWN;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT){
				test = new Rectangle (pos.x - 3 * size, pos.y - 2 * size - 2, 6 * size , 4* size + 4);
			if (!col.checkBuildingCollision(test)){
				orientation = LEFT;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_W){
			test = new Rectangle (turretX - 3 * (size + size/10) /10, turretY - 4 * (size + size/10) + 1, 3 * (size + size/10)/5, 3 * (size + size/10));
			if (!col.checkBuildingCollision(test)){	
				rotation = (UP);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_D){
			test = new Rectangle (turretX + (size + size/10) - 1, turretY - 3 *(size + size/10) /10, 3 * (size + size/10), 3 * (size + size/10)/5);
			if (!col.checkBuildingCollision(test)){	
				rotation = (RIGHT);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_S){
			test = new Rectangle (turretX - 3 * (size + size/10) /10, turretY + (size + size/10) - 1, 3 * (size + size/10)/5, 3 * (size + size/10));
			if (!col.checkBuildingCollision(test)){	
				rotation = (DOWN);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_A){
			test = new Rectangle (turretX - 4 * (size + size/10) + 1, turretY - 3 * (size + size/10) /10, 3 * (size + size/10), 3 * (size + size/10)/5);
			if (!col.checkBuildingCollision(test)){	
				rotation = (LEFT);
			}
		} 
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			if(rotation == UP){
			}
		}
		test = new Rectangle ();
	}
	
	
	public void tankFire(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			fire = true;
		}
	}
	
	public void move(int direction){
		if(!exploding){	
			if(direction == UP){
				test = new Rectangle (pos.x - 2 * size - 2, pos.y - speed - 3 * size -1 , 4* size + 4, 6 * size);
				if (!col.checkBuildingCollision(test)){
					pos.y -= speed;
				}
			} else if (direction == RIGHT){
				test = new Rectangle (pos.x + speed - 3 * size +1 , pos.y - 2 * size - 2, 6 * size , 4* size + 4);
				if (!col.checkBuildingCollision(test)){
					pos.x += speed;				
				}
			}else if (direction == DOWN){
				test = new Rectangle (pos.x - 2 * size - 2, pos.y + speed + 1 - 3 * size, 4* size + 4, 6 * size );
				if (!col.checkBuildingCollision(test)){
					pos.y += speed;
				}
			}else if (direction == LEFT){
				test = new Rectangle (pos.x - speed - 3 * size -1, pos.y - 2 * size - 2, 6 * size , 4* size + 4);
				if (!col.checkBuildingCollision(test)){
					pos.x -= speed;
				}
			}
			test = new Rectangle ();
		}
	}
	
	public void tmove(int direction){
		if(direction == UP){
			pos.y -= speed;
		} else if (direction == RIGHT){
			pos.x += speed;
		}else if (direction == DOWN){
			pos.y += speed;
		}else if (direction == LEFT){
			pos.x -= speed;
		}
	}
	
}