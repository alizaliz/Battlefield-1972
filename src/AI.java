/* 
  * 
  * 
  * author: Zain Ali 1298523
  * 
  *
  * This class creates the AI algorythms the computer controlled Tank objexts follow,
  * It calls the methods to move the tanks.
*/
import java.awt.*;

public class AI {

	private Rectangle one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen; 

	////////////////////////////////////////////////////////
	//the constants below are for the rotation/orientation//
	////////////////////////////////////////////////////////
	private final int RIGHT = 0;
	private final int LEFT = 1;
	private final int UP = 2;
	private final int DOWN = 3;
	
	public AI(){
		this.one = new Rectangle (718,113,4,4);
		this.two = new Rectangle (718,258,4,4);
		this.three = new Rectangle (718,538,4,4);
		this.four = new Rectangle (498,538,4,4);
		this.five = new Rectangle (498,423,4,4);
		this.six = new Rectangle (498,113,4,4);
		this.seven = new Rectangle (328,113,4,4);
		this.eight = new Rectangle (328,293,4,4);
		this.nine = new Rectangle (78,113,4,4);
		this.ten = new Rectangle (78,293,4,4);
		this.eleven = new Rectangle (78,423,4,4);
		this.twelve = new Rectangle (78,538,4,4);
		this.thirteen = new Rectangle (498,258,4,4);
	}
	
	/////////////////////////////////////////////////////
	//The algorythms for all the different levels of AI//
	/////////////////////////////////////////////////////
	public void level0(Tank t){
		int topBorder = 35;
		int rightBorder = 760;
		int leftBorder = 40;
		int bottomBorder = 401;
		if ((t.getPos()).y == topBorder){
			t.tmove(LEFT);
			t.setOrientation(LEFT);
			t.setRotation(LEFT);
		} 
		if ((t.getPos()).x == leftBorder){
			t.tmove(DOWN);
			t.setOrientation(DOWN);
			t.setRotation(DOWN);
		} 
		if ((t.getPos()).y == bottomBorder){
			t.tmove(RIGHT);
			t.setOrientation(RIGHT);
			t.setRotation(RIGHT);
		} 
		if ((t.getPos()).x == rightBorder){
			t.tmove(UP);
			t.setOrientation(UP);
			t.setRotation(UP);
		}
	}
	
	public void level1(Tank t, Tank user){
		if(!t.getExploding()){	
			if(!t.getFire()){
				if((t.getPos()).y <= (user.getPos()).y  + 50 &&(t.getPos()).y  >= (user.getPos()).y - 50 || (t.getPos()).x  >= (user.getPos()).x - 50&& (t.getPos()).x <= (user.getPos()).x + 50 ){
					t.setFire(true);
				}
			}
			if (one.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(DOWN);
			} 
			if ((nine.contains(t.getPos()))){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(RIGHT);
			} 
			if (twelve.contains(t.getPos())){
				t.tmove(RIGHT);
				t.setOrientation(RIGHT);
				t.setRotation(UP);
			} 
			if (four.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(LEFT);
			}
			t.move(t.getOrientation());
		}
	}
	
	public void level2(Tank t, Tank user){
		if(!t.getExploding()){
			if(!t.getFire()){
				if((t.getPos()).y <= (user.getPos()).y  + 50 &&(t.getPos()).y  >= (user.getPos()).y - 50 || (t.getPos()).x  >= (user.getPos()).x - 50&& (t.getPos()).x <= (user.getPos()).x + 50 ){
					t.setFire(true);
				}
				}
			if (one.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(DOWN);
			} 
			if (six.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(DOWN);
			} 
			if (thirteen.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(LEFT);
			} 
			if (four.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(UP);
			} 
			if (twelve.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(RIGHT);
			} 
			if (nine.contains(t.getPos())){
				t.tmove(RIGHT);
				t.setOrientation(RIGHT);
				t.setRotation(DOWN);
			} 
			t.move(t.getOrientation());
		}
	}
	
	public void level3(Tank t,Tank user){
		if(!t.getExploding()){
			if(!t.getFire()){
				if((t.getPos()).y <= (user.getPos()).y  + 50 &&(t.getPos()).y  >= (user.getPos()).y - 50 || (t.getPos()).x  >= (user.getPos()).x - 50&& (t.getPos()).x <= (user.getPos()).x + 50 ){
					t.setFire(true);
				}
			}
			if (one.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(LEFT);
			} 
			if (t.getOrientation() == DOWN && two.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(UP);
			} 
			if (t.getOrientation() == LEFT && !(t.getRotation() == LEFT)  && thirteen.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(UP);
			} 
			if (t.getOrientation() == DOWN && five.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(LEFT);
			} 
			if (four.contains(t.getPos())){
				t.tmove(RIGHT);
				t.setOrientation(RIGHT);
				t.setRotation(LEFT);
			}
			if (three.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(UP);
			}
			if (t.getOrientation() == UP && two.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(LEFT);
			} 
			if (t.getRotation() == LEFT && thirteen.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(RIGHT);
			} 
			if (six.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(LEFT);
			} 
			if (seven.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(RIGHT);
			} 
			if (nine.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(RIGHT);
			} 
			if (twelve.contains(t.getPos())){
				t.tmove(RIGHT);
				t.setOrientation(RIGHT);
				t.setRotation(UP);
			} 
			t.move(t.getOrientation());
		}
	}

