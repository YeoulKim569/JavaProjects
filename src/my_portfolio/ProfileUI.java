package my_portfolio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.*;

public class ProfileUI extends JFrame {
	public ProfileUI() {
		Profile profile = new Profile("Kim Yeoul", 18, "High School Graduate", "Journaling", "pictures/profile_picture.jpeg" );
		
		this.setTitle("Profile");
	    this.setSize(500, 700);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);	
	    this.setLayout(new BorderLayout());

	    JPanel topPanel = new JPanel();
	    topPanel.setPreferredSize(new Dimension(500, 150));
	    topPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
	    topPanel.setLayout(new BorderLayout());
	    topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

	    // Image panel (top-left)
	    JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    ImageIcon imageIcon = new ImageIcon(profile.getImagePath());

	    Image img = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	    imageIcon = new ImageIcon(img);

	    JLabel imageLabel = new JLabel(imageIcon);
	    imagePanel.add(imageLabel);

	    topPanel.add(imagePanel, BorderLayout.NORTH);

	    // Body panel
	    JPanel bodyPanel = new JPanel();
	    bodyPanel.setBorder(BorderFactory.createLineBorder(Color.red));
	    bodyPanel.add(new JLabel("body panel"));

	    // Add panels
	    this.add(topPanel, BorderLayout.NORTH);
	    this.add(bodyPanel, BorderLayout.CENTER);
	    
	    setVisible(true);
	}
}
