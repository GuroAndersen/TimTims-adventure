package timtim.app.model.objects.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

import timtim.app.model.objects.Inventory.Item;

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
