package playing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;

public class Question{
	private int x, y;
	private int x2 = 300, y2 = 400;
	private int smallX, smallY;
	private String question;
	private Color cBackground = new Color(255, 255, 255, 100);
	private Boolean visible = true;
	private Background bg;
	private GameQuestion gq = new GameQuestion();
	private ArrayList<String> answer = new ArrayList<String>();
	
	public Question(Background bg, int x, int y, int location){
		setQuestion();
		this.x = x;
		this.y = y;
		this.bg = bg;
		setLocation(location);
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
	
	public void setQuestion(){
		String txt = gq.getRandomKey();
		answer = gq.getValue();
		this.question = fixQuestion(txt);
	}
	
	public void setAnswerValue(String answerValue) {
		this.question = fixQuestion(answerValue);
	}
	
//	public void setAnswers(){
//		answer = gq.getValue();
//	}
	
	public ArrayList<String> getAnswer() {
		return answer;
	}
	
	public int getX2(){
		return x2;
	}
	
	public int getY2(){
		return y2;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	/*
	 * Metoden bestämmer var den lilla bubblan ska placeras. Tänkte
	 * att det var snyggt för att visa vilket hörn frågan kommer ifrån. 
	 * Den har 8a olika positioner. Den första positionen är i den stora
	 * bubblans vänstra hörn. Nästa är rakt ovanför den stora bubblan osv. 
	 * Medurs alltså.
	 */
	public void setLocation(int location){
		switch(location){
		
		case 1: x = bg.getX() + 70;
				y = bg.getY() + 70;
				smallX = x-50;
				smallY = y-50;
				break;
		case 2: x = bg.getX() + bg.getWidth()/2 + bg.getStartX();
				y = bg.getY() + 90;
				smallX = x+120;
				smallY = y-75;
				break;
		case 3: x = bg.getX() + bg.getWidth()/2;
				y = bg.getY() + 70;
				smallX = x+325;
				smallY = y-50;
				break;
		case 4: x = bg.getX() + bg.getWidth()/2;
				y = bg.getY() + bg.getHeight()/2 + bg.getStartY();
				smallX = x+325;
				smallY = y+175;
				break;
		case 5: x = bg.getX() + bg.getWidth()/2;
				y = bg.getY() + bg.getHeight()/2 + bg.getStartY();
				smallX = x+300;
				smallY = y+400;
				break;
		case 6: x = bg.getX() + bg.getWidth()/2 + bg.getStartX();
				y = bg.getY() + bg.getHeight()/2 + bg.getStartY()-50;
				smallX = x+120;
				smallY = y+425;
				break;
		case 7: x = bg.getX() + 70;
				y = bg.getY() + bg.getHeight()/2 + bg.getStartY()-50;
				smallX = x-50;
				smallY = y+400;
				break;
		case 8: x = bg.getX() + 90;
				y = bg.getY() + bg.getHeight()/2 + bg.getStartY();
				smallX = x-75;
				smallY = y+175;
				break;
		}
	}
	
	// metoden fixar bara så att texten på frågan hamnar innanför bubblan
	private String fixQuestion(String txt){
		LinkedList<String> fixList = new LinkedList<String>();
		int count = 0;
		String result = "";
		
		if(txt.length() < 24){
			fixList.add(txt.substring(0, txt.length()));
		}else{
			fixList.add(txt.substring(0, 23));
		}
		
		for(int i=0; i<txt.length()-24; i++){
			if(count < 24){
				count++;
			}else{
				fixList.add(txt.substring(i, i+25));
				count = 0;
			}
		}
		fixList.add(txt.substring(txt.length()-count, txt.length()));
		
		for(int x=0; x<fixList.size(); x++){
			result+=fixList.get(x) + "\n";
		}
		
		return result;
	}
	
	// Ritar ut strängen i bubblan 
	private void fixString(Graphics2D g2, String text, int x, int y) {
	    for (String line : text.split("\n"))
	        g2.drawString(line, x, y += g2.getFontMetrics().getHeight());
	}
	
	public void draw(Graphics2D g2){
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("", Font.ITALIC, 18));
		g2.drawOval(smallX, smallY, 50, 50);
		g2.drawRoundRect(x, y, x2, y2, 200, 100 );
		g2.setColor(cBackground);
		g2.fillRoundRect(x, y, x2, y2, 200, 100);
		g2.fillOval(smallX, smallY, 50, 50);
		g2.setColor(Color.BLACK);
		fixString(g2, question, x+30, y+50);
	}
	
	
}
