package timtim.app.model.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import timtim.app.model.objects.Inventory.Item;

public class Chest extends GameObject {

    private boolean isOpen;
    private Item item;

    public Chest(Body body, Texture texture) {
        super(body, texture);
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

	@Override
	protected TextureRegion getFrame(float delta) {
		return sprite;
	}

	@Override
	public void update(float delta) {
		
	}
}
