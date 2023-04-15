package timtim.app.model.objects;

import com.badlogic.gdx.physics.box2d.Body;

public class Door extends GameObject {

    private boolean isOpen;

    public Door(Body body) {
        super(body);
        isOpen = false;
    }

    public void open() {
        isOpen = true;
    }
    
    public boolean isOpen() {
    	return this.isOpen;
    }

}
