package timtim.app.objects.Inventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ItemFactory {

    public Map<String, String> items;
    private final String file = "ItemDescription.txt";

    public ItemFactory() {
        items = new HashMap<String, String>();
        parseItemFile();
    }

    /**
     * parses the textfile into a hashmap, with the values itemname and description
     */
    private void parseItemFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split(",");
                String itemName = elements[0].trim();
                String description = elements[1].trim();
                items.put(itemName, description);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * returns a new item with name and description
     * 
     * @param itemName
     * @return
     */
    public Item newItem(String itemName) {
        return new Item(itemName, items.get(itemName));
    }
}
