package timtim.app.objects.Inventory;

import java.io.FileReader;
import java.util.Scanner;

public class ItemFactory {
    
    public ItemFactory (){
        Scanner sc = new Scanner(new FileReader("ItemDescription.txt"));

    }

    /**
     * en konstruktør som lager en dict/hashmap av item key og description value
     * en public Item metode som tar et item navn og returner et nytt item objekt med det navnet og riktig description
     */

    public Item produceItem (String name){
        return null;
    }
    
}
