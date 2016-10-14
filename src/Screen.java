/* 
  * 
  * 
  * author: Zain Ali 1298523
  * 
  *
  * This class creates the title screens and game background.
  * It contains the methods to draw the screens/background.
*/

import java.awt.*;
import java.awt.event.*;

public class Screen {
	
	private Tank lifeTank, lifeTank2, lifeTank3, titleTank1, titleTank2, titleTank3, titleTank4;
	private Rectangle barrack1, barrack2a, barrack2b, gameArea;
	private AI introAI;
	private Point [] bushes;
	private int screenNumber, timeMins, timeSecs, timeConstant;
	private Game currentGame;
	
	//tank constants
	private final int RIGHT = 0;
	private final int LEFT = 1;
	private final int UP = 2;
	private final int DOWN = 3; 

	
	public Screen(){
		
		this.lifeTank = new Tank( 0, 770, 30, 5, DOWN, DOWN,  160,160, 0);
		this.lifeTank2 = new Tank( 0, 740, 30, 5, DOWN, DOWN,  160, 160, 0);
		this.lifeTank3 = new Tank( 0, 710, 30, 5, DOWN, DOWN,  160, 160, 0);
		this.titleTank1 = new Tank( 3, 760, 35, 10, LEFT, LEFT, 120, 80, 0);
		this.titleTank2 = new Tank( 3, 43, 35, 10, DOWN, DOWN, 120, 80, 0);
		this.titleTank3 = new Tank( 3, 40, 398, 10, RIGHT, RIGHT, 120, 80, 0);
		this.titleTank4 = new Tank( 3, 757, 401, 10, UP, UP, 120, 80, 0);
		this.barrack1 = new Rectangle(570,290,60,220);
		this.barrack2a = new Rectangle(230,325,220,60);
		this.barrack2b = new Rectangle(390,185,60,200);
		this.gameArea= new Rectangle(10,65,780,525);
		this.screenNumber = 0;
		this.introAI = new AI();
		this.timeMins = 5;
		this.timeSecs = 0;
		this.timeConstant = 50;
	
	}
	
	//////////////////////////////////////////
	//The get and set methods for this class//
	//////////////////////////////////////////
	
	public Rectangle getbarrack1(){
		return barrack1;
	}
	
	public Rectangle getbarrack2a(){
		return barrack2a;
	}	
	
	public Rectangle getbarrack2b(){
		return barrack2b;
	}
	
	public int getScreenNumber(){
		return screenNumber;
	}
	
	public int getTimeScore(){
		return timeMins * 50 + timeSecs * 5 + 1;
	}
	
	public void setScreenNumber(int number){
		screenNumber = number;
	}
	
	////////////////////////////////////////
	//Methods for drawing the screen class//
	////////////////////////////////////////
	public void drawWhichScreen(KeyEvent e){
		if (screenNumber == 0){
			screenNumber = 1;
		} else if (screenNumber == 1){
			if (e.getKeyCode() == KeyEvent.VK_I){
				screenNumber = 2;
			} else if (e.getKeyCode() == KeyEvent.VK_ENTER){
				screenNumber = 3;
			}
		} else if (screenNumber == 2){
			screenNumber = 1;
		}
	}
	
	///////////////////////////////////////////
	// The main method for drawing the screen//
	///////////////////////////////////////////
	public void drawScreen(Graphics g, int gameScore, int lives){
	
		if (screenNumber == 0){
			drawFirstTitleScreen(g);
		} else if (screenNumber == 1){
			drawSecondTitleScreen(g);
		} else if(screenNumber == 2){
			drawInstructionScreen(g);
		} else if (screenNumber == 3){
			drawGameScreen(g, lives);
		} else if (screenNumber == 4){
			drawGameOverScreen(g, gameScore);
		}
	}
	
