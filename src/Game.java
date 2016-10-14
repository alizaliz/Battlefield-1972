/* 
  * 
  * 
  * author: Zain Ali 1298523
  * 
  *
  * This class creates a game in which a user can play the game. It holds the score and lives.
  * It runs as long as the user has three lives or all enemies have not been defeated.
  * 
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
	
	//game parameters
	private int score, lives, level;
	private Screen gameScreen;
	private Tank user, level1, level2, level3, level4, level5a, level5b, level6, level7a, level7b;
	private AI ai;
	private Collision col;
	private boolean gameRunning;
	////////////////////////////////////////////////////////
	//the constants below are for the rotation/orientation//
	////////////////////////////////////////////////////////
	private final int RIGHT = 0;
	private final int LEFT = 1;
	private final int UP = 2;
	private final int DOWN = 3;
	
	public Game(){
		this.score = -1;
		this.lives = 3;
		this.gameScreen = new Screen();
		this.user = new Tank(2, 80, 540, 10, RIGHT, RIGHT, 160,160, 0);
		this.level1 = new Tank(1, 720, 115, 10, LEFT, LEFT, (int)(Math.random()*161),(int)(Math.random()*161), (int)(Math.random()*161));
		this.level2 = new Tank(2, 720, 115, 10, LEFT, LEFT, (int)(Math.random()*161),(int)(Math.random()*161), (int)(Math.random()*161));
		this.level3 = new Tank(3, 720, 115, 5, LEFT, LEFT, (int)(Math.random()*161),(int)(Math.random()*161), (int)(Math.random()*161));
		this.level4 = new Tank(2, 720, 115, 13, LEFT, LEFT, (int)(Math.random()*161),(int)(Math.random()*161), (int)(Math.random()*161));
		this.level5a = new Tank(2, 720, 115, 7, LEFT, LEFT, (int)(Math.random()*161),(int)(Math.random()*161), (int)(Math.random()*161));
		this.level5b = new Tank(2, 80,  540, 7, RIGHT, RIGHT, (int)(Math.random()*161),(int)(Math.random()*161), (int)(Math.random()*161));
		this.level6 = new Tank(3, 720, 115, 9, LEFT, LEFT, (int)(Math.random()*161),(int)(Math.random()*161), (int)(Math.random()*161));
		this.level7a = new Tank(3, 80,  540, 5, RIGHT, RIGHT, (int)(Math.random()*161),(int)(Math.random()*161), (int)(Math.random()*161));
		this.level7b = new Tank(3, 720, 115, 9, LEFT, LEFT, (int)(Math.random()*161),(int)(Math.random()*161), (int)(Math.random()*161));
		this.gameRunning = false;
		this.col = new Collision();
		this.ai = new AI();
		this.level = 1;
		
	}
	
	///////////////////////////
	//method to draw the game//
	///////////////////////////
	public void drawGame (Graphics g){
		gameScreen.drawScreen(g, score, lives );
		if (gameScreen.getScreenNumber() == 3){
			g.setFont(new Font("Sans-serif",5, 30));
			g.drawString("LEVEL: " + level, 15,40);
			if (!user.getExploded()){
				user.drawTank(g);
			}
			if (!level1.getExploded() && level == 1){
				level1.drawTank(g);
			}
			if (!level2.getExploded() && level == 2){
				level2.drawTank(g);
			}
			if (!level3.getExploded() && level == 3){
				level3.drawTank(g);
			}
			if (!level4.getExploded() && level == 4){
				level4.drawTank(g);
			}
			if (!level5a.getExploded() && level == 5){
				level5a.drawTank(g);
			}
			if (!level5b.getExploded() && level == 5){
				level5b.drawTank(g);
			}
			if (!level6.getExploded() && level == 6){
				level6.drawTank(g);
			}
			if (!level7a.getExploded() && level == 7){
				level7a.drawTank(g);
			}
			if (!level7b.getExploded() && level == 7){
				level7b.drawTank(g);
			}
		}
		if (gameScreen.getScreenNumber() == 4){
			if (!user.getExploded()){
				g.setFont(new Font("Monospaced",5, 70));
				g.setColor(Color.red);
				g.drawString("VICTORY!!",210,410);
			}
		}
	}
	
	////////////////////////////////////////////////
	//method that takes care of  and runs the game//
	////////////////////////////////////////////////
	public void actionHandler(Timer gameTimer){
		if (gameRunning){
			user.move(user.getOrientation());
			user.moveTankBullet();
			if (user.isExploding() && lives !=0){
				user.resetExplosion();
				lives --;
			}
			if (level == 1){
				ai.level1(level1,user);
				level1.moveTankBullet();
				col.checkTankCollision(user, level1);
				col.checkBulletCollision (user, level1);
				if (level1.getExploded()){
					level = 2;
					score += 100;
				}
			} else if (level == 2){
				ai.level2(level2,user);
				level2.moveTankBullet();
				col.checkTankCollision(user, level2);
				col.checkBulletCollision (user, level2);
				if (level2.getExploded()){
					level = 3;
					score += 150;
				}
			} else if (level == 3){
				ai.level3(level3,user);
				level3.moveTankBullet();
				col.checkTankCollision(user, level3);
				col.checkBulletCollision (user, level3);
				if (level3.getExploded()){
					level = 4;
					score += 200;
				}
			} else if (level == 4){
				ai.level4(level4,user);
				level4.moveTankBullet();
				col.checkTankCollision(user, level4);
				col.checkBulletCollision (user, level4);
				if (level4.getExploded()){
					level = 5;
					score += 250;
				}
			} else if (level == 5){
				if(!level5a.getExploded()){
					ai.level5(level5a,user);
					level5a.moveTankBullet();
					col.checkTankCollision(user, level5a);
					col.checkBulletCollision (user, level5a);
				}
				if(!level5b.getExploded()){
					ai.level5(level5b,user);
					level5b.moveTankBullet();
					col.checkTankCollision(user, level5b);
					col.checkBulletCollision (user, level5b);
				}
				if (level5a.getExploded() && level5b.getExploded()){
					level = 6;
					score += 1000;
				}
			} else if (level == 6){
				ai.level5(level6,user);
				level6.moveTankBullet();
				col.checkTankCollision(user, level6);
				col.checkBulletCollision (user, level6);
				if (level6.getExploded()){
					level = 7;
					score += 2050;
				}
			} else if (level == 7){
				if(!level7a.getExploded()){
					ai.level5(level7a,user);
					level7a.moveTankBullet();
					col.checkTankCollision(user, level7a);
					col.checkBulletCollision (user, level7a);
				}
				if(!level7b.getExploded()){
					ai.level5(level7b,user);
					level7b.moveTankBullet();
					col.checkTankCollision(user, level7b);
					col.checkBulletCollision (user, level7b);
				}
				if (level7a.getExploded() && level7b.getExploded()){
					level = 8;
					score += 1000;
				}
			}
			if (user.getExploded() || level == 8){
				gameScreen.setScreenNumber(4);
				setScore();
				gameTimer.stop();
			}
		}
	}

	/////////////////////////////////////////
	//method for calculating the game score//
	/////////////////////////////////////////
	 public void setScore(){
		if (!user.getExploded()){
			score += gameScreen.getTimeScore() * lives;
		}
	}
	
	public int getScore(){
		return score;
	}
	
	//////////////////////////
	//methods for key events//
	//////////////////////////
	public void keyPHandler(KeyEvent e, Timer gameTimer, Timer titleTimer){
		if (gameScreen.getScreenNumber() == 3){
			user.keyMove(e);
			gameTimer.start();
		}
		if (gameScreen.getScreenNumber() == 0){
			titleTimer.start();
		}
		if (gameScreen.getScreenNumber() == 1){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				titleTimer.stop();
			}					
		}
		if (gameScreen.getScreenNumber() == 3){
			gameRunning = true;
		}
		gameScreen.drawWhichScreen(e);
	}
	
	public void keyRHandler(KeyEvent e){
		if (gameRunning){
			user.tankFire(e);
		}
	}

}