package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.media.Media;

public abstract class Disc extends Media {
    private int length;
    private String director;
    public Disc(){
        super();
    }
    public Disc(String title, String category, float cost){
        super(title, category, cost);
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getDirector() {
        return director;
    }
    public Disc(String director, int length){
        this.length = length;
        this.director = director;
    }
    public Disc(String title, String director,int length){
        super(title);
        this.length = length;
        super.setTitle(title);
        this.director = director;
    }
    public Disc(String title, String category, String director,int length){
        super(title, category);
        this.length = length;
        super.getTitle();
        this.director = director;
        super.setCategory(category);
    }
    public Disc(String title, String category, String director,int length, float cost){
        super(title, category, cost);
        this.length = length;
        super.setTitle(title);
        this.director = director;
        super.setCategory(category);
        super.setCost(cost);
    }
}