	public void level4(Tank t,Tank user){
		if(!t.getExploding()){
			if(!t.getFire()){
				if((t.getPos()).y <= (user.getPos()).y  + 50 &&(t.getPos()).y  >= (user.getPos()).y - 50 || (t.getPos()).x  >= (user.getPos()).x - 50&& (t.getPos()).x <= (user.getPos()).x + 50 ){
					t.setFire(true);
				}
			}
			if (one.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(DOWN);
			} 
			if (t.getOrientation() == LEFT && six.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(RIGHT);
			} 
			if (t.getOrientation() == DOWN && five.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(LEFT);
			} 
			if (t.getOrientation() == DOWN && four.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(UP);
			}
			if (twelve.contains(t.getPos())){
				t.tmove(RIGHT);
				t.setOrientation(RIGHT);
				t.setRotation(UP);
			}
			if (t.getOrientation() == UP && six.contains(t.getPos())){
				t.tmove(RIGHT);
				t.setOrientation(RIGHT);
				t.setRotation(DOWN);
			} 
			if (t.getOrientation() == UP && five.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(UP);
			} 
			if (t.getOrientation() == RIGHT && four.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(LEFT);
			}
			t.move(t.getOrientation());
		}
	}
	
	public void level5(Tank t,Tank user){
		if(!t.getExploding()){
			if(!t.getFire()){
				if((t.getPos()).y <= (user.getPos()).y  + 50 &&(t.getPos()).y  >= (user.getPos()).y - 50 || (t.getPos()).x  >= (user.getPos()).x - 50&& (t.getPos()).x <= (user.getPos()).x + 50 ){
					t.setFire(true);
				}
			}
			if (t.getOrientation() == UP && one.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(DOWN);
			} 
			if (t.getOrientation() == RIGHT && one.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(LEFT);
			} 
			if (t.getOrientation() == DOWN && two.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(UP);
			} 
			if (t.getOrientation() == UP && two.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(UP);
			} 
			if (t.getOrientation() == RIGHT && two.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(UP);
			} 
			if (t.getOrientation() == RIGHT && three.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(UP);
			}	
			if (t.getOrientation() == DOWN && three.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(UP);
			}	
			if (t.getOrientation() == RIGHT && four.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(LEFT);
			}	
			if (t.getOrientation() == LEFT && four.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(UP);
			}
			if (t.getOrientation() == DOWN && four.contains(t.getPos())){
				t.tmove(RIGHT);
				t.setOrientation(RIGHT);
				t.setRotation(LEFT);
			}
			if (t.getOrientation() == UP && five.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(UP);
			}	
			if (t.getOrientation() == DOWN && five.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(DOWN);
			}
			if (t.getOrientation() == RIGHT && five.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(LEFT);
			}
			if (t.getOrientation() == RIGHT && six.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(RIGHT);
			}
			if (t.getOrientation() == LEFT && six.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(DOWN);
			}
			if (t.getOrientation() == UP && six.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(RIGHT);
			}
			if (t.getOrientation() == UP && seven.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(DOWN);
			}
			if (t.getOrientation() == LEFT && seven.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(LEFT);
			}
			if (t.getOrientation() == RIGHT && seven.contains(t.getPos())){
				t.tmove(RIGHT);
				t.setOrientation(RIGHT);
				t.setRotation(RIGHT);
			}
			if (t.getOrientation() == RIGHT && eight.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(LEFT);
			}
			if (t.getOrientation() == DOWN && eight.contains(t.getPos())){
				t.tmove(LEFT);
				t.setOrientation(LEFT);
				t.setRotation(UP);
			}
			if (t.getOrientation() == UP && nine.contains(t.getPos())){
				t.tmove(RIGHT);
				t.setOrientation(RIGHT);
				t.setRotation(DOWN);
			}
			if (t.getOrientation() == LEFT && nine.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(DOWN);
			}
			if (t.getOrientation() == LEFT && ten.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(DOWN);
			}
			if (t.getOrientation() == DOWN && ten.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(DOWN);
			}
			if (t.getOrientation() == UP && ten.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(RIGHT);
			}
			if (t.getOrientation() == UP && eleven.contains(t.getPos())){
				t.tmove(RIGHT);
				t.setOrientation(RIGHT);
				t.setRotation(DOWN);
			}
			if (t.getOrientation() == DOWN && eleven.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(RIGHT);
			}
			if (t.getOrientation() == LEFT && eleven.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(UP);
			}
			if (t.getOrientation() == LEFT && twelve.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(RIGHT);
			}
			if (t.getOrientation() == DOWN && twelve.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(RIGHT);
			}
			if (t.getOrientation() == UP && thirteen.contains(t.getPos())){
				t.tmove(RIGHT);
				t.setOrientation(RIGHT);
				t.setRotation(UP);
			}
			if (t.getOrientation() == LEFT && thirteen.contains(t.getPos())){
				t.tmove(UP);
				t.setOrientation(UP);
				t.setRotation(UP);
			}
			
			if (t.getOrientation() == DOWN && thirteen.contains(t.getPos())){
				t.tmove(DOWN);
				t.setOrientation(DOWN);
				t.setRotation(UP);
			}
			t.move(t.getOrientation());
		}
	}
}