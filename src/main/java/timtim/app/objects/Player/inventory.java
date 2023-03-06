package timtim.app.objects.Player;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class inventory {

    int max_size = 5;
    ArrayList<Items> items = new ArrayList <Items>();

    public int inventoryMaxSize(){
        return max_size;
    }

    public int nItemsInInventory(){
        return items.size();
    }

    public boolean placeInInventory(Items item){
        if (items.size()>= inventoryMaxSize()){
            return false;
        }
        else 
            items.add(item);
            return true; 
    }

    public void takeOutItem(Items item){
        if(items.contains(item)){
            items.remove(item);
        }
        else 
        throw new NoSuchElementException("Inventory does not contain this item");
    }
    
}
