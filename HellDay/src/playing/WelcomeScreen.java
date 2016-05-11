package playing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class WelcomeScreen extends JPanel {
	private JPanel panelButtons;
	private JPanel panelTitle;
	private JButton buttonStart;
	private JButton buttonHelp;
	private JButton buttonExit;
	private JLabel lblTitle;
	private Dimension buttonSize;
	private Font buttonFont;
	private Icon img;
	private Icon imgNurse;
	private JLabel lblIcon1 = new JLabel();
	private JLabel lblIcon2 = new JLabel();
	private JLabel lblIcon3 = new JLabel();
	private JLabel lblIcon4 = new JLabel();
	private JLabel lblIcon5 = new JLabel();
	private JLabel lblIcon6 = new JLabel();
	private JLabel lblIcon7 = new JLabel();
	private JLabel lblIcon8 = new JLabel();
	private JLabel lblNurse = new JLabel();
	private SwitchPanel switchPanel;
	
	public WelcomeScreen(SwitchPanel switchPanel) {
		this.switchPanel = switchPanel;
		setLayout(null);
		setBackground(Color.black);
		setFocusable(true);
		
		img = new ImageIcon(getClass().getResource("/images/fire.gif"));
		imgNurse = new ImageIcon(getClass().getResource("/images/sjuk.gif"));
		panelTitle = new JPanel();
		panelTitle.setBackground(Color.black);
		panelTitle.setBounds(200, 50, 400, 50);
		add(panelTitle);
		
		lblTitle = new JLabel("HELL DAY PÅ AKUTEN");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 36));
		lblTitle.setBackground(Color.black);
		lblTitle.setForeground(Color.red);
		panelTitle.add(lblTitle);
		
		panelButtons = new JPanel();
		panelButtons.setBorder(BorderFactory.createLineBorder(Color.black));
		panelButtons.setBounds(200, 150, 400, 300);
		panelButtons.setBackground(Color.black);
		add(panelButtons);
		
		buttonSize = new Dimension(200,70);
		buttonFont = new Font("Arial", Font.BOLD, 20);
		
		buttonStart = new JButton("Start");
		buttonStart.setPreferredSize(buttonSize);
		buttonStart.setFont(buttonFont);
		buttonStart.setBackground(Color.black);
		buttonStart.setForeground(Color.red);
		buttonStart.setBorderPainted(false);
		buttonStart.addActionListener(new StartListener());
		panelButtons.add(buttonStart);
		
		buttonHelp = new JButton("Hjälp");
		buttonHelp.setPreferredSize(buttonSize);
		buttonHelp.setFont(buttonFont);
		buttonHelp.setBackground(Color.black);
		buttonHelp.setForeground(Color.red);
		buttonHelp.setBorderPainted(false);
		buttonHelp.addActionListener(new HelpListener());
		panelButtons.add(buttonHelp);
		
		buttonExit = new JButton("Avsluta");
		buttonExit.setPreferredSize(buttonSize);
		buttonExit.setFont(buttonFont);
		buttonExit.setBackground(Color.black);
		buttonExit.setForeground(Color.red);
		buttonExit.setBorderPainted(false);
		buttonExit.addActionListener(new ExitListener());
		panelButtons.add(buttonExit);
		
		lblIcon1.setIcon(img);
		lblIcon1.setBounds(0, 600, 100, 100);
		lblIcon2.setIcon(img);
		lblIcon2.setBounds(100, 600, 100, 100);
		lblIcon3.setIcon(img);
		lblIcon3.setBounds(200, 600, 100, 100);
		lblIcon4.setIcon(img);
		lblIcon4.setBounds(300, 600, 100, 100);
		lblIcon5.setIcon(img);
		lblIcon5.setBounds(400, 600, 100, 100);
		lblIcon6.setIcon(img);
		lblIcon6.setBounds(500, 600, 100, 100);
		lblIcon7.setIcon(img);
		lblIcon7.setBounds(600, 600, 100, 100);
		lblIcon8.setIcon(img);
		lblIcon8.setBounds(700, 600, 100, 100);
		add(lblIcon1);
		add(lblIcon2);
		add(lblIcon3);
		add(lblIcon4);
		add(lblIcon5);
		add(lblIcon6);
		add(lblIcon7);
		add(lblIcon8);
		
		lblNurse.setIcon(imgNurse);
		lblNurse.setBounds(350, 400, 100, 300);
		
		add(lblNurse);
		
	}
	
	private class StartListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			switchPanel.changePanel("firstPnl");
		}
	}
	
	private class HelpListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class ExitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}

}
