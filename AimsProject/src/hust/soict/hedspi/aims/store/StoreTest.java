package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Snow White","Drama","Marc Webb",109,20.00f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Amateur", "Mystery & Thriller", "James Hawes",124,30.00f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd4);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin", "Animation","Guy Ritchie",127,18.99f);
        store.addMedia(dvd5);
        store.removeMedia(dvd2);
    }
}