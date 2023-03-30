package timtim.app.objects.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

public class Chest extends GameObject {

    public Fixture fixture;
    public Body body;
    private Texture closedTexture;
    private Texture openTexture;

    public Chest(Body body, float[] vertices, String closedImagePath, String openImagePath) {
        super(body, new Texture(closedImagePath), vertices);
        if (closedImagePath != null) {
            closedTexture = new Texture(closedImagePath);
        }

        openTexture = new Texture(openImagePath);
        fixture = body.getFixtureList().get(0);
        fixture.setUserData(this);
    }

    public Fixture getFixture() {
        return fixture;
    }

    public Body getBody() {
        return super.body;
    }

    public void open() {
        System.out.println("Chest opened!");
        super.texture = openTexture;
        if (closedTexture != null) {
            closedTexture.dispose();
            closedTexture = null;
        }
        // Additional logic to perform when the chest is opened, such as playing a sound
        // effect or spawning items
        // Simply put we need to connect to both item and inventory and with this add
        // the item to the inventory.

    }

}
