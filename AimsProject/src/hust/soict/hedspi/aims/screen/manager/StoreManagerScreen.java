package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.screen.store.MediaStore;
import hust.soict.hedspi.aims.store.Store;


public class StoreManagerScreen extends JFrame {
	private static Store store;
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem viewStore = new JMenuItem("View store");
		menu.add(viewStore);
		viewStore.addActionListener(new ViewStore());
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(e->{

		});
		smUpdateStore.add(addBook);
		smUpdateStore.add(new JMenuItem("Add CD"));
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(e -> {
			AddDigitalVideoDiscToStoreScreen newDVD = new AddDigitalVideoDiscToStoreScreen();

			// Sau khi nhập xong
			Media media = newDVD.getMedia();
			if (media != null) {
				store.addMedia(media);
				JOptionPane.showMessageDialog(null, "DVD đã được thêm vào store!");
			}

			// Quay lại màn hình chính
			new StoreManagerScreen(store);
		});
		smUpdateStore.add(addDVD);
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
			for (int i = 0; i < store.getItemsInStore().size(); i++) {
			    if (i < mediaInStore.size()) {
			        MediaStore cell = new MediaStore(mediaInStore.get(i));
			        center.add(cell);
			    } else {
			        center.add(new JPanel()); // Thêm panel trống nếu thiếu
			    }
			}
		return center;
	}
	
	public static void main(String args[]) {
		Store store = new Store();
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Philosopher's Stone","Fantasy","Chris Colombus" ,3.0f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Chamber of Secrets","Fantasy", "Chris Colombus",3.5f));
		store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban","Fantasy", "Chris Colombus",5.0f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Goblet of Fire", "Fantasy", "Chris Colombus", 4.5f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Order of Phoenix", "Fantasy","Chris Colombus", 6.9f));
		store.addMedia(new Book("The Hunger Game", "Fantasy",5.5f));
		store.addMedia(new Book("Catching Fire","Fiction/Fantasy/Romance",4.9f));
		store.addMedia(new Book("When the breath becomes Air", "Memoir",10.0f));
		new StoreManagerScreen(store);
	}
	private class ViewStore implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			new StoreManagerScreen(store);
		}
	 }
}
