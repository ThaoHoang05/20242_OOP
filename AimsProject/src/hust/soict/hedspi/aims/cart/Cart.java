package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;
import src.hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Cart {

    public static final int MAX_NUMBER_ORDEREDS = 20;   //Tao final de gioi han so luong media co the co trong Cart
    private ArrayList<Media> itemsOrdered = new ArrayList<>(MAX_NUMBER_ORDEREDS);   //Tao cart


    // Them 1 item vao Cart
    public void addMedia(Media item) {
        if (itemsOrdered.size() == MAX_NUMBER_ORDEREDS) {
            System.out.println("The Cart is full");
        } else {
            itemsOrdered.add(item);
        }
    }

    //Xoa item da chon khoi Cart neu Cart rong In ra thongg bao Cart trong neu khong thuc hien xoa item khoi cart
    public void removeMedia(Media item) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The Cart is empty");
        } else {
            itemsOrdered.remove(item);
        }
    }

    //Tinh tong gia tien cua cac item co trong Cart
    public float totalCost() {
        float totalCost = 0f;
        for (Media item : itemsOrdered) {
            if (item != null) {
                totalCost += item.getCost();
            }
        }
        return totalCost;
    }

    //In ra cac item co trong cart
    public void print() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The Cart is empty");
            return;
        }
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media item : itemsOrdered) {
            System.out.println(i + ". " + item.toString());
            i++;
        }
        System.out.println("Total Cost: " + totalCost());
        System.out.println("***************************************************");
    }

    //In ra thong tin item (moi chi co truong hop neu item la DVD)
    public void display(Media item) {
        System.out.println("***************************************************");
        System.out.println("Title: " + item.getTitle());
        System.out.println("Category: " + item.getCategory());
        System.out.println("Cost: " + item.getCost());
        if (item instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) item;
            System.out.println("Director: " + dvd.getDirector());
            System.out.println("Length: " + dvd.getLength());
        }
        System.out.println("***************************************************");
    }

    /**Tim item theo ID cho truoc khi tim kiem
     *  Kiem tra xem cart co trong khong ? :
     *      Neu co tra ve thong bao "The Cart is empty"
     *      Neu khong thuc hien tim kiem item trong Cart:
     *          Neu khong tim thay tra ve thong bao "The item is not in this Cart" .
     *          Neu thay in ra thong tin cua item do.
     * @param id
     */
    public void search(int id) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The Cart is empty");
        } else {
            boolean found = false;
            for (Media item : itemsOrdered) {
                if (item.getId() == id) {
                    display(item);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("The item is not in this Cart");
            }
        }
    }
    // Tim kiem item bang title
    public void search(String title) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The Cart is empty");
        } else {
            boolean found = false;
            for (Media item : itemsOrdered) {
                if (item.getTitle().equals(title)) {
                    display(item);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("The media is not in this Cart");
            }
        }
    }

    // Sort Cart theo Id
    public void sortById(){
        itemsOrdered.sort((m1,m2)->m1.getId()-m2.getId());
        for(Media m : itemsOrdered){
            display(m);
        }
    }

    // Sort Cart theo title
    public void sortByTitle(){
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
        for(Media m : itemsOrdered){
            display(m);
        }
    }

    // xoa tat ca item khoi Cart
    public void emptyCart(){
        itemsOrdered.clear();
    }
}
