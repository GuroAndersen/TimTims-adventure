package timtim.app.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Boot extends Game {

	public static Boot INSTANCE;
	private int screenW,screenH;
	private OrthographicCamera camera;
	private GameScreen gameScreen;
	private PauseScreen pauseScreen;


	public Boot() {
		INSTANCE = this;
	}

	
	@Override
	public void create() {
		this.screenW = Gdx.graphics.getWidth();
		this.screenH = Gdx.graphics.getHeight();
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, screenW, screenH);
		this.gameScreen = new GameScreen(camera, this);
		this.pauseScreen = new PauseScreen(gameScreen);
		setScreen(gameScreen);
	}

	public void pause() {
		setScreen(pauseScreen);
	}

}
