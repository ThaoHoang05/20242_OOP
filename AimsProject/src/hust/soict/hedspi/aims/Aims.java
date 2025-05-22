package hust.soict.hedspi.aims;


import  hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.Media;
public class Aims {
    private static Store store = new Store();
    private static Cart anOrder = new Cart();
    private static Scanner scanf = new Scanner(System.in);
    public static void showMenu() throws LimitExceededException{

        System.out.println("AIMS");
        System.out.println("--------------------------------------------------");
        System.out.println("1.View Store");
        System.out.println("2. Update Store");
        System.out.println("3. See Current Cart");
        System.out.println("0.Exit");
        System.out.println("--------------------------------------------------");
        System.out.println("Please Choose a number: 0-1-2-3");

        int option = scanf.nextInt();
        switch(option){
            case 1:
                storeMenu();
                break;
            case 2:
                boolean check = false;
                while(!check){
                    System.out.println("Choose update option (1-add and 2-remove and 0-exit):");
                    int updateOption = scanf.nextInt();
                    if(updateOption == 1){
                        System.out.println("Enter media ( title-category-cost):");
                        scanf.nextLine();
                        String title = scanf.nextLine();
                        String category = scanf.nextLine();
                        float cost = scanf.nextFloat();
                        store.addMedia(new DigitalVideoDisc(title, category, cost));
                    }else if(updateOption == 2){
                        boolean found = false;
                        System.out.println("Enter media title:");
                        String title = scanf.nextLine();
                        Media m = store.equals(title);
                        if(m != null){
                            found = true;
                            store.removeMedia(m);
                        }
                        else{
                            found = true;
                            System.out.println("Media does not exist");
                            break;
                        }

                    }else if (updateOption == 0){
                        break;
                    }
                }
                break;
            case 3:
                cartMenu();
                break;
            default:
                System.exit(0);
        }
    }

    public static void storeMenu() throws LimitExceededException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int option = scanf.nextInt();
        switch(option){
            case 1:
                boolean found = false;
                while(!found){
                    scanf.nextLine();
                    System.out.println("Enter the media title(Choose -1 to stop):");
                    String title = scanf.nextLine();
                    if(title.equals("-1")){
                        break;
                    }
                    Media m = store.equals(title);
                    if(m != null){
                        found = true;
                        System.out.println("Details: ");
                        System.out.println(m);
                        mediaDetailsMenu();
                    }
                    else{
                        found = true;
                        System.out.println("Media does not exist");
                        break;
                    }
                }
                break;
            case 2:
                found = false;
                while(!found){
                    scanf.nextLine();
                    System.out.println("Enter the media title(Choose -1 to stop):");
                    String title = scanf.nextLine();
                    if(title.equals("-1")){
                        break;
                    }
                    Media m = store.equals(title);
                    if(m != null){
                        found = true;
                        anOrder.addMedia(m);
                        System.out.println("Media added to cart");
                        anOrder.print();
                    }
                    else{
                        found = true;
                        System.out.println("Media does not exist");
                    }
                }
                break;
            case 3:
                found = false;
                while(!found){
                    scanf.nextLine();
                    System.out.println("Enter the media title(Choose -1 to stop):");
                    String title = scanf.nextLine();
                    if(title.equals("-1")){
                        break;
                    }
                    Media m = store.equals(title);
                    if(m != null){
                        found = true;
                        System.out.println("Playing "+ m.getTitle()+"......");
                    }
                    else{
                        found = true;
                        System.out.println("Media does not exist");
                    }
                }
                break;
            case 4:
                cartMenu();
                break;
            default:
                showMenu();
        }
    }

    public static void mediaDetailsMenu() throws LimitExceededException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play (only for CD and DVD)");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int option = scanf.nextInt();
        switch(option){
            case 1:
                break;
            case 2:
                break;
            default:
                storeMenu();
        }
    }

    public static void cartMenu() throws LimitExceededException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        int option = scanf.nextInt();
        switch(option){
            case 1:
                System.out.println("Choose type of filter ( 1 -id 2-title)");
                int filterType = scanf.nextInt();
                if(filterType == 1){
                    int id = scanf.nextInt();
                    anOrder.search(id);
                }
                else if(filterType == 2){
                    scanf.nextLine();
                    String title = scanf.nextLine();
                    anOrder.search(title);
                }else
                    break;
            case 2:
                System.out.println("Choose type of sort ( 1 -title 2-cost)");
                int sortType = scanf.nextInt();
                if(sortType == 1){
                    anOrder.sortById();
                }else if(sortType == 2){
                    anOrder.sortByTitle();
                }
                else
                    break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.out.println("An Order is created.");
                anOrder.emptyCart();
                break;
            default:
                showMenu();
        }
    }

    public static void main(String[] args) throws LimitExceededException{
        //TODO auto- generated method stub

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f) ;
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f) ;
        store.addMedia(dvd3);


        showMenu();
    }
}
