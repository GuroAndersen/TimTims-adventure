package timtim.app.objects.GameObjects;

import org.w3c.dom.css.Rect;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.math.Rectangle;

public class GameObject {
    public Body body;
    public Texture texture;
    private Rectangle bounds;

    public GameObject(Body body, Texture texture, Rectangle bounds) {
        this.texture = texture;
        this.body = body;
        this.bounds = bounds;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
