package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.media.Playable;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

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
    public void play() {
        System.out.println("Playing DVD: " + this.title);
        System.out.println("Length: " + this.length);
    }
}
