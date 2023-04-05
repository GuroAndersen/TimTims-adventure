package timtim.app.objects.Inventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    
    static private final String file = "ItemDescription.txt";

    public ItemFactory (){
        parseItemFile();
    }

    /**
     * parses the textfile into a hashmap, with the values itemname and description
     */
    static private Map<String, String> parseItemFile() {
        Map<String, String> items = new HashMap<String,String>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line; 
            while ((line = reader.readLine()) != null){
                String[] elements = line.split(",");
                String itemName = elements[0].trim();
                String description = elements[1].trim();
                items.put(itemName, description);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
    /**
     * returns a new item with name and description
     * if the item does not exist, throw an exception
     * @param itemName
     * @throws IllegalArgumentException
     * @return
     */
    public static Item newItem (String itemName){
    	Map<String, String> items = parseItemFile();
    	if (!items.containsKey(itemName)) throw new IllegalArgumentException("This item is not listed in ItemDescription");
        return new Item(itemName, parseItemFile().get(itemName));
    }

}
