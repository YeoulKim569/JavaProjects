package my_portfolio;
import javax.swing.*;

public class ProfileUI extends JFrame {
	public ProfileUI() {
		Profile profile = new Profile();
		
		setTitle("Profile");
	    setSize(500, 700);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);	
	    
	    setVisible(true);
	}
}
