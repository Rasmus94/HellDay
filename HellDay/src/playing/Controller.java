package playing;

import java.util.ArrayList;
import java.util.Random;

public class Controller {
	private int direction;
	private Test game;
	private Hero hero;
	private Background bg;
	private Question q;
	private int qLocation = 1;
	private Alert alert;
	private ArrayList<String> answer = new ArrayList<String>();
	private boolean runQuestion;
	
	public Controller(Test game, Hero hero, Background bg, Alert alert){
		this.game = game;
		this.hero = hero;
		this.bg = bg;
		this.alert = alert;
		new Movement();
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	
	public void setQuestion(Question q){
		this.q = q;
		new NewQuestion();
	}
	
	// Kollar så att hjälten stannar innanför fönstret
	public void checkHeroCollision(){
		if(hero.getX() < 0){
			hero.setX(0);
		}else if(hero.getX() > game.getWidth()-55){
			hero.setX(game.getWidth()-55);
		}else if(hero.getY() < 0){
			hero.setY(0);
		}else if(hero.getY() > game.getHeight()-120){
			hero.setY(game.getHeight()-120);
		}
		
//		else if(hero.getX()+55 > bg.getX()*2 + bg.getWidth()){
//			hero.setX((bg.getX()*2) + (bg.getWidth()-55));
//		}else if(hero.getY() < bg.getY()){
//			hero.setY(bg.getY());
//		}else if(hero.getY() > bg.getHeight()){
//			hero.getY();
//		}
	}
	
	// Kollar så att bakgrunden stannar innanför fönstret(inte färdig)
	public void checkBackgroundCollision(){
		if(bg.getX() > 0){
			bg.setX(0);
		}else if(bg.getX() < -740){
			bg.setX(-740);
		}else if(bg.getY() > 0){
			bg.setY(0);
		}else if(bg.getY() < -300){
			bg.setY(-300);
		}
	}
	
	// Tråden som rör gubben. Thread.sleep ändrar i stort sätt fps 
	private class Movement extends Thread{
		
		public Movement(){
			this.start();
		}
		
		public void run(){
			while(true){
				
				checkHeroCollision();
				checkBackgroundCollision();
				
				if(direction == 1){
					hero.setX(hero.getX()+7);
					bg.setX(bg.getX()-2);
					if(q != null && q.isVisible()){
						q.setLocation(qLocation);
					}
					game.update();
				}else if(direction == 2){
					hero.setX(hero.getX()-7);
					bg.setX(bg.getX()+2);
					if(q != null && q.isVisible()){
						q.setLocation(qLocation);
					}
					game.update();
				}else if(direction == 3){
					hero.setY(hero.getY()-7);
					bg.setY(bg.getY()+2);
					if(q != null && q.isVisible()){
						q.setLocation(qLocation);
					}
					game.update();
				}else if(direction == 4){
					hero.setY(hero.getY()+7);
					bg.setY(bg.getY()-2);
					if(q != null && q.isVisible()){
						q.setLocation(qLocation);
					}
					game.update();
				}else if(direction == 5){
					if(q != null && q.isVisible()){
						q.setLocation(qLocation);
						alert.setLocation(qLocation);
						game.update();
						if(qLocation < 8){
							qLocation++;
						}else{
							qLocation=0;
						}
					}
				}
				
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void newQuestion() {
		runQuestion = false;
		new NewQuestion();
	}
	
	private class NewQuestion extends Thread {
		private Random random = new Random();
		private int counter = 300;
		
		public NewQuestion() {
			runQuestion = true;
			this.start();
		}
		public void run() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while(runQuestion) {
				q.setQuestion();
				qLocation = random.nextInt(9)+1;
				for(int i = 0; i <= counter; counter--) {
					game.setTimeRemaining(""+counter);
					game.update();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
