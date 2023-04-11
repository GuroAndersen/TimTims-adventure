package timtim.app.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import timtim.app.model.GameModel;
import timtim.app.objects.Player;

public class TileMapManager {

	private String currentMap;
	private GameModel model;
	private Map<String, GameMap> maps;
	
	private Player player;

	public TileMapManager(GameModel model, Player player) {
		this.model = model;
		this.player = player;
		this.maps = new HashMap<String, GameMap>();
		loadMaps();
		setMap("level_3");
	}

	private void setMap(String mapName) {
		this.currentMap = mapName;
		model.getPlayer().setBody(maps.get(mapName).playerBody);
	}

	private void loadMaps() {
		BufferedReader reader;
		try {
			InputStream is = TileMapManager.class.getResourceAsStream("/maps.txt");
			reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			String mapName;
			while ((mapName = reader.readLine()) != null) {
				maps.put(mapName, new GameMap(mapName, model));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Update the current map.
	 */
	public void update(float delta) {
		maps.get(currentMap).update(delta);
	}

	/**
	 * Returns the current map.
	 * 
	 * @return
	 */
	public GameMap getCurrentMap() {
		return maps.get(currentMap);
	}
}
