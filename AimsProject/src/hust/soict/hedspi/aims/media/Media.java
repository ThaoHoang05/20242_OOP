package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public Media(){
    }
    public Media(String title) {
        this.title = title;
    }
    public Media(String title, String category){
        this.title = title;
        this.category = category;
    }
    public Media(String title, String category, float cost){
        this.title = title;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    @SuppressWarnings("null")
    public boolean equals(Media m){
        if(m == null) throw new NullPointerException(m.getTitle()+" does not exist.");
        else{
            
            return ((Media)m).getTitle().equals(this.getTitle()) &&((Media)m).getCost() == this.getCost();}
    }

}

