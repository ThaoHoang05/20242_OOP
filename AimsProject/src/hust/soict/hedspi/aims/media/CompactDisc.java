package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable{
    public CompactDisc(){
        super();
    }
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }
    public CompactDisc(String artist){
        super();
        this.artist = artist;
    }
    public CompactDisc(String artist, String title){
        super();
        this.artist = artist;
        super.setTitle(title);
    }
    public void setTilte(String Title) {
    	super.setTitle(Title);
    }
    public void setArtist(String artist) {
    	this.artist = artist;
    }
    public void addTrack(Track track){
        boolean found = false;
        for(Track t : tracks){
            if(t.getTitle().equals(track.getTitle())){
                found = true;
                break;
            }
        }
        if(!found)tracks.add(track);
    }
    public void removeTrack(Track track){
        if(!tracks.isEmpty()){
            tracks.remove(track);
        }
    }
    public int getLength(){
        int sum = 0;
        for(Track t : tracks){
            try{
                sum += t.getLength();
            }
            catch(NullPointerException e){
                continue;
            }
        }
        return sum;
    }

    @Override
    public void play() throws PlayerException{
        if(this.getLength() > 0){
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()){
                nextTrack = (Track) iter.next();
                try{
                    nextTrack.play();
                }catch(PlayerException e){
                    throw e;
                }
            }
        }else{
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
}
