package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Media;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStore {
	private Media m;
	
	public AddDigitalVideoDiscToStoreScreen() {
		super();
		JFrame inp = new JFrame();

        inp.setTitle("Update Store");
        inp.setSize(700, 300);
        inp.setResizable(false);
        inp.setLayout(new BorderLayout());
        inp.add(super.getHeader(), BorderLayout.NORTH);
        inp.add(super.getForm(), BorderLayout.CENTER);
        inp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inp.setVisible(true);
		
	}
	public static void main(String args[]) {
		new AddDigitalVideoDiscToStoreScreen();
	}
}
