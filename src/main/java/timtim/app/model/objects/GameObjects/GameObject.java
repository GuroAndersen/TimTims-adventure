package timtim.app.model.objects.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.math.Polygon;

public class GameObject {
    public Body body;
    public Texture texture;
    private Polygon bounds;

    public GameObject(Body body, Texture texture, float[] vertices) {
        this.texture = texture;
        this.body = body;
        this.bounds = new Polygon(vertices);
    }

    public Polygon getBounds() {
        return bounds;
    }

}