	////////////////////////////////////////////
	//This method draws the first title screen//
	////////////////////////////////////////////
	public void drawFirstTitleScreen(Graphics g){
		g.setFont(new Font("Monospaced",5, 70));
		g.setColor(Color.gray);
		g.drawString("BATTLEFIELD", 180,100);
		g.setFont(new Font("Monospaced",5, 50));
		g.drawString("1972", 340,140);
		g.setFont(new Font("Monospaced",5, 20));
		g.setColor(Color.white);
		g.drawString("by Zain Ali", 342,170);
		g.setFont(new Font("Monospaced",2, 20));
		g.drawString("Press a key to start...", 260,500);
		
	}

	/////////////////////////////////////////////
	//This method draws the second title screen//
	/////////////////////////////////////////////
	public void drawSecondTitleScreen(Graphics g){
	
		g.setFont(new Font("Monospaced",5, 70));
		g.setColor(Color.gray);
		g.drawString("BATTLEFIELD", 180,100);
		g.setFont(new Font("Monospaced",5, 50));
		g.drawString("1972", 340,140);
		g.setFont(new Font("Monospaced",5, 20));
		g.setColor(Color.white);
		g.drawString("by Zain Ali", 342,170);
		g.setFont(new Font("Monospaced",5, 20));
		g.drawString("INSTRUCTIONS:", 270,300);
		g.drawString("PLAY:", 300,330);
		g.setFont(new Font("Monospaced",2, 20));
		g.drawString("PRESS [I]", 430,300);
		g.drawString("PRESS [ENTER]", 360,330);
		introAI.level0(titleTank1);
		titleTank1.drawTank(g);
		introAI.level0(titleTank2);
		titleTank2.drawTank(g);
		introAI.level0(titleTank3);
		titleTank3.drawTank(g);
		introAI.level0(titleTank4);
		titleTank4.drawTank(g);

	}
	
	/////////////////////////////////////
	//This draws the instruction screen//
	/////////////////////////////////////
	public void drawInstructionScreen(Graphics g){
		g.setFont(new Font("Monospaced",5, 40));
		g.setColor(Color.gray);
		g.drawString("INSTRUCTIONS", 250,50);
		g.drawString("GOAL", 350,230);
		g.drawString("TIPS", 350,370);
		g.setColor(Color.white);
		g.setFont(new Font("Monospaced",2, 20));
		g.drawString("Use the arrow keys to navigate the tank.", 165,90);
		g.drawString("Use the W,A,S and D keys to rotate the Tank's gun turret.", 50,130);
		g.drawString("Hold and release the space bar to fire.", 165,170);
		g.drawString(" Destroy all the enemy tanks as fast as you can to get to", 50,270);
		g.drawString("get the best score. Enemy difficulty increases with level.", 50,310);
		g.drawString("Keep check of your tanks turning radius (including the turret).", 30,410);
		g.drawString("If you crash into another Tank your Tank loses all lives.", 60,450);
		g.drawString(" Make use of the strong barracks buildings as cover.", 85,490);
		g.drawString("You can only fire one bullet at a time.", 145,530);
		g.setFont(new Font("Monospaced",2, 15));
		g.drawString("Press any key to return...", 280,580);
	
	}
		
	/////////////////////////////////////////////////////
	//This method draws the main game screen background//
	////////////////////////////////////////////////////
	public void drawGameScreen(Graphics g, int lives){ 

		//the upper display
		g.setColor(Color.black);
		g.fillRect(5,5,790,50);
		g.setColor(Color.white);
		g.fillRect(10,10,780,40);
		g.setColor(Color.white);
		g.drawRect(5,5,790,50);
		g.setColor(Color.black);
		g.setFont(new Font("Sans-serif",5, 30));	
		g.drawString("TIME: " + timeDisplay(), 300,40);
		g.drawString("LIVES: ", 600,40);
		
		if (lives > 0){
			lifeTank.drawTank(g);
			if (lives > 1) {
				lifeTank2.drawTank(g);
				if (lives > 2){
					lifeTank3.drawTank(g);
				}
			}
			
		}
		
		
		//the main game area border
		g.setColor(Color.gray);
		g.fillRect(5,60,790,535);
		g.setColor(Color.white);
		g.drawRect(5,60,790,535);
			
		//the game area
		g.setColor(new Color(188,238,104));
		g.fillRect(10,65,780,525);
		g.setColor(new Color(162,205,90));
		g.fillRect(30,510,100,60);
		g.fillRect(670,85,100,60);
		
		drawTerrain(g);
		
		//final black frame
		g.setColor(Color.black);
		g.drawRect(10,65,780,525);
					
	}
	
