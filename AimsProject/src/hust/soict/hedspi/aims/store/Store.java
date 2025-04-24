package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import java.util.ArrayList;
public class Store {

    //Tao doi tuong itemInStore
    private ArrayList<Media> itemInStore = new ArrayList<Media>();

    //Them 1 item vao store
    public void addMedia(Media item){
        if(item instanceof DigitalVideoDisc)
        {
            DigitalVideoDisc dvd = (DigitalVideoDisc) item;
            itemInStore.add(dvd);
        }
        if(item instanceof Book){
            Book book = (Book) item;
            itemInStore.add(book);
        }
    }

    //Loai bo doi tuong item khoi store truoc do kiem tra xem store co rong khong
    public void removeMedia(Media item){
        if(itemInStore.isEmpty()){
            System.out.println("Store is empty");
        }else
            itemInStore.remove(item);
    }

    //Tim item co title giong voi title dau vao roi tra ve item day ( xuat hien lan dau tien)
    public Media equals(String title){
        for(Media item : itemInStore){
            if(item.getTitle().equals(title)){
                return item;
            }
        }
        return null;
    }

    //Loc mitem bang Id neu tim thay thi tra ve item do neu khong tra ve null
    public Media filterById(int id) {
        for (Media item : itemInStore) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    //Loc item bang Title neu tim thay thi tra ve item do neu khong tra ve null
    public Media filterByTitle(String title) {
        for(Media item : itemInStore){
            if(item.getTitle().equals(title)){
                return item;
            }
        }
        return null;
    }
}
