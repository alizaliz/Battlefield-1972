/* 
  * 
  * 
  * author: Zain Ali 1298523
  * 
  *
  * This class contains a bunch of methods used for calculation collisions of different things.
  * 
  * 
*/

import java.awt.*;

public class Collision{
	
	private Rectangle barrack1, barrack2a, barrack2b, gameArea; //some objects in the game field

	public Collision(){
		this.barrack1 = new Rectangle(570,290,60,220);
		this.barrack2a = new Rectangle(230,325,220,60);
		this.barrack2b = new Rectangle(390,185,60,200);
		this.gameArea= new Rectangle(10,65,780,525);
	}
	
	////////////////////////////////////////////////////////////////////
	//the methods below check for collisions between different objects//
	////////////////////////////////////////////////////////////////////
	public void checkTankCollision (Tank one, Tank two){
		if( (one.getBody()).intersects(two.getBody()) || (one.getBody()).intersects(two.getTurret()) || (one.getTurret()).intersects(two.getBody()) ){
			one.setExploding(true);
			two.setExploding(true);
		}
	}
	
	public boolean checkBuildingCollision (Rectangle one){
		if (one.intersects(barrack1) || one.intersects(barrack2a) || one.intersects(barrack2b) || !gameArea.contains(one)){
			return true;
		}
		return false;
	}
	
	public void checkBulletCollision (Tank one, Tank two){
		if ((one.getTankBullet()).intersects(two.getBody())){
			two.setExploding(true);
			one.setFire(false);
		} 
		if ((two.getTankBullet()).intersects(one.getBody())){
			one.setExploding(true);
			two.setFire(false);
		}
		if ((one.getTankBullet()).intersects(two.getTankBullet())){
			one.setFire(false);
			two.setFire(false);
		}
		if ((one.getTankBullet()).intersects(barrack1) || (one.getTankBullet()).intersects(barrack2a) || (one.getTankBullet()).intersects(barrack2b) || !gameArea.contains((one.getTankBullet()))){
			one.setFire(false);
		}
		if ((two.getTankBullet()).intersects(barrack1) || (two.getTankBullet()).intersects(barrack2a) || (two.getTankBullet()).intersects(barrack2b) || !gameArea.contains((two.getTankBullet()))){
			two.setFire(false);
		}
		
	}
	

}	