import model.Game;
import model.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testInitialGameState() {
        Player player = new Player("Герой");
        Game game = new Game(player);
        assertEquals("start", game.getCurrentRoom());
        assertFalse(game.isGameOver());
    }

    @Test
    void testMoveToRoom() {
        Player player = new Player("Герой");
        Game game = new Game(player);
        game.moveToRoom("forest");
        assertEquals("forest", game.getCurrentRoom());
        assertEquals("Вы вошли в лес. Здесь темно и жутко.", game.getMessage());
    }

    @Test
    void testAttack() {
        Player player = new Player("Герой");
        Game game = new Game(player);
        game.attack();
        assertEquals(90, player.getHealth());
        assertEquals("Вы атаковали врага и получили 10 урона.", game.getMessage());
    }

    @Test
    void testGameOver() {
        Player player = new Player("Герой");
        Game game = new Game(player);
        for (int i = 0; i < 10; i++) {
            game.attack();
        }
        assertTrue(game.isGameOver());
        assertEquals("Вы атаковали врага, но получили смертельный урон. Игра окончена.", game.getMessage());
    }

    @Test
    void testHeal() {
        Player player = new Player("Герой");
        Game game = new Game(player);
        player.setHealth(50);
        game.heal();
        assertEquals(70, player.getHealth());
        assertEquals("Вы использовали лечебное зелье и восстановили 20 здоровья.", game.getMessage());
    }

    @Test
    void testAddPoints() {
        Player player = new Player("Герой");
        Game game = new Game(player);
        game.addPoints();
        assertEquals(10, player.getScore());
        assertEquals("Вы нашли спрятанный сундук и получили 10 очков.", game.getMessage());
    }
}
