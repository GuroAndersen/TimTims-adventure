package timtim.app.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.core.GameScreen;
import timtim.app.core.state.State;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.GameEntity;
import timtim.app.model.objects.Player;
import timtim.app.model.sound.SoundEffect;

public class GameModel implements IGameModel {

	private GameScreen gameScreen;
	private Player player;

	// maps
	private String currentMap;
	private Map<String, GameMap> maps;
	//sound hashmap
	private static HashMap<SoundEffect, AudioInputStream> soundStreams = new HashMap<>();

	/**static {
        try {
            soundStreams.put(SoundEffect.CHEST, AudioSystem.getAudioInputStream(new File("resources/mixkit-casino-bling-achievement-2067.wav")));
            soundStreams.put(SoundEffect.HIT, AudioSystem.getAudioInputStream(new File("resources/mixkit-small-hit-in-a-game-2072.wav")));
            soundStreams.put(SoundEffect.GAMEOVER, AudioSystem.getAudioInputStream(new File("resources/mixkit-player-losing-or-failing-2042.wav")));
        } catch (Exception e) {
            System.err.println("Error loading sound files: " + e.getMessage());
        }
    }*/

	static{
		try {
		soundStreams.put(SoundEffect.CHEST, AudioSystem.getAudioInputStream(new File("resources/mixkit-small-hit-in-a-game-2072.wav")));
	} catch (UnsupportedAudioFileException | IOException e) {
		((Throwable) e).printStackTrace();
		}
	}

	public GameModel(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		this.player = new Player(gameScreen);
		this.maps = new HashMap<String, GameMap>();
		setup();
	}

	private void setup() {
		loadMaps();
		setMap("level2");
	}

	@Override
	public void update(float delta) {
		this.player.update(delta);
		this.maps.get(currentMap).update(delta);

		if (!this.player.isAlive()) {
			gameScreen.switchState(State.GAMEOVER);
			getCurrentMap().restart();
			player.resetHealth();
		}
	}

	///////// MAP METHODS
	private void loadMaps() {
		BufferedReader reader;
		try {
			InputStream is = GameModel.class.getResourceAsStream("/maps.txt");
			reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			String mapName;
			while ((mapName = reader.readLine()) != null) {
				maps.put(mapName, new GameMap(mapName, this));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GameMap getCurrentMap() {
		return maps.get(currentMap);
	}

	private void setMap(String mapName) {
		this.currentMap = mapName;
		getPlayer().setBody(maps.get(mapName).getPlayerBody());
		this.player.resetHealth();
	}

	@Override
	public void swapLevel(String level) {
		setMap(level);
	}

	@Override
	public Iterable<String> getMapNames() {
		return maps.keySet();
	}

	@Override
	public OrthogonalTiledMapRenderer getMapRenderer() {
		return getCurrentMap().getMapRenderer();
	}

	
	///////// GETTERS
	
	@Override
	public List<GameEntity> getEntities() {
		List<GameEntity> entities = getCurrentMap().getEntities();
		entities.add(getPlayer());
		return entities;

	}

	@Override
	public World getCurrentWorld() {
		return this.getCurrentMap().getWorld();
	}

	public GameScreen getGameScreen() {
		return this.gameScreen;
	}

	@Override
	public Player getPlayer() {
		return this.player;
	}

	
	/////// PLAYER

	@Override
	public void playerMove(boolean left, boolean right) {
		this.player.move(left, right);
	}

	@Override
	public void playerJump() {
		this.player.jump();
	}

	///Sound
	@Override
	public void playSound(SoundEffect state) {
		try{
		Clip clip = AudioSystem.getClip();
		clip.open(soundStreams.get(state));
		clip.start();
		}
		catch (Exception e){
			System.err.println("Error playing sound: " + e.getMessage());
		}

	}

}
