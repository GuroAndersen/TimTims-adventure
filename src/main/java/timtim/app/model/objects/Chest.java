package timtim.app.model.objects;

import com.badlogic.gdx.physics.box2d.Body;
import timtim.app.model.objects.inventory.Item;

public class Chest extends GameObject {

    private boolean isOpen;
    private Item item;

    public Chest(Body body) {
        super(body);
        isOpen = false;
    }
    
    public void open() {
        isOpen = true;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
