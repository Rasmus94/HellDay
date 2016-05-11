package playing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;



public class GUI  extends JPanel{
	private static GameQuestion gq = new GameQuestion();
	private JFrame frame;
	private JPanel panel;
	private JLabel title, timerTitle, timer, scoreTitle, score,  animation;
	private JTextField answer;
	private JTextArea question;
	private JLabel animate;
	private JButton submit, next;
	private Font font = new Font("Verdana", Font.BOLD + Font.ITALIC, 20);
	private Font font1 = new Font("TimesNewRoman", Font.PLAIN, 15);
	private Font font2= new Font("Verdana", Font.BOLD + Font.ITALIC, 25);
	private Font font3= new Font("Verdana", Font.PLAIN+ Font.ITALIC, 12);

	private Border b = BorderFactory.createDashedBorder(Color.RED, 4.0f, 3.0f, 2.0f, true);
	private Timer countdownTimer;
	private int timeRemaining = 300;
	
	private SwitchPanel switchPanel;
	
	//http://www.animatedimages.org/cat-question-mark-signs-1476.htm
	
	public GUI(SwitchPanel pnl){
		this.switchPanel = pnl;
		InitializeGUI();
	}
	

	public void InitializeGUI(){
		this.setLayout(new BorderLayout());
		panel = new JPanel();
		
		panel.setBorder(b);
		panel.setLayout(null);
		title = new JLabel("Hell day på akuten");
		title.setFont(font);
		
		timerTitle  = new JLabel("Timer:");
		timerTitle.setFont(font1);
		timer = new JLabel(String.valueOf(timeRemaining));
		countdownTimer = new Timer(1000, new CountdownTimerListener());
	      countdownTimer.start();
		timer.setFont(font1);
		
		scoreTitle  = new JLabel("Score:");
		scoreTitle.setFont(font1);
		score = new JLabel("0");
		score.setFont(font1);
		
		question = new JTextArea();
		question.setFont(font1);
		question.setEditable(false);
		Border b1 = BorderFactory.createTitledBorder("Svara på den fråga");
		gq.test();
		question.setText(gq.getRandomKey());
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		
		animation = new JLabel("");
		animation.setFont(font1);
		try {
			animation.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/images/spinning.gif"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		animate = new JLabel();
		answer = new JTextField("Svara här");
		answer.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				answer.setText("");
			}
		});

		
		
		submit = new JButton("Skicka Svar");
		
		next = new JButton("Nästa Fråga");
	
		
		title.setBounds(4,0,1000,100);
		timerTitle.setBounds(400,0,200,100);
		timer.setBounds(500,0,100,100);
		scoreTitle.setBounds(400,30,200,100);
		score.setBounds(500,30,200,100);
		question.setBounds(50, 200, 600, 200);
		question.setBorder(b1);
		animation.setBounds(660, 100,200, 400);
		animate.setBounds(50,440,750,80);
		try {
			animate.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/images/cross.gif"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		answer.setBounds(20,550, 200, 50);
		submit.setBounds(230,550, 150,50);
		next.setBounds(590,600,150, 50);
		
		panel.add(title);
		panel.add(timerTitle);
		panel.add(timer);
		panel.add(scoreTitle);
		panel.add(score);
		panel.add(question);
		panel.add(animation);
		panel.add(animate);
		panel.add(answer);
		panel.add(submit);
		submit.addActionListener(new SubmitButtonActionListener());
		panel.add(next);
		next.addActionListener(new NextButtonActionListener());
		this.add(panel);
	}

	public void resetTimeRemaing() {
		this.timeRemaining = 300;
	}
	
	private class CountdownTimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           if (--timeRemaining > 0) {
              timer.setText(String.valueOf(timeRemaining));
           } else {
              timer.setText("Time's up!");
           // 
           }
        }
     }

	
	private class SubmitButtonActionListener implements ActionListener{
		private int points = 0;

		public void actionPerformed(ActionEvent e) {
			
		//if(answer.getText().equals(gq.getValue())){
		if (gq.getValue().contains(answer.getText())){
				animation.setText("Rätt Svar");
				animation.setFont(font2);
				animation.setForeground(Color.green);
				animation.setIcon(null);
				answer.setEditable(false);
				submit.setEnabled(false);
				countdownTimer.stop();
				points+=10;
				score.setText(String.valueOf(points));
				if(this.points== 100){
					JOptionPane.showMessageDialog(frame, "Congratulations"+ "\n Level Completed" + "\n Press here for next level");	
					switchPanel.changePanel("testPnl");
					next.setEnabled(false);
				}				
			} else {
				animation.setText("Fel Svar. Prova Igen. Kolla timer");
				animation.setFont(font3);
				animation.setForeground(Color.red);
				animation.setIcon(null);
				if(timer.getText().equals("Time's up!")){
					countdownTimer.stop();
					submit.setEnabled(false);
					answer.setEditable(false);
				}				
			}	
		}			
	}
	
	private class NextButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ev) {
			submit.setEnabled(true);
			answer.setEditable(true);
			resetTimeRemaing();
			timer.setText(String.valueOf(timeRemaining));
		    countdownTimer.start();
			gq.test();
			question.setText(gq.getRandomKey());
			answer.setText("Svara här");
			animation.setIcon(new ImageIcon("QuestionMark.gif"));
			animation.setText("");		
	}
}
	
	
}


	

