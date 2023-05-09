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

public class GameFrame extends JPanel implements ActionListener{
	Timer mainTimer;
	Player player;
	BufferedImage testImg;
	int testX, testY; 
	public GameFrame() {
		setFocusable(true);
		testX = 100; testY = 300; 
		try {
			testImg = ImageIO.read(new File("images1.jfif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		player = new Player(100,100);
		addKeyListener(new KeyAdapt(player));
 		mainTimer = new Timer(10,this);
 		mainTimer.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(testImg, testX, testY, null);
		player.draw(g2d);
		
	}
	
	public void update() {
		testX += -(player.getXVel() * .5) ; 
		testY += -(player.getYVel() * .5) ; 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		player.update();
		update();
		repaint();
		
	}

}