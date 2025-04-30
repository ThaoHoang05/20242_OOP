package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Media;

public abstract class AddItemToStore extends JFrame{	
	private JFrame inp;
	public AddItemToStore() {
		this.inp = new JFrame();
	}
	 JPanel createNorth(JFrame input) {
         JPanel north = new JPanel();
         north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
         north.add(createMenuBar(input));
         north.add(getHeader());
         return north;
	 }
	 JMenuBar createMenuBar(JFrame input) {
         JMenu menu = new JMenu("Options");

         JMenuItem viewStore = new JMenuItem("View store");
         viewStore.addActionListener(e->{ 
         			input.dispose();
         			new StoreManagerScreen();
         		
         });
         menu.add(viewStore);
         
         JMenuBar menuBar = new JMenuBar();
         menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
         menuBar.add(menu);
         return menuBar;
	 	}
	 	JPanel getHeader(){
        JPanel header = new JPanel();
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font("Arial", Font.PLAIN, 50));
        header.add(title, BorderLayout.CENTER);
        return header;
	 	}
	
	JPanel getForm(){
        JPanel form = new JPanel();
        form.setPreferredSize(new Dimension(500, 200));
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout());
        JLabel nameLabel = new JLabel("Name");
        JTextField nameField = new JTextField(50);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        nameLabel.setVerticalAlignment(Label.LEFT);

        JPanel categoryPanel = new JPanel();
        namePanel.setLayout(new FlowLayout());
        JLabel categoryLabel = new JLabel("Category");
        JTextField categoryField = new JTextField(50);
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryField);
        categoryLabel.setVerticalAlignment(Label.LEFT);

        JPanel costPanel = new JPanel();
        costPanel.setLayout(new FlowLayout());
        JLabel costLabel = new JLabel("Cost");
        JTextField costField = new JTextField(50);
        costPanel.add(costLabel);
        costPanel.add(costField);
        costLabel.setVerticalAlignment(Label.LEFT);

        form.add(namePanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(categoryPanel);
        form.add(Box.createRigidArea(new Dimension(0, 5)));
        form.add(costPanel);
        return form;
    }
}
