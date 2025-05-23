package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
public class Book extends Media{
    private ArrayList<String> authors = new ArrayList<>();
    public Book(String title) {
        super();
        this.setTitle(title);
    }
    public Book(String title, String category) {
        super();
        this.setTitle(title);
        this.setCategory(category);
    }
    public Book(String title, String category, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public void addAuthor(String authorName){
        if(authors.contains(authorName)){
            System.err.println("ERROR: Author name already exist!");
        }else{
            authors.add(authorName);
        }
    }
    public void addAuthor(ArrayList<String> author) {
    	this.authors = author;
    }

    public void removeAuthor(String authorName){
        if(authors.isEmpty()){
            System.out.println("Danh sach tac gia rong");
        }
        else{
            authors.remove(authorName);
        }
    }
}
