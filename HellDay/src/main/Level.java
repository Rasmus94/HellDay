package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Level extends JPanel{
	private JLabel lblBackground;
	private ImageIcon imgBackground;
	private JLabel lblQuestion;
	private JLabel eventOne;
	
	public Level() {
		initGUI();
	}
	
	private void initGUI() {
		lblBackground = new JLabel();
		lblBackground.setLayout(null);
		imgBackground = new ImageIcon(getClass().getResource("/images/background.png"));
		lblBackground.setIcon(imgBackground);
		
		lblQuestion = new JLabel();
		lblQuestion.setBounds(320, 350, 100, 50);
		lblQuestion.setText("Vad är 10*10?");
		
		lblBackground.add(lblQuestion);
		
		eventOne = new JLabel();
		eventOne.setBounds(500, 100, 100, 50);
		eventOne.setBorder(BorderFactory.createLineBorder(Color.black));
		eventOne.setOpaque(true);
		
		add(lblBackground);
		lblBackground.add(eventOne);
		eventOne.setBackground(Color.RED);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(640, 480));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.add(new Level());
		frame.setVisible(true);
		
	}
}
