package timtim.app.objects.Inventory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ItemFactory {

    private Map<String, String> items;
    private final String file = "/ItemDescription.txt";

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
            InputStream is = getClass().getResourceAsStream(file);
            if (is == null) {
                throw new FileNotFoundException("Resource not found: " + file);
            }
            reader = new BufferedReader(new InputStreamReader(is));
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line " + lineNumber + ": " + line);
                String[] elements = line.split(",");
                if (elements.length >= 2) {
                    String itemName = elements[0].trim();
                    String description = elements[1].trim();
                    items.put(itemName, description);
                    System.out.println("Added item: " + itemName + " - " + description);
                } else {
                    System.err.println("Error on line " + lineNumber + ": Insufficient data. Skipping line.");
                }
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + file);
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

    public Item getFirstItem() {
        if (items.isEmpty()) {
            System.err.println(
                    "Error: The items HashMap is empty. Check if the ItemDescription.txt file is read correctly.");
            return null;
        }

        for (Map.Entry<String, String> entry : items.entrySet()) {
            return new Item(entry.getKey(), entry.getValue());
        }
        return null;
    }
}
