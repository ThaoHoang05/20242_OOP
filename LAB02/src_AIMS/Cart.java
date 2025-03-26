public class Cart {
    public static final int MAX_NUMBER_ORDEREDS = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBER_ORDEREDS];
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_NUMBER_ORDEREDS){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println(disc.getTitle()+" is added to cart");
        }
        else{
            System.out.println("The Cart is full");
        }
    }

    public void addDigitalVideoDiscs(DigitalVideoDisc[] discList){
        for(DigitalVideoDisc disc: discList){
            addDigitalVideoDisc(disc);
        }
    }

    // public void addDigitalVideoDiscs(DigitalVideoDisc ... discs){
      //  for(DigitalVideoDisc disc: discs){
        //    addDigitalVideoDisc(disc);
        //}
    //}

    public void addDigitalVideoDiscs(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }


    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean isFound = false;
        if(qtyOrdered == 0){
            System.out.println("The Cart is empty");
        }
        else{
            for(int i = 0; i < qtyOrdered; i++){
                if(disc == itemsOrdered[i]){
                    isFound = true;
                    for(int j = i; j < qtyOrdered -1; j++){
                        itemsOrdered[j] = itemsOrdered[j+1];
                    }
                    itemsOrdered[qtyOrdered-1] = null;
                    qtyOrdered--;
                    System.out.println(disc.getTitle()+" is removed from cart");
                }
            }
            if(!isFound){
                System.out.println(disc.getTitle()+" is not in this Cart");
            }
        }
    }

    public float totalCost(){
      float totalCost = 0f;
        for(DigitalVideoDisc disc: itemsOrdered){
            if(disc != null) totalCost += disc.getCost();
        }
        return totalCost;
    }

    public void printDvdID(DigitalVideoDisc disc){
        System.out.println(disc.getId());
    }
}
