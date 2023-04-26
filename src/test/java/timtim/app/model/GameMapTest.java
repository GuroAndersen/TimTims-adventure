package timtim.app.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.World;
import timtim.app.core.GameScreen;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.Player;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class GameMapTest {

    private GameModel mockModel;
    private GameScreen mockGameScreen;
    private TmxMapLoader mockTmxMapLoader;
    private TiledMap mockTiledMap;
    private MapLayers mockMapLayers;
    private TiledMapTileLayer mockTiledMapTileLayer;
    private MapObjects mockMapObjects;
    private World mockWorld;

    @BeforeEach
    public void setUp() {

        mockModel = mock(GameModel.class);
        mockGameScreen = mock(GameScreen.class);
        mockTmxMapLoader = mock(TmxMapLoader.class);
        mockTiledMap = mock(TiledMap.class);
        mockMapLayers = mock(MapLayers.class);
        mockTiledMapTileLayer = mock(TiledMapTileLayer.class);
        mockMapObjects = mock(MapObjects.class);
        mockWorld = mock(World.class);

        when(mockModel.getGameScreen()).thenReturn(mockGameScreen);
        when(mockTmxMapLoader.load(anyString())).thenReturn(mockTiledMap);
        when(mockTiledMap.getLayers()).thenReturn(mockMapLayers);
        when(mockMapLayers.get(anyString())).thenReturn(mockTiledMapTileLayer);
        when(mockTiledMapTileLayer.getObjects()).thenReturn(mockMapObjects);
    }

    @Test
    public void testConstructorSetsMapNameAndModel() {
        String mapName = "test_map";
        GameMap gameMap = new GameMap(mapName, mockModel);

        assertEquals(mapName, gameMap.getMapName());
        assertEquals(mockModel, gameMap.getModel());
    }

    @Test
    public void testConstructorSetsPlayer() {
        Player mockPlayer = mock(Player.class);
        when(mockModel.getPlayer()).thenReturn(mockPlayer);

        String mapName = "test_map";
        GameMap gameMap = new GameMap(mapName, mockModel);

        assertEquals(mockPlayer, gameMap.getPlayer());
    }

    @Test
    public void testIsComplete() {
        String mapName = "test_map";
        GameMap gameMap = new GameMap(mapName, mockModel);
        assertFalse(gameMap.isComplete());
    }

    @Test
    public void testSetComplete() {
        String mapName = "test_map";
        GameMap gameMap = new GameMap(mapName, mockModel);
        gameMap.setComplete();
        assertTrue(gameMap.isComplete());
    }

}