package playing;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	private int x, y, width, height;
	private BufferedImage img;
	private int startX, startY;
	
	public Background(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.width = width;
		this.height = height;
		readImage();
	}
	
	public synchronized void setX(int x){
		this.x = x;
	}
	
	public synchronized void setY(int y){
		this.y = y;
	}
	
	public synchronized int getX(){
		return x;
	}
	
	public synchronized int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getStartX(){
		return startX;
	}
	
	public int getStartY(){
		return startY;
	}
	
	// Enkel metod, läser bara in en bild som används för att rita bakgrunden.
	private void readImage(){
		try {
		//	img = ImageIO.read(new File("C:/users/rasmus/desktop/bg.png"));
			img = ImageIO.read(getClass().getResourceAsStream("/images/background.png"));
		} catch (IOException e) {
			System.err.println("Could not find image");
		}
	}
	
	// Den här metoden ritar ut bakgrundsbilden när den kallas från Test
	public void draw(Graphics2D g2){
		g2.drawImage(img, x, y, width, height, null);
	}
}
