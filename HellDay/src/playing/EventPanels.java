package playing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventPanels {
	private JPanel panelBackground;
	
	private JPanel pnlEvent1;
	private JPanel pnlEvent2;
	private JPanel pnlEvent3;
	private JPanel pnlEvent4;
	private JPanel pnlEvent5;
	
	private JLabel lblEvent1;
	private JLabel lblEvent2;
	private JLabel lblEvent3;
	private JLabel lblEvent4;
	private JLabel lblEvent5;
	
	private JTextField tfEvent1;
	private JTextField tfEvent2;
	private JTextField tfEvent3;
	private JTextField tfEvent4;
	private JTextField tfEvent5;
	
	private Test test;
	private Background background;
	
	public EventPanels(Test inTest, Background inBackground) {
		this.test = inTest;
		this.background = inBackground;
		initEventGUI();
	}
	
	private void initEventGUI() {
		Dimension pnlDimension = new Dimension(200, 200);
		Dimension bgSize = new Dimension(500, 500);
		
		panelBackground = new JPanel();
//		panelBackground.setPreferredSize(bgSize);
		panelBackground.setBounds(-100, -100, background.getWidth(), background.getHeight());
		panelBackground.setBorder(BorderFactory.createLineBorder(Color.green, 10));
		panelBackground.setOpaque(false);
		panelBackground.setLayout(null);
		test.add(panelBackground);
		
		pnlEvent1 = new JPanel();
		pnlEvent1.setOpaque(false);
		pnlEvent1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlEvent1.setPreferredSize(pnlDimension);
		pnlEvent1.setBounds((background.getWidth()/2), (background.getHeight()/2), 200, 200);
		panelBackground.add(pnlEvent1);
		
		pnlEvent2 = new JPanel();
		pnlEvent2.setOpaque(false);
		pnlEvent2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlEvent2.setPreferredSize(pnlDimension);
		test.add(pnlEvent2);
		
		pnlEvent3 = new JPanel();
		pnlEvent3.setOpaque(false);
		pnlEvent3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlEvent3.setPreferredSize(pnlDimension);
		test.add(pnlEvent3);
		
		pnlEvent4 = new JPanel();
		pnlEvent4.setOpaque(false);
		pnlEvent4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlEvent4.setPreferredSize(pnlDimension);
		test.add(pnlEvent4);
		
		pnlEvent5 = new JPanel();
		pnlEvent5.setOpaque(false);
		pnlEvent5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlEvent5.setPreferredSize(pnlDimension);
		test.add(pnlEvent5);
	}
}