	//////////////////////////////////////////
	//this method draws the game over screen//
	//////////////////////////////////////////
	public void drawGameOverScreen(Graphics g, int gameScore){
		g.setFont(new Font("Monospaced",5, 70));
		g.setColor(Color.red);
		g.drawString("GAME OVER!",190,200);
		g.setFont(new Font("Monospaced",5, 50));
		g.setColor(Color.white);
		g.drawString("SCORE:" + gameScore, 230,300);
	}
		
	
	/////////////////////////////////////////////////////////////
	//draws the terrain, such as the road, buildings and bushes//
	/////////////////////////////////////////////////////////////
	private void drawTerrain(Graphics g){
	
	//polygon drawing variables
		Point [] road, roofTri1a, roofTri1b, roofTri2a, roofTri2b, roofTrap1a, roofTrap1b, roofTrap2a, roofTrap2b, roofTrap2c, roofTrap2d;
		int [] roadX, roofTri1aX, roofTri1bX, roofTri2aX, roofTri2bX, roofTrap1aX, roofTrap1bX, roofTrap2aX, roofTrap2bX, roofTrap2cX, roofTrap2dX;
		int [] roadY, roofTri1aY, roofTri1bY, roofTri2aY, roofTri2bY, roofTrap1aY, roofTrap1bY, roofTrap2aY, roofTrap2bY, roofTrap2cY, roofTrap2dY;
		
		road = new Point [12];
		roadX = new int [12];
		roadY = new int [12];

		roofTri1a = new Point [3];
		roofTri1aX = new int [3];
		roofTri1aY = new int [3];
		
		roofTri1b = new Point [3];
		roofTri1bX = new int [3];
		roofTri1bY = new int [3];

		roofTri2a = new Point [3];
		roofTri2aX = new int [3];
		roofTri2aY = new int [3];
		
		roofTri2b = new Point [3];
		roofTri2bX = new int [3];
		roofTri2bY = new int [3];		


		roofTrap1a = new Point [4]; 
		roofTrap1aX = new int [4];
		roofTrap1aY = new int [4];
		
		roofTrap1b = new Point [4]; 
		roofTrap1bX = new int [4];
		roofTrap1bY = new int [4];
		
		roofTrap2a = new Point [4];
		roofTrap2aX = new int [4]; 
		roofTrap2aY = new int [4];
		
		roofTrap2b = new Point [4];
		roofTrap2bX = new int [4];
		roofTrap2bY = new int [4];
		
		roofTrap2c = new Point [4]; 
		roofTrap2cX = new int [4]; 
		roofTrap2cY = new int [4];
		
		roofTrap2d = new Point [4];
		roofTrap2dX = new int [4]; 
		roofTrap2dY = new int [4];
		
		road [0] = new Point(10, 395); 
		road [1] = new Point(460,395); 
		road [2] = new Point(460,65);
		road [3] = new Point(560,65);
		road [4] = new Point(560,230);
		road [5] = new Point(790,230);
		road [6] = new Point(790,280);
		road [7] = new Point(560,280);
		road [8] = new Point(560,590);
		road [9] = new Point(460,590);
		road[10] = new Point(460,445);
		road[11] = new Point(10,445);
		for ( int i = 0; i <road.length; i++){
			roadX[i] = road[i].x;
			roadY[i] = road[i].y;
		}
		
		roofTri1a [0] = new Point(570,290);
		roofTri1a [1] = new Point(600,320);		
		roofTri1a [2] = new Point(630,290);
		for ( int i = 0; i <roofTri1a.length; i++){
			roofTri1aX[i] = roofTri1a[i].x;
			roofTri1aY[i] = roofTri1a[i].y;
		}
		
		roofTri1b [0] = new Point(570,510);
		roofTri1b [1] = new Point(600,480);		
		roofTri1b [2] = new Point(630,510);
		for ( int i = 0; i <roofTri1b.length; i++){
			roofTri1bX[i] = roofTri1b[i].x;
			roofTri1bY[i] = roofTri1b[i].y;
		}		
		
		roofTri2a [0] = new Point(230,325);
		roofTri2a [1] = new Point(260,355);		
		roofTri2a [2] = new Point(230,385);
		for ( int i = 0; i <roofTri2a.length; i++){
			roofTri2aX[i] = roofTri2a[i].x;
			roofTri2aY[i] = roofTri2a[i].y;
		}		
		
		roofTri2b [0] = new Point(390,185);
		roofTri2b [1] = new Point(420,215);		
		roofTri2b [2] = new Point(450,185);
		for ( int i = 0; i <roofTri2a.length; i++){
			roofTri2bX[i] = roofTri2b[i].x;
			roofTri2bY[i] = roofTri2b[i].y;
		}

		roofTrap1a [0] = new Point (630,290);	
		roofTrap1a [1] = new Point (630,510);	
		roofTrap1a [2] = new Point (600,480);	
		roofTrap1a [3] = new Point (600,320);	
		for ( int i = 0; i <roofTrap1a.length; i++){
			roofTrap1aX[i] = roofTrap1a[i].x;
			roofTrap1aY[i] = roofTrap1a[i].y;
		}

		roofTrap1b [0] = new Point (570,290);	
		roofTrap1b [1] = new Point (570,510);	
		roofTrap1b [2] = new Point (600,480);	
		roofTrap1b [3] = new Point (600,320);	
		for ( int i = 0; i <roofTrap1b.length; i++){
			roofTrap1bX[i] = roofTrap1b[i].x;
			roofTrap1bY[i] = roofTrap1b[i].y;
		}
		
		roofTrap2a [0] = new Point (450,185);	
		roofTrap2a [1] = new Point (450,385);	
		roofTrap2a [2] = new Point (420,355);	
		roofTrap2a [3] = new Point (420,215);	
		for ( int i = 0; i <roofTrap2a.length; i++){
			roofTrap2aX[i] = roofTrap2a[i].x;
			roofTrap2aY[i] = roofTrap2a[i].y;
		}		
		
		roofTrap2b [0] = new Point (390,185);	
		roofTrap2b [1] = new Point (390,325);	
		roofTrap2b [2] = new Point (420,355);	
		roofTrap2b [3] = new Point (420,215);	
		for ( int i = 0; i <roofTrap2b.length; i++){
			roofTrap2bX[i] = roofTrap2b[i].x;
			roofTrap2bY[i] = roofTrap2b[i].y;
		}
		
		roofTrap2c [0] = new Point (230,325);	
		roofTrap2c [1] = new Point (390,325);	
		roofTrap2c [2] = new Point (420,355);	
		roofTrap2c [3] = new Point (260,355);	
		for ( int i = 0; i <roofTrap2c.length; i++){
			roofTrap2cX[i] = roofTrap2c[i].x;
			roofTrap2cY[i] = roofTrap2c[i].y;
		}
		
		roofTrap2d [0] = new Point (260,355);	
		roofTrap2d [1] = new Point (420,355);	
		roofTrap2d [2] = new Point (450,385);	
		roofTrap2d [3] = new Point (230,385);	
		for ( int i = 0; i <roofTrap2d.length; i++){
			roofTrap2dX[i] = roofTrap2d[i].x;
			roofTrap2dY[i] = roofTrap2d[i].y;
		}
		
		//drawing all the items
		g.setColor(new Color(110,139,034));
		g.drawLine(30,510,70,510);
		g.drawLine(30,570,70,570);
		g.drawLine(30,570,30,550);
		g.drawLine(30,510,30,530);
		
		g.drawLine(130,510,90,510);
		g.drawLine(130,570,130,550);
		g.drawLine(130,570,90,570);
		g.drawLine(130,510,130,530);
		
		g.drawLine(670,85,710,85);
		g.drawLine(670,85,670,105);
		g.drawLine(670,145,670,125);
		g.drawLine(670,145,710,145);
		
		g.drawLine(770,85,730,85);
		g.drawLine(770,85,770,105);
		g.drawLine(770,145,730,145);
		g.drawLine(770,145,770,125);
		
		g.setColor(new Color(238,221,130));
		g.fillPolygon(roadX,roadY,road.length);
		
		g.setColor(new Color(135,135,135));
		g.fillPolygon(roofTri1aX,roofTri1aY,roofTri1a.length);
		g.fillPolygon(roofTri2bX,roofTri2bY,roofTri2b.length);
		g.fillPolygon(roofTrap2cX,roofTrap2cY,roofTrap2c.length);
		
		g.setColor(new Color(148,148,148));
		g.fillPolygon(roofTri2aX,roofTri2aY,roofTri2a.length);
		g.fillPolygon(roofTrap1bX,roofTrap1bY,roofTrap1b.length);
		g.fillPolygon(roofTrap2bX,roofTrap2bY,roofTrap2b.length);
		
		g.setColor(new Color(161,161,161));
		g.fillPolygon(roofTri1bX,roofTri1bY,roofTri1b.length);
		g.fillPolygon(roofTrap2dX,roofTrap2dY,roofTrap2d.length);
		
		
		g.setColor(new Color(173,173,173));
		g.fillPolygon(roofTrap1aX,roofTrap1aY,roofTrap1a.length);
		g.fillPolygon(roofTrap2aX,roofTrap2aY,roofTrap2a.length);
		
		g.setColor(Color.black);
		g.drawPolygon(roadX,roadY,road.length);
		g.drawPolygon(roofTri1aX,roofTri1aY,roofTri1a.length);
		g.drawPolygon(roofTri1bX,roofTri1bY,roofTri1b.length);
		g.drawPolygon(roofTri2aX,roofTri2aY,roofTri2a.length);
		g.drawPolygon(roofTri2bX,roofTri2bY,roofTri2b.length);
		g.drawPolygon(roofTrap1aX,roofTrap1aY,roofTrap1a.length);
		g.drawPolygon(roofTrap1bX,roofTrap1bY,roofTrap1b.length);
		g.drawPolygon(roofTrap2aX,roofTrap2aY,roofTrap2a.length);
		g.drawPolygon(roofTrap2bX,roofTrap2bY,roofTrap2b.length);
		g.drawPolygon(roofTrap2cX,roofTrap2cY,roofTrap2c.length);
		g.drawPolygon(roofTrap2dX,roofTrap2dY,roofTrap2d.length);
		

	}
	
