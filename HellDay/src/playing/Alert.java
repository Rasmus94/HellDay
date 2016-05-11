package playing;

import java.awt.Color;
import java.awt.Graphics2D;

public class Alert  {
	private int x, y;
	private int width = 50, height = 50;
	private Color c = new Color(255, 0, 0, 0);
	private Test game;
	private Flash flash = new Flash();
	private boolean isFlash = true;
	
	public Alert(Test game){
		this.game = game;
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
	
	public void setLocation(int location){
		switch(location){
		case 1: x = game.getX();
				y = game.getY();
				break;
		case 2: x = game.getWidth()/2 - width/2;
				y = game.getY();
				break;
		case 3: x = game.getWidth() - width;
				y = game.getY();
				break;
		case 4: x = game.getWidth() - width;
				y = game.getHeight()/2 - height/2;
				break;
		case 5: x = game.getWidth() - width;
				y = game.getHeight() - height;
				break;
		case 6: x = game.getWidth()/2 - width/2;
				y = game.getHeight() - height;
				break;
		case 7: x = game.getX();
				y = game.getHeight() - height;
				break;
		case 8: x = game.getX();
				y = game.getHeight()/2 - height/2;
				break;
		}
	}
	
	public void startFlash(){
		if(!flash.isAlive()){
			isFlash = true;
			flash.start();
		}
	}
	
	public void stopFlash(){
		if(flash.isAlive()){
			isFlash = false;
			flash.interrupt();
		}
	}
	
	private class Flash extends Thread{
		public void run(){
			while(isFlash){
				try {
					c = new Color(255, 0, 0, 255);
					game.update();
					Thread.sleep(500);
				
					c = new Color(255, 0, 0, 0);
					game.update();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void draw(Graphics2D g2){
		g2.setColor(c);
		g2.fillOval(x, y, width, height);
	}
}
