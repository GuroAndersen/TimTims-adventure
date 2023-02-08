package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Boot extends Game {
	
	public static Boot INSTANCE;
	private int screenWidth;
	private int screenHeight;
	private OrthographicCamera camera;

	public Boot() {
		INSTANCE = this;
	}
	
	@Override
	public void create() {
		this.screenWidth = Gdx.graphics.getWidth();
		this.screenHeight = Gdx.graphics.getHeight();
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, screenWidth, screenHeight);
		setScreen(new GameScreen(camera));
	}
	
}
