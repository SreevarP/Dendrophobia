import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player extends Entity{
	int velx=0, vely=0;
	public Player(int x, int y) {
		super(x, y);
		update();
		// TODO Auto-generated constructor stub
	}
	public void update(){
		y+=vely;
		x+=velx;
	}
	public void draw(Graphics2D g2d){
		g2d.drawImage(getPlayerImg(), x, y, null);
	}
public Image getPlayerImg(){
	ImageIcon ic=new ImageIcon("images.jfif");
	Image i = ic.getImage();
	return i;
}

public int getXVel() {
	return velx;
}

public int getYVel() {
	return vely;
}

public void keyPressed(KeyEvent e) {
	int key=e.getKeyCode();
	if(key==KeyEvent.VK_W) {
		vely=-2;
	}else if (key==KeyEvent.VK_S) {
		vely=2;
	}else if (key==KeyEvent.VK_A) {
		velx=-2;
	}else if(key==KeyEvent.VK_D) {
		velx=2;
	}
}
public void keyReleased(KeyEvent e) {
	int key=e.getKeyCode();
	if(key==KeyEvent.VK_W) {
		vely=0;
	}else if (key==KeyEvent.VK_S) {
		vely=0;
	}else if (key==KeyEvent.VK_A) {
		velx=0;
	}else if(key==KeyEvent.VK_D) {
		velx=0;
	}

}

	


}