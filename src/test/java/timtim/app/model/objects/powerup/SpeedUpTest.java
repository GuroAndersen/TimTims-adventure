package timtim.app.model.objects.powerup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import timtim.app.model.objects.Player;

public class SpeedUpTest {

    private Player player;
    private SpeedUp speedUp;

    @BeforeEach
    public void setUp() {
        player = new Player(100, 10);
        speedUp = new SpeedUp();
    }

    @Test
    public void testSpeedUpEffect() {
        float initialSpeed = player.getSpeed();
        speedUp.doPowerupIfActive(player);
        float newSpeed = player.getSpeed();

        assertEquals(initialSpeed + 2, newSpeed);
    }


}
