package timtim.app.objects.Inventory;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Inventory {

    int max_size = 5;
    ArrayList<Item> items = new ArrayList <Item>();

    public int inventoryMaxSize(){
        return max_size;
    }

    public int nItemsInInventory(){
        return items.size();
    }

    public boolean contains(Item item){
        if (items.contains(item)){
            return true;
        }
        else {
            return false;
        }
        
    }
    public boolean placeInInventory(Item item){
        if (items.size()>= inventoryMaxSize()){
            return false;
        }
        else 
            items.add(item);
            return true; 
    }

    public void takeOutItem(Item item){
        if(items.contains(item)){
            items.remove(item);
        }
        else 
        throw new NoSuchElementException("Inventory does not contain this item");
    }
    
}
