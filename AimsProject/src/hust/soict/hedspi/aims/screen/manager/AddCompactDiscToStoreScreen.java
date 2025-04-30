package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;


public class AddCompactDiscToStoreScreen extends AddItemToStore{
	private static JFrame inp;
	private JTextField nameField;
	private JTextField titleField;
	private JTextField categoryField;
	private JTextField costField;
	private JTextField authorField;
	private JTextField lengthField;
	private CompactDisc cd = new CompactDisc();
	public AddCompactDiscToStoreScreen() {
		super();
		inp = new JFrame();

        inp.setTitle("Update Store");
        inp.setSize(800, 600);
        inp.setResizable(false);
        inp.setLayout(new BorderLayout());
        inp.add(super.createNorth(inp), BorderLayout.NORTH);
        inp.add(getForm(), BorderLayout.CENTER);
        inp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inp.setVisible(true);
		
	} 
	JPanel getForm(){
        JPanel form = new JPanel();
        form.setPreferredSize(new Dimension(800, 600));
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        JLabel titleLabel = new JLabel("Title");
        titleField = new JTextField(50);
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);
        titleLabel.setVerticalAlignment(Label.LEFT);

        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new FlowLayout());
        JLabel categoryLabel = new JLabel("Category");
        categoryField = new JTextField(50);
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryField);
        categoryLabel.setVerticalAlignment(Label.LEFT);
        
        JPanel directorPanel = new JPanel();
        directorPanel.setLayout(new FlowLayout());
        JLabel directorLabel = new JLabel("Artist");
        authorField = new JTextField(50);
        directorPanel.add(directorLabel);
        directorPanel.add(authorField);
        directorLabel.setVerticalAlignment(Label.LEFT);
        
        JPanel nameTrackPanel = new JPanel();
        nameTrackPanel.setLayout(new FlowLayout());
        JLabel nameTrackLabel = new JLabel("Track's Name");
        nameField = new JTextField(50);
        nameTrackPanel.add(nameTrackLabel);
        nameTrackPanel.add(nameField);
        
        JPanel lengthPanel = new JPanel();
        lengthPanel.setLayout(new FlowLayout());
        JLabel lengthLabel = new JLabel("Length(min)");
        lengthField = new JTextField(50);
        lengthPanel.add(lengthLabel);
        lengthPanel.add(lengthField);
        lengthLabel.setVerticalAlignment(Label.LEFT);

        JPanel costPanel = new JPanel();
        costPanel.setLayout(new FlowLayout());
        JLabel costLabel = new JLabel("Cost");
        costField = new JTextField(50);
        costPanel.add(costLabel);
        costPanel.add(costField);
        costLabel.setVerticalAlignment(Label.LEFT);
        
        JPanel submitTrackPanel = new JPanel();
        submitTrackPanel.setLayout(new FlowLayout());
        JButton btnTrack = new JButton("Add track");
        btnTrack.addActionListener(e -> {
               try { 
            	  cd.addTrack(new Track(nameField.getText(),Integer.parseInt(lengthField.getText()))) ;
            	  nameField.setText("");
                  lengthField.setText("");
                 System.out.println("Track is added successfully");
               }
               catch(NumberFormatException exp1) {
            	   JOptionPane.showMessageDialog(null,"Wrong input number format!","ERROR", JOptionPane.ERROR_MESSAGE);
            	   nameField.setText("");
                   lengthField.setText("");
               }
               catch(NullPointerException exp2) {
            	   JOptionPane.showMessageDialog(null,"!", "ERROR", JOptionPane.ERROR_MESSAGE);
            	   nameField.setText("");
                   lengthField.setText("");
               }     
        });
        submitTrackPanel.add(btnTrack);
        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(e -> {
        	try {
        	cd.setTitle(titleField.getText());
        	cd.setArtist(authorField.getText());
        	cd.setCost(Float.parseFloat(costField.getText()));
        	inp.dispose();
        	new StoreManagerScreen(cd);
        	System.out.println("Add successfully");
        	}catch(NullPointerException e1) {
        		System.out.println("Exception");
        	}
        	});
        submitTrackPanel.add(btnSubmit);

        form.add(titlePanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(categoryPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(directorPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(nameTrackPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(lengthPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(costPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(submitTrackPanel);
        return form;
    }
	public static void main(String args[]) {
		new AddCompactDiscToStoreScreen();
	}
}
