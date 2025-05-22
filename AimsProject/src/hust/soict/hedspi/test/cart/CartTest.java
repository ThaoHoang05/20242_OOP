package hust.soict.hedspi.test.cart;
import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) throws LimitExceededException {
        //Create a new cart
        Cart cart = new Cart();
        //Creat new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation","Guy Ritchie",127,18.99f);
        cart.addMedia(dvd3);
        //Test print
        cart.print();
        //Test search method
        int id = 1;
        String title = "The Lion King";

        //Tim bang id
        cart.search(id);
        //Tim bang ten
        cart.search(title);

    }
}
