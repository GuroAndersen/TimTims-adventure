package timtim.app.model.objects;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

public class Flora extends GameObject {

    public Fixture fixture;
    public Body body;

    public Flora(Body body) {
        super(body);
    }
    
    public int damage() {
    	return 5;
    }

}
