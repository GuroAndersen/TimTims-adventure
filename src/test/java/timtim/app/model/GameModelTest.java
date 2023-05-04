package timtim.app.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.core.GameScreen;
import timtim.app.core.state.State;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.GameEntity;
import timtim.app.model.objects.Player;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameModelTest {

	
	@Mock
	private GameScreen gameScreenMock;
	
	@Mock
	private Player playerMock;

	private GameModel gameModel;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		playerMock = mock(Player.class);
		gameModel = new GameModel(gameScreenMock);
	}

	@Test
	public void testUpdate() {
		Player playerMock = mock(Player.class);
		when(playerMock.isAlive()).thenReturn(false);
		when(playerMock.getHealth()).thenReturn(0);
		when(playerMock.getBody()).thenReturn(null);

		GameMap gameMapMock = mock(GameMap.class);
		when(gameMapMock.getPlayerBody()).thenReturn(null);
		when(gameMapMock.getWorld()).thenReturn(null);
		when(gameMapMock.getEntities()).thenReturn(Arrays.asList());

		Map<String, GameMap> mapsMock = new HashMap<String, GameMap>();
		mapsMock.put("level1", gameMapMock);

		gameModel = new GameModel(gameScreenMock);
		gameModel.player = playerMock;
		gameModel.maps = mapsMock;
		gameModel.swapLevel("level1");
		gameModel.update(0.1f);

		verify(playerMock).update(0.1f);
		verify(gameMapMock).update(0.1f);
		verify(gameScreenMock).switchState(State.GAMEOVER);
		verify(gameMapMock).restart();
		verify(playerMock).resetHealth();
	}

	@Test
	public void testGetMapRenderer() {
		GameMap gameMapMock = mock(GameMap.class);
		when(gameMapMock.getMapRenderer()).thenReturn(mock(OrthogonalTiledMapRenderer.class));
		Map<String, GameMap> mapsMock = new HashMap<String, GameMap>();
		mapsMock.put("level1", gameMapMock);
		gameModel.player = playerMock;
		gameModel.maps = mapsMock;
		gameModel.swapLevel("level1");

		assertNotNull(gameModel.getMapRenderer());
	}
	
    @Test
    public void testPlayerMove() {
        // given
        boolean left = true;
        boolean right = false;

        Player playerMock = mock(Player.class);
        gameModel.player = playerMock;

        // when
        gameModel.playerMove(left, right);

        // then
        verify(playerMock, times(1)).move(left, right);
    }
    
    @Test
    public void testGetGameScreen() {
        // when
        GameScreen gameScreen = gameModel.getGameScreen();

        // then
        assertEquals(gameScreenMock, gameScreen);
    }
    
    @Test
    public void testGetCurrentWorld() {
    	
    	// given
    	GameMap gameMapMock = mock(GameMap.class);
		Map<String, GameMap> mapsMock = new HashMap<String, GameMap>();
		mapsMock.put("level1", gameMapMock);

		gameModel = new GameModel(gameScreenMock);
		gameModel.player = playerMock;
		gameModel.maps = mapsMock;
		gameModel.swapLevel("level1");
        World worldMock = new World(new Vector2(0,0), false);
        when(gameMapMock.getWorld()).thenReturn(worldMock);

        // when
        World currentWorld = gameModel.getCurrentWorld();

        // then
        assertEquals(worldMock, currentWorld);
    }
    
    @Test
    public void testGetMapNames() {
        // given
    	GameMap gameMapMock = mock(GameMap.class);
		Map<String, GameMap> mapsMock = new HashMap<String, GameMap>();
		mapsMock.put("map1", gameMapMock);
		mapsMock.put("map2", gameMapMock);
		mapsMock.put("map3", gameMapMock);
		gameModel.maps = mapsMock;
    	
    	List<String> expectedMapNames = Arrays.asList("map1", "map2", "map3");
        
        // when
    	for (String map : gameModel.getMapNames()) {
    		assertTrue(expectedMapNames.contains(map));
    	}
    }
    
    @Test
    public void testPlayerJump() {
    	// given
    	GameMap gameMapMock = mock(GameMap.class);
		Map<String, GameMap> mapsMock = new HashMap<String, GameMap>();
		mapsMock.put("level1", gameMapMock);

		gameModel = new GameModel(gameScreenMock);
		gameModel.player = playerMock;
		gameModel.maps = mapsMock;
		gameModel.swapLevel("level1");
        World worldMock = new World(new Vector2(0,0), false);
        when(gameMapMock.getWorld()).thenReturn(worldMock);
    	
        Body playerBodyMock = mock(Body.class);
        gameModel.getPlayer().setBody(playerBodyMock);

        gameModel.playerJump();

        verify(playerMock).jump();
        assertEquals(worldMock, gameModel.getCurrentWorld());
    }
    
    
}