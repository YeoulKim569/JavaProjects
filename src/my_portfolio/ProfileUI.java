package my_portfolio;
import java.awt.BorderLayout;

import javax.swing.*;

public class ProfileUI extends JFrame {
	public ProfileUI() {
		Profile profile = new Profile("Kim Yeoul", 18, "High School Graduate", "Journaling", "pictures/profile_picture.jpeg" );
		
		setTitle("Profile");
	    setSize(500, 700);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);	
	    
	    ImageIcon imageIcon = new ImageIcon(profile.getImagePath()); // <-- your JPG file
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(JLabel.LEFT);
        
        add(imageLabel, BorderLayout.NORTH);
	    
	    setVisible(true);
	}
}
