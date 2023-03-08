package timtim.app.objects;

public class Item implements IItem {

    private String itemName;

    public Item(String name) {
        this.itemName = name;
    }

    @Override
    public String getName() {
        return itemName;
    }

}
