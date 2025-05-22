package hust.soict.hedspi.aims.screen.customer.store;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application {
	private static Cart cart;
	private static Store store;
	@FXML
	public void start(Stage primaryStage) throws Exception {
		final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
		System.out.println(getClass().getResource(CART_FXML_FILE_PATH));
		CartController viewCart = new CartController(cart,store);
		fxmlloader.setController(viewCart);
		Parent root = fxmlloader.load();
		
		primaryStage.setTitle("Cart");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	public static void main(String[] args) throws LimitExceededException {
		cart = new Cart();
		store = new Store();
		cart.addMedia(new DigitalVideoDisc("Harry Potter and the Philosopher's Stone","Fantasy","Chris Colombus" ,3.0f));
		cart.addMedia(new DigitalVideoDisc("Harry Potter and the Chamber of Secrets","Fantasy", "Chris Colombus",3.5f));
		cart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
		cart.addMedia(new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban","Fantasy", "Chris Colombus",5.0f));
		cart.addMedia(new DigitalVideoDisc("Harry Potter and the Goblet of Fire", "Fantasy", "Chris Colombus", 4.5f));
		cart.addMedia(new DigitalVideoDisc("Harry Potter and the Order of Phoenix", "Fantasy","Chris Colombus", 6.9f));
		cart.addMedia(new Book("The Hunger Game", "Fantasy",5.5f));
		cart.addMedia(new Book("Catching Fire","Fiction/Fantasy/Romance",4.9f));
		cart.addMedia(new Book("When the breath becomes Air", "Memoir",10.0f));
		
		launch(args);
	}
}
