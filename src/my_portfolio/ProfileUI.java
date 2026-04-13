package my_portfolio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

public class ProfileUI extends JFrame {
	public ProfileUI() {
		Profile profile = new Profile("Kim Yeoul", 18, "High School Graduate", "Journaling", "pictures/profile_picture.jpeg" );
		
		this.setTitle("Profile");
	    this.setSize(500, 700);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);	
	    
	    
	    JPanel topPanel = new JPanel();
	    topPanel.setLayout(new BorderLayout());
	    topPanel.setLayout(new FlowLayout());
	    topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	    this.add(topPanel);
	    
	    //Image
	    ImageIcon imageIcon = new ImageIcon(profile.getImagePath()); // <-- your JPG file
        JLabel imageLabel = new JLabel(imageIcon);
        topPanel.add(imageLabel, BorderLayout.NORTH);     
        
        //Information
        JPanel infoPanel = new JPanel();
        JLabel label = new JLabel("Name: Yeoul");
        infoPanel.add(label);
        topPanel.add(infoPanel);
        
        JPanel bodyPanel = new JPanel();
        JLabel label2 = new JLabel("body panel");
        bodyPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        bodyPanel.add(label2);
	    this.add(bodyPanel);
        
	    setVisible(true);
	}
}
