package timtim.app.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

import timtim.app.model.GameModel;

public class TileMapManager {

	private String currentMap;
	private GameModel model;
	private Map<String, GameMap> maps;

	public TileMapManager(GameModel model) {
		this.model = model;
		this.maps = new HashMap<String, GameMap>();
		loadMaps();
		setMap("level1");
	}

	public List<String> getMapNames() {
		ArrayList<String> nameList = new ArrayList<>();
		maps.keySet().addAll(nameList);
		return nameList;
	}

	/**
	 * Swaps the level
	 */
	public void swapLevels(String mapName){
		if(currentMap == "level1") setMap("level2");
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
				maps.put(mapName, new GameMap(mapName, model.getPlayer()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Update the current map.
	 */
	public void update() {
		maps.get(currentMap).update();
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
