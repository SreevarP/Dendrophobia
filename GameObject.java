import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameObject implements ScrollObject{
	private int objectX, objectY;
	private static double scrollConst = .95; 
	private BufferedImage objectImg;
	private String fileName; 
	private int height,length;
	
	public GameObject(int objectX, int objectY, String fileName) {
		super();
		this.objectX = objectX;
		this.objectY = objectY;
		this.fileName = fileName; 
		try {
			objectImg = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	public void drawObject(Graphics2D g2d) {
		g2d.drawImage(objectImg, objectX, objectY, null); 
	}
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  

	@Override
	
	public void update(Player p) {
		objectX += -(p.getXVel());
		objectY += -(p.getYVel()); 
		
	}

	public int getObjectX() {
		return objectX;
	}
	

	public void setObjectX(int objectX) {
		this.objectX = objectX;
	}

	public int getObjectY() {
		return objectY;
	}

	public void setObjectY(int objectY) {
		this.objectY = objectY;
	}

	public BufferedImage getObjectImg() {
		return objectImg;
	}

	public void setObjectImg(BufferedImage objectImg) {
		this.objectImg = objectImg;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	} 
	
	
	
}
