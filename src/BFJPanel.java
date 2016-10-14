/*
  * 
  * 
  * author: Zain Ali 1298523
  * 
  * This is a game where the user gets control of a Tank object and has to defeat enemy tanks 
  * of different levels and difficulties (only 7 levels). It is set in a military area
  * which is why there are building which are "supposed" to look like barracks.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BFJPanel extends JPanel implements ActionListener, KeyListener{
	
	private Timer gameTimer, titleTimer;
	private Game tanksGame;
	
 	public BFJPanel() {
		setBackground(Color.black);
		gameTimer = new Timer(20, this);
		titleTimer = new Timer(30,this);
		tanksGame = new Game();
		addKeyListener(this);
 	}

	
   	public void paintComponent(Graphics g){
 	    super.paintComponent(g);
		tanksGame.drawGame(g);
	}
	
	public void keyPressed (KeyEvent e){
		tanksGame.keyPHandler(e,gameTimer,titleTimer);
		repaint();
	}
	
	public void actionPerformed(ActionEvent e){
		tanksGame.actionHandler(gameTimer);
		repaint();
	}
	
	public void keyReleased (KeyEvent e) {
		tanksGame.keyRHandler(e);
	}
	
	public void keyTyped (KeyEvent e) {} 
	
} 
