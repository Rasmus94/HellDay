package playing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test extends JPanel{ 
	private Alert alert = new Alert(this); // Alert-objektet ska senare kunna visa var frågan är placerad (kan ingenting nu)
	private Background bg = new Background(-300, -100, 1500, 1000); // skapar bakgrundsobjekt
	private Question q = new Question(bg, 300, 300, 1);
	private Hero hero = new Hero(); // skapar gubben
	private Controller controller = new Controller(this, hero, bg, alert); // controllern ansvarar för hur allt rör sig i spelet
	private boolean power = false; // ändra till true så ser ni
	private boolean vibration = false;
	private JTextField tfAnswer = new JTextField("Skriv ditt svar här");
	private JPanel panelAnswer = new JPanel();
	private JButton buttonAnswer = new JButton("Svara");
	
	public Test(){
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		this.setFocusable(true);
		this.addKeyListener(new Keys());
		setLayout(null);
		panelAnswer.setBounds(250, 600, 300, 60);
		panelAnswer.setOpaque(false);
		add(panelAnswer);
		tfAnswer.setPreferredSize(new Dimension(100, 30));
		panelAnswer.add(tfAnswer);
		
		buttonAnswer.setPreferredSize(new Dimension(100, 30));
		panelAnswer.add(buttonAnswer);
		
		buttonAnswer.addActionListener(new CheckAnswer());
		
		controller.setQuestion(q);
	} 
	
	// Låter andra klasser uppdatera allt som ritas i fönstret
	public void update(){
		repaint();
	}
	
	public void setPower(boolean b){
		power = b;
	}

	/**
	 * Okej paintComponent. This is where the magic happens. paintComponent metoden
	 * kallas automatiskt när den känner att det är dags att rita eller när vi kallar på
	 * metoden repaint(). Det som kan vara mindfuck är att vi inte ger paintComponent någon
	 * parameter(Graphics g) men den sköter det själv. Det som är nice är att vi kan definiera
	 * utseende för olika saker som ska ritas i sina egna klasser genom att skicka graphics g
	 * till draw metoden i dem klasserna. Varje gång något "event" ska ske så är det bara för oss
	 * att kalla på repaint() metoden, precis som när gubben ska röra sig (kolla controller).
	 * Test är bara en vanlig JPanel och paintComponent ritar i den. 
	 * 
	 */
	@Override
	public void paintComponent(Graphics g){
		bg.draw((Graphics2D) g);
		q.draw((Graphics2D)g);
		hero.draw((Graphics2D) g);
		alert.draw((Graphics2D) g);
		
		if(power){
			g.setColor(Color.BLACK);
			g.fillRect(bg.getX(), bg.getY(), bg.getWidth(), bg.getHeight());
		}
	}
	
	
	private class Vibrate extends Thread{
		
		public void run(){
			for(int i=0; i<40; i++){
				bg.setX(bg.getX() + 20);
				bg.setY(bg.getY() + 20);
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bg.setX(bg.getX() - 20);
				bg.setY(bg.getY() - 20);
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			vibration = false;
		}
	}
	
	/*
	 * Lyssnarna ändrar bara värdet i controller som sköter rörelser.
	 * Ganska lätt att lägga till flera rörelser, t.ex. w+d = rörelse diagonalt
	 */
	private class Keys implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if(!vibration){
				if(key == KeyEvent.VK_D){
					controller.setDirection(1);
				}else if(key == KeyEvent.VK_A){
					controller.setDirection(2);
				}else if(key == KeyEvent.VK_W){
				controller.setDirection(3);
				}else if(key == KeyEvent.VK_S){
					controller.setDirection(4);
				}
			}
			
			
			if(key == KeyEvent.VK_F1){
				if(power){
					power = false;
					repaint();
				}else{
					power = true;
					repaint();
				}
			}
			
			if(key == KeyEvent.VK_F2){
				vibration = true;
				new Vibrate().start();
			}
			
			if(key == KeyEvent.VK_F3){
				alert.setLocation(8);
				alert.startFlash();
			}
			
			if(key == KeyEvent.VK_F4){
				controller.setDirection(5);
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_D){
				controller.setDirection(0);
				
			}else if(key == KeyEvent.VK_A){
				controller.setDirection(0);
				
			}else if(key == KeyEvent.VK_W){
				controller.setDirection(0);
				
			}else if(key == KeyEvent.VK_S){
				controller.setDirection(0);
			}else if(key == KeyEvent.VK_F4){
				controller.setDirection(0);
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class CheckAnswer implements ActionListener {
		ArrayList<String> answer = new ArrayList<String>();
		public void actionPerformed(ActionEvent e) {
			if(buttonAnswer == e.getSource()) {
				if(tfAnswer.getText() != null) {
					answer = q.getAnswer();
					for(int i = 0; i < answer.size(); i++) {
						if(answer.get(i).equals(tfAnswer.getText())) {
							q.setAnswerValue("RÄTT! RÄTT! RÄTT! RÄTT!");
							update();
						}
					}
					controller.newQuestion();
				}
			}
		}
	}
	
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Test());
		f.setSize(800, 700);
		f.setResizable(false);
		f.setVisible(true);
	}
	
}
