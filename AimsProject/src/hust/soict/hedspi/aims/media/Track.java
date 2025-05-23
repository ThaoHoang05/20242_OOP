package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    @Override
    public int getLength() {
        return length;
    }
    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }
    public Track(String title){
        this.title = title;
    }
    public boolean equals(Track t){
        return this.title.contains(t.getTitle()) && this.getLength() == t.getLength();
    }

    @Override
    public void play() throws PlayerException{
        if(this.getLength() > 0){
        System.out.println("Playing DVD: " + this.title);
        System.out.println("Length: " + this.length);
    } else throw new PlayerException("ERROR: track length is non-positive!");
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
