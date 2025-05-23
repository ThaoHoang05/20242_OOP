package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{

    @Override
    public int getLength() {
        return super.getLength();
    }
    public DigitalVideoDisc(String title){
        super();
        super.setTitle(title);
    }

    public DigitalVideoDisc(String title, String category, float cost){
        super();
        super.setTitle(title);
        super.setCategory(category);
        super.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost){
        super();
        super.setTitle(title);
        super.setCategory(category);
        super.setCost(cost);
        super.setDirector(director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super();
        super.setTitle(title);
        super.setCategory(category);
        super.setCost(cost);
        super.setDirector(director);
        super.setLength(length);
    }

    @Override
    public String toString(){
        return "DVD - "+super.getId()+" "+super.getTitle()+" - "+super.getCategory()+" - "+super.getDirector()+" - "+ super.getLength()+": "+ super.getCost();
    }
    public boolean isMatching(String title){
        return super.getTitle().equals(title);
    }
    public boolean isMatching(int id){
        return super.getId() == id;
    }

    @Override
    public void play() throws PlayerException {
    	if(this.getLength()> 0) {
    		
    	}else throw new PlayerException("ERROR: CD length is non-positive");
    }
}

