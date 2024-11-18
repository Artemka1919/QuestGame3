

import model.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testInitialHealthAndScore() {
        Player player = new Player("Герой");
        assertEquals(100, player.getHealth());
        assertEquals(0, player.getScore());
    }

    @Test
    void testTakeDamage() {
        Player player = new Player("Герой");
        player.takeDamage(10);
        assertEquals(90, player.getHealth());
    }

    @Test
    void testSetAndGetScore() {
        Player player = new Player("Герой");
        player.setScore(50);
        assertEquals(50, player.getScore());
    }

    @Test
    void testSetAndGetHealth() {
        Player player = new Player("Герой");
        player.setHealth(80);
        assertEquals(80, player.getHealth());
    }
}