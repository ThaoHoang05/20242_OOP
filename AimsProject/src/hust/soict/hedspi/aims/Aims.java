package hust.soict.hedspi.aims;


import  hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import java.util.Scanner;
public class Aims {
    private static Store store = new Store();
    private static Cart anOrder = new Cart();
    private static Scanner scanf = new Scanner(System.in);
    public static void showMenu() throws Exception{

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
            default:
                System.exit(0);
        }
    }

    public static void storeMenu() throws Exception {
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
        try {
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
			                mediaDetailsMenu(m);
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
			                if(m instanceof Playable){
			                    try {
			                        ((Playable)m).play();
			                    } catch (PlayerException e) {
			                    	e.getMessage();
			                        e.printStackTrace();
			                    }
			                }
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static void mediaDetailsMenu(Media m) throws Exception {
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
            	anOrder.addMedia(m);
            	System.out.println(m.getTitle()+" them vao thanh cong.");
                break;
            case 2:
                if(m instanceof Playable) {
                	((Playable)m).play();
                }
            default:
                storeMenu();
        }
    }

    public static void cartMenu() throws Exception {
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
        OUTER:
        OUTER_1:
        switch (option) {
            case 1 -> {
                System.out.println("Choose type of filter ( 1 -id 2-title)");
                int filterType = scanf.nextInt();
                switch (filterType) {
                    case 1 -> {
                        int id = scanf.nextInt();
                        anOrder.search(id);
                    }
                    case 2 -> {
                        scanf.nextLine();
                        String title = scanf.nextLine();
                        anOrder.search(title);
                    }
                    default -> {
                        break OUTER_1;
                    }
                }
            }

            case 2 -> {
                System.out.println("Choose type of sort ( 1 -title 2-cost)");
                int sortType = scanf.nextInt();
                switch (sortType) {
                    case 1:
                        anOrder.sortById();
                        break;
                    case 2:
                        anOrder.sortByTitle();
                        break;
                    default:
                        break OUTER;
                }
            }
            case 3 -> {
            	int choice;

                do {
                    System.out.println("Choose your media that you want to remove (1 - id; 2 - title; 0 - exit):");
                    choice = scanf.nextInt();
                    
                    if (choice == 1) {
                        System.out.println("Enter the media ID to remove:");
                        int id = scanf.nextInt();
                        Media m = (Media)anOrder.search(id);
                        if(m != null) {
                        System.out.println("Removing media with ID: " + id);
                        anOrder.removeMedia(m);
                        }else throw new Exception(id +" khong ton tai!");
                    } else if (choice == 2) {
                        scanf.nextLine(); // Xử lý dòng mới còn sót lại
                        System.out.println("Enter the media title to remove:");
                        String title = scanf.nextLine();
                        Media m = anOrder.search(title);
                        if(m != null) {
                        System.out.println("Removing media with title: " + title);
                        anOrder.removeMedia(m);
                        }
                        else throw new Exception(title+" khong ton tai!");
                    } else if (choice == 0) {
                        System.out.println("Exiting...");
                    } else {
                        System.out.println("Invalid choice. Please select 1, 2, or 0 to exit.");
                    }
                } while (choice != 0); 	
            }
            case 4 -> {
            	int choice;

                do {
                    System.out.println("Choose your media that you want to play (1 - id; 2 - title; 0 - exit):");
                    choice = scanf.nextInt();
                    
                    if (choice == 1) {
                        System.out.println("Enter the media ID to remove:");
                        int id = scanf.nextInt();
                        Media m = (Media)anOrder.search(id);
                        if(m != null) {
                        	if(m instanceof Playable) {
                        	if(((Playable) m).getLength() > 0) {
                        System.out.println("Playing media with ID: " + m.getTitle());
                        	}else {
                        		throw new PlayerException();
                        	}
                        	}else throw new Exception(m.getTitle()+" khong the play duoc");
                        	
                        }else throw new Exception(id +" khong ton tai!");
                    } else if (choice == 2) {
                        scanf.nextLine(); // Xử lý dòng mới còn sót lại
                        System.out.println("Enter the media title to remove:");
                        String title = scanf.nextLine();
                        Media m = anOrder.search(title);
                        if(m != null) {
                        	if(m instanceof Playable) {
                            	if(((Playable) m).getLength() > 0) {
                            System.out.println("Playing media with ID: " + title);
                            	}else {
                            		throw new PlayerException();
                            	}
                            	}else throw new Exception(m.getTitle()+" khong the play duoc");
                        }
                        else throw new Exception(title+" khong ton tai!");
                    } else if (choice == 0) {
                        System.out.println("Exiting...");
                    } else {
                        System.out.println("Invalid choice. Please select 1, 2, or 0 to exit.");
                    }
                } while (choice != 0);
            }
            case 5 -> {
                System.out.println("An Order is created.");
                anOrder.emptyCart();
            }
            default -> showMenu();
        }
    }

    public static void main(String[] args) throws Exception{
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
