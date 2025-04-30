package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import hust.soict.hedspi.aims.media.CompactDisc;


public class AddCompactDiscToStoreScreen extends AddItemToStore{
	private static JFrame inp;
	private JTextField nameField;
	private JTextField categoryField;
	private JTextField costField;
	private JTextField directorField;
	private JTextField lengthField;
	private JButton submit;
	private CompactDisc cd;
	public AddCompactDiscToStoreScreen() {
		super();
		inp = new JFrame();

        inp.setTitle("Update Store");
        inp.setSize(800, 400);
        inp.setResizable(false);
        inp.setLayout(new BorderLayout());
        inp.add(super.createNorth(inp), BorderLayout.NORTH);
        inp.add(getForm(), BorderLayout.CENTER);
        inp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inp.setVisible(true);
		
	} 
	JPanel getForm(){
        JPanel form = new JPanel();
        form.setPreferredSize(new Dimension(1000, 1000));
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout());
        JLabel nameLabel = new JLabel("Name");
        nameField = new JTextField(50);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        nameLabel.setVerticalAlignment(Label.LEFT);

        JPanel categoryPanel = new JPanel();
        namePanel.setLayout(new FlowLayout());
        JLabel categoryLabel = new JLabel("Category");
        categoryField = new JTextField(50);
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryField);
        categoryLabel.setVerticalAlignment(Label.LEFT);
        
        JPanel directorPanel = new JPanel();
        directorPanel.setLayout(new FlowLayout());
        JLabel directorLabel = new JLabel("Director");
        directorField = new JTextField(50);
        directorPanel.add(directorLabel);
        directorPanel.add(directorField);
        directorLabel.setVerticalAlignment(Label.LEFT);
        
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
        
        JPanel btnPanel = new JPanel();
        JButton btn = new JButton("Submit");
        btn.addActionListener(e -> {
               try { dvd = new DigitalVideoDisc(nameField.getText(), categoryField.getText(), directorField.getText(), Integer.parseInt(lengthField.getText()), Float.parseFloat(costField.getText()));
                  nameField.setText("");
                  directorField.setText("");
                  categoryField.setText("");
                  lengthField.setText("");
                  costField.setText("");
                System.out.println("Added successfully");
                inp.dispose();
                new StoreManagerScreen(dvd);
               }
               catch(NumberFormatException exp1) {
            	   JOptionPane.showMessageDialog(null,"Wrong input number format!","ERROR", JOptionPane.ERROR_MESSAGE);
            	   nameField.setText("");
                   directorField.setText("");
                   categoryField.setText("");
                   lengthField.setText("");
                   costField.setText("");
               }
               catch(NullPointerException exp2) {
            	   JOptionPane.showMessageDialog(null,"!", "ERROR", JOptionPane.ERROR_MESSAGE);
            	   nameField.setText("");
                   directorField.setText("");
                   categoryField.setText("");
                   lengthField.setText("");
                   costField.setText("");
               }     
        });
        btnPanel.add(btn);
        

        form.add(namePanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(categoryPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(directorPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(lengthPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(costPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(btnPanel);
        return form;
    }
}
