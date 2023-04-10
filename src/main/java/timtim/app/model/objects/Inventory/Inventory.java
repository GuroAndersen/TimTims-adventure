package timtim.app.model.objects.Inventory;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Inventory {

    private int max_size = 5;
    private ArrayList<Item> items = new ArrayList <Item>();

    /**
    * returns the max size of the inventory
    * @return
    */
    public int inventoryMaxSize(){
        return max_size;
    }

    /**
     * returns the number of items in inventory
     * @return
     */
    public int nItemsInInventory(){
        return items.size();
    }

    /**
     * checks if inventory contains a certain item
     * @param item
     * @return
     */

    public boolean contains(Item item){
        if (items.contains(item)){
            return true;
        }
        else {
            return false;
        }
        
    }

    /**
     * places an item into inventory if inventory is not at max capacity
     * @param item
     * @return
     */
    public boolean placeInInventory(Item item){
        if (items.size()>= inventoryMaxSize()){
            return false;
        }
        else 
            items.add(item);
            return true; 
    }

    /**
     * takes out an item from inventory if the item is in inventory
     * @param item
     */
    public void takeOutItem(Item item){
        if(items.contains(item)){
            items.remove(item);
        }
        else 
        throw new NoSuchElementException("Inventory does not contain this item");
    }
    
}
