package timtim.app.objects.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;

public class Door extends GameObject {

    public Door(Body body, float x, float y, float width, float height, String imagePath) {
        super(body, new Texture(imagePath), new Rectangle(x, y, width, height));
    }

}
