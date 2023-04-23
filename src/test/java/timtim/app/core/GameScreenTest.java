package timtim.app.core;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import timtim.app.core.state.PlayState;
import timtim.app.core.state.State;
import timtim.app.model.objects.Player;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class GameScreenTest {

	private HeadlessApplication headlessApplication;
    private GameScreen gameScreen;
    private OrthographicCamera camera;

    @BeforeEach
    void setUp() {
        // Create a headless application configuration
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();

        // Instantiate the game screen within the context of a running headless application
        headlessApplication = new HeadlessApplication(new ApplicationAdapter() {
            @Override
            public void create() {
                gameScreen = new GameScreen(new OrthographicCamera());
            }
        }, config);
    }
    
    @AfterEach
    void tearDown() {
        // Dispose of the game screen and the headless application
        gameScreen.dispose();
        headlessApplication.exit();
    }

    @Test
    void testGameScreenCreation() {
        assertDoesNotThrow(() -> {
            // Call methods on the game screen to verify that it has been created successfully
            gameScreen.getModel();
            gameScreen.getBatch();
            gameScreen.getAtlas();
            gameScreen.getCamera();
            gameScreen.render(0f);
        });
    }
    
    

    @Test
    void testRender() {
        // Test that render method calls the render method of the current state
        gameScreen.switchState(State.PLAY);
        PlayState playStateMock = mock(PlayState.class);
        gameScreen.states.put(State.PLAY, playStateMock);
        gameScreen.render(0.1f);
        verify(playStateMock, times(1)).render(0.1f);
    }

    @Test
    void testPlayerMove() {
        // Test that playerMove method calls the move method of the player
        Player playerMock = mock(Player.class);
        when(gameScreen.getModel().getPlayer()).thenReturn(playerMock);
        gameScreen.playerMove(true, false);
        verify(playerMock, times(1)).move(true, false);
    }

    @Test
    void testPlayerJump() {
        // Test that playerJump method calls the jump method of the player
        Player playerMock = mock(Player.class);
        when(gameScreen.getModel().getPlayer()).thenReturn(playerMock);
        gameScreen.playerJump();
        verify(playerMock, times(1)).jump();
    }

    @Test
    void testUpdateCamera() {
        // Test that updateCamera method updates the camera position and binds it to the map
        Player playerMock = mock(Player.class);
        when(gameScreen.getModel().getPlayer()).thenReturn(playerMock);
        when(playerMock.getBody().getPosition()).thenReturn(new Vector2(50, 50));
        gameScreen.updateCamera();
        verify(camera, times(1)).position.set(any(Vector3.class));
        verify(camera, times(1)).update();
    }

}