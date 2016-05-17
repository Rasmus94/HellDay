package playing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpScreen extends JPanel {
	private JPanel headPanel;
	private JLabel lblHeadline;
	private JPanel centerPanel;
	private JScrollPane textPane;
	private JTextArea text;
	private Icon img;
	private JButton back;
	private JLabel lblIcon1 = new JLabel();
	private JLabel lblIcon2 = new JLabel();
	private JLabel lblIcon3 = new JLabel();
	private JLabel lblIcon4 = new JLabel();
	private JLabel lblIcon5 = new JLabel();
	private JLabel lblIcon6 = new JLabel();
	private JLabel lblIcon7 = new JLabel();
	private JLabel lblIcon8 = new JLabel();
	private SwitchPanel switchPanel;
	
	public HelpScreen(SwitchPanel switchPanel) {
		this.switchPanel = switchPanel;
		initGUI();
	}
	
	private void initGUI() {
		setLayout(null);
		setBackground(Color.black);
		
		headPanel = new JPanel();
		headPanel.setBounds(200, 10, 400, 100);
		headPanel.setBackground(Color.black);
		add(headPanel);
		
		lblHeadline = new JLabel("HJÄLP");
		lblHeadline.setFont(new Font("Arial", Font.BOLD, 36));
		lblHeadline.setForeground(Color.red);
		lblHeadline.setBackground(Color.black);
		headPanel.add(lblHeadline);
		
		textPane = new JScrollPane();
		textPane.setBounds(200, 120, 400, 400);
		add(textPane);
		
		text = new JTextArea();
		text.setText("Här kommer en beskrivning av spelet att finnas");
		text.setLineWrap(true);
		textPane.setViewportView(text);
		
		img = new ImageIcon(getClass().getResource("/images/fire.gif"));
		
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
		
		back = new JButton("Tillbaka");
		back.setBounds(350, 550, 110, 50);
		back.setFont(new Font("Arial", Font.BOLD, 20));
		back.setBackground(Color.black);
		back.setForeground(Color.red);
		back.setBorderPainted(false);
		back.addActionListener(new BackButton());
		
		add(back);
		
	}
	
	private class BackButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switchPanel.changePanel("welcomePnl");
		}
	}

}
