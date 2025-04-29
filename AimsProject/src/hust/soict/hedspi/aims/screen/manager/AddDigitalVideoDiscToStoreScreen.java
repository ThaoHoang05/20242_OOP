package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.*;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStore {
	private JTextField nameField;
	private JTextField categoryField;
	private JTextField costField;
	private JTextField directorField;
	private JTextField lengthField;
	private JButton submit;
	private DigitalVideoDisc dvd;
	public AddDigitalVideoDiscToStoreScreen() {
		super();
		JFrame inp = new JFrame();

        inp.setTitle("Update Store");
        inp.setSize(800, 400);
        inp.setResizable(false);
        inp.setLayout(new BorderLayout());
        inp.add(createNorth(), BorderLayout.NORTH);
        inp.add(getForm(), BorderLayout.CENTER);
        inp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inp.setVisible(true);
		
	}
        JPanel createNorth() {
                JPanel north = new JPanel();
                north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
                north.add(createMenuBar());
                north.add(getHeader());
                return north;
        }
        JMenuBar createMenuBar() {
                JMenu menu = new JMenu("Options");

                JMenuItem viewStore = new JMenuItem("View store");
                viewStore.addActionListener(e->{

                });
                menu.add(viewStore);

                JMenu smUpdateStore = new JMenu("Update Store");
                JMenuItem addBook = new JMenuItem("Add Book");
                addBook.addActionListener(e->{

                });
                JMenuBar menuBar = new JMenuBar();
                menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
                menuBar.add(menu);
                return menuBar;
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
        btn.addActionListener(e ->{
                dvd = new DigitalVideoDisc(nameField.getText(), categoryField.getText(), directorField.getText(), Integer.parseInt(lengthField.getText()), Float.parseFloat(costField.getText()));
                nameField.setText("");
                directorField.setText("");
                categoryField.setText("");
                lengthField.setText("");
                costField.setText("");
                System.out.println("Added successfully");
                dispose();
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

        public Media getMedia() {
                if (dvd == null) {
                        JOptionPane.showMessageDialog(null, "Thông tin DVD không đầy đủ!");
                }
                return dvd;
        }
	public static void main(String args[]) {
		new AddDigitalVideoDiscToStoreScreen();
	}
}
