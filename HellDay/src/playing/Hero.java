package playing;

import java.awt.Color;
import java.awt.Graphics2D;

public class Hero {
	private int x, y;
	private String resource; // kanske används för att göra gubben till en bild istället för graphics
	
	public Hero(){
		
	}
	
	public Hero(String resource){
		this.resource = resource;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void draw(Graphics2D g2){
		//draw head
		g2.setColor(Color.GRAY);
		g2.fillOval(x, y, 50, 50);
		g2.setColor(Color.WHITE);
		g2.fillOval(x+10, y+10, 5, 5);
		g2.fillOval(x+20, y+10, 5, 5);
		g2.fillOval(x+25, y+25, 10, 10);
		
		//draw body
		g2.setColor(Color.GRAY);
		g2.fillRoundRect(x-10, y+50, 70, 50, 10, 10);
		g2.fillOval(x+15, y+95, 15, 15);
	}
}
