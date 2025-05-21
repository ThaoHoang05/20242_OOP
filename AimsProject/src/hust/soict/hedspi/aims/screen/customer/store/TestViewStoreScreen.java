package hust.soict.hedspi.aims.screen.customer.store;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
	private static Store store;
	
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		System.out.println(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStore = new ViewStoreController(store);
		fxmlloader.setController(viewStore);
		Parent root = fxmlloader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Philosopher's Stone","Fantasy","Chris Colombus" ,3.0f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Chamber of Secrets","Fantasy", "Chris Colombus",3.5f));
		store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban","Fantasy", "Chris Colombus",5.0f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Goblet of Fire", "Fantasy", "Chris Colombus", 4.5f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Order of Phoenix", "Fantasy","Chris Colombus", 6.9f));
		store.addMedia(new Book("The Hunger Game", "Fantasy",5.5f));
		store.addMedia(new Book("Catching Fire","Fiction/Fantasy/Romance",4.9f));
		store.addMedia(new Book("When the breath becomes Air", "Memoir",10.0f));
		launch(args);
	}
}
