package timtim.app.model.objects.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

import timtim.app.model.objects.Inventory.Item;

public class Chest extends GameObject {

    public Fixture fixture;
    public Body body;
    private Texture closedTexture;
    private Texture openTexture;
    private boolean isOpen;
    private Item item;

    public Chest(Body body, float[] vertices, String closedImagePath, String openImagePath) {
        super(body, new Texture(closedImagePath), vertices);
        if (closedImagePath != null) {
            closedTexture = new Texture(closedImagePath);
        }

        openTexture = new Texture(openImagePath);
        fixture = body.getFixtureList().get(0);
        fixture.setUserData(this);
        isOpen = false;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public Body getBody() {
        return super.body;
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