	//draws some bushy bushes
	private void drawBush(Graphics g, int lowx, int lowy, int highx, int highy,  int density){
		int x,y,size,r,gr,b, newSize;
		
		this.bushes = new Point [density];
		
		for(int i = 0; i < density; i++){
			x = ((int)(Math.random()*(highx - lowx +1) + lowx));
			y = ((int)(Math.random()*(highy - lowy +1) + lowy));
			size = ((int)(Math.random()*(9) + 1));
			newSize = size;
			g.setColor(new Color(255,215,0));
			g.fillOval(x - size, y - size, 2* size, 2 *size);
			r = 205;
			gr = 205;
			b = 0;
			for (int e = 0; e < 10 ; e++) {
				g.setColor(new Color (r, gr, b));
				g.fillOval(x - newSize, y - newSize, 2 * newSize, 2 * newSize);
				r += 5;
				gr += 5;
				b += 5;
				newSize --;
			}
			g.setColor(new Color(255,255,0));
			g.drawOval(x - size, y - size, 2* size, 2 *size);
			bushes[i] = new Point(x,y);
		}
	}
		
	public String timeDisplay(){
		String time;
		time = "";
		timeConstant --;
		if (timeConstant == 0){
			if (!(timeMins == 0)){
				if (!(timeSecs == 0)){
					timeSecs --;
				} else if (timeSecs == 0){
					timeMins --;
					timeSecs = 59;
				}
			} else if (timeMins == 0){
				screenNumber = 4;
			}
			timeConstant = 50;
		}
		if  (timeSecs >= 10){
			time = "" + timeMins + ":" + timeSecs;
		} else {
			time = "" + timeMins + ":" + "0" + timeSecs;
		}
	return time;		
	}
}