package playing;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwitchPanel extends JPanel {
	private CardLayout cardLayout = new CardLayout();
	private WelcomeScreen welcome = new WelcomeScreen(this);
	private GUI first = new GUI(this);
	private Test test = new Test();
	private HelpScreen help = new HelpScreen(this);
	
	public SwitchPanel(){
		this.setFocusable(true);
		this.setLayout(cardLayout);
		this.add(welcome, "welcomePnl");
		this.add(test, "testPnl");
		this.add(first, "firstPnl");
		this.add(help, "helpPnl");
	}
	
	public void changePanel(String panel){
		if(panel.equals("testPnl")){
			cardLayout.show(this, panel);
			test.requestFocus();
		}else if(panel.equals("welcomePnl")){
			cardLayout.show(this, panel);
			welcome.requestFocus();
		}else if(panel.equals("firstPnl")){
			cardLayout.show(this, panel);
			first.requestFocus();
		}else if(panel.equals("helpPnl")) {
			cardLayout.show(this, panel);
			help.requestFocus();
		}
		
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	JFrame f = new JFrame();
        		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		f.add(new SwitchPanel());
        		f.setSize(800, 800);
        		f.setResizable(false);
        		f.setVisible(true);
            }
        });
		
		
		
	}
}
