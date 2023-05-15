import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameFrame extends JPanel implements ActionListener, Runnable{
	Timer mainTimer;
	final int originalTile =16;
	final int scale=3;
	final int tileSize= originalTile*scale;
	final int maxScreenCol=16;
	final int maxScreenRow=12;
	final int screenWidth= tileSize*maxScreenCol;
	final int screenHeight= tileSize* maxScreenRow;
	Thread gameThread;
	Player player;
	BufferedImage testImg;
	int testX, testY; 
	public GameFrame() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);

		setFocusable(true);
		
		
		player = new Player(100,100);
		addKeyListener(new KeyAdapt(player));
 		mainTimer = new Timer(10,this);
 		mainTimer.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//g2d.drawImage(testImg, testX, testY, null);
		player.draw(g2d);
		
	}
	
	public void update() {
		player.update();
	//	player.draw();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		player.update();
		update();
		repaint();
		
	}
	public void startGameThread() {
		gameThread= new Thread(this);
		gameThread.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double drawInterval = 1000000000/60;
		double nextDraw= System.nanoTime()+drawInterval;
		
		double delta=0;
		long lastTime=System.nanoTime();
		long currentTime;
		while (gameThread!=null) {
		
			update();
			repaint();
			
			try {
				double remaining= nextDraw-System.nanoTime();
				remaining= remaining/1000000;
				if(remaining<0) {
					remaining=0;
				}
				Thread.sleep((long)remaining);
				nextDraw+=drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}