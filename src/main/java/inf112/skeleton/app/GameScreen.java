package inf112.skeleton.app;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class GameScreen extends ScreenAdapter {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private World world;

	public GameScreen(OrthographicCamera camera) {
		this.camera = camera;
	}

}
