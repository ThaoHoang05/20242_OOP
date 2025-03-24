public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
    	for(DigitalVideoDisc dvd: dvdList) {
    		this.addDigitalVideoDisc(dvd);
    	}
    }


 //   public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
 //       for (DigitalVideoDisc dvd : dvds) {
 //           this.addDigitalVideoDisc(dvd); 
 //       }
 //   }
 //  Khong them duocduoc phuong thuc nay vao do IDE khong phan biet giua varargs va mang ??

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED - 1) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The discs have been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered == 0){
            System.out.println("The cart is empty");
        }
        else{
            for(int i = 0; i < qtyOrdered; i++){
                if(disc == itemsOrdered[i]){
                    for(int j = i; j < qtyOrdered - 1; j++){
                        itemsOrdered[j] = itemsOrdered[j + 1];
                    }
                }
            }
            System.err.println(disc.getTitle() +" has been removed");
            qtyOrdered--;
        }
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
