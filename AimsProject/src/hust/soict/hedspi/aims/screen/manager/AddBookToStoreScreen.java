package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStore {
	private JTextField name;
	private JTextField category;
	private JTextField authors;
	private JTextField cost;
	private ArrayList<String> author;
	private static Book b;
	private static JFrame inp;
	public AddBookToStoreScreen() {
		super();
		inp = new JFrame();
		
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
	JPanel getForm() {
		JPanel form = new JPanel();
        form.setPreferredSize(new Dimension(1000, 1000));
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout());
        JLabel nameLabel = new JLabel("Name");
        name = new JTextField(50);
        namePanel.add(nameLabel);
        namePanel.add(name);
        nameLabel.setVerticalAlignment(Label.LEFT);

        JPanel categoryPanel = new JPanel();
        namePanel.setLayout(new FlowLayout());
        JLabel categoryLabel = new JLabel("Category");
        category = new JTextField(50);
        categoryPanel.add(categoryLabel);
        categoryPanel.add(category);
        categoryLabel.setVerticalAlignment(Label.LEFT);
        
        JPanel authorsPanel = new JPanel();
        authorsPanel.setLayout(new FlowLayout());
        JLabel authorsLabel = new JLabel("Author");
        authors = new JTextField(50);
        
        authorsPanel.add(authorsLabel);
        authorsPanel.add(authors);
        authorsLabel.setVerticalAlignment(Label.LEFT);

        JPanel costPanel = new JPanel();
        costPanel.setLayout(new FlowLayout());
        JLabel costLabel = new JLabel("Cost");
        cost = new JTextField(50);
        costPanel.add(costLabel);
        costPanel.add(cost);
        costLabel.setVerticalAlignment(Label.LEFT);
        
        JPanel btnPanel = new JPanel();
        JButton btn = new JButton("Submit");
        btn.addActionListener(e -> {
               try { b = new Book(name.getText(), category.getText(), Float.parseFloat(cost.getText()));
                  author = new ArrayList<String>(Arrays.asList(authors.getText().split("[^a-zA-Z\\s]+")));
                  for(String a: author) {
                	  System.out.println(a);
                  }
                  name.setText("");
                  authors.setText("");
                  category.setText("");
                  cost.setText("");
                System.out.println("Added successfully");
                inp.dispose();
                new StoreManagerScreen(b);
               }
               catch(NumberFormatException exp1) {
            	   JOptionPane.showMessageDialog(null,"Wrong input number format!","ERROR", JOptionPane.ERROR_MESSAGE);
            	   name.setText("");
                   authors.setText("");
                   category.setText("");
                   cost.setText("");
               }
               catch(NullPointerException exp2) {
            	   JOptionPane.showMessageDialog(null,"!", "ERROR", JOptionPane.ERROR_MESSAGE);
            	   name.setText("");
                   authors.setText("");
                   category.setText("");
                   cost.setText("");
               }     
        });
        btnPanel.add(btn);
        

        form.add(namePanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(categoryPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(authorsPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(costPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(btnPanel);
        return form;
	}
	public static void main(String args[]) {
		new AddBookToStoreScreen();
	}
}
