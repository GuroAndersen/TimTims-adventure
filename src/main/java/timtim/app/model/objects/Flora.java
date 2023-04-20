package timtim.app.model.objects;

import com.badlogic.gdx.physics.box2d.Body;

public class Flora extends GameObject {

    public Flora(Body body) {
        super(body);
    }
    
    public int damage() {
    	return 5;
    }

}
