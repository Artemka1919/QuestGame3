package model;

public class Game {
    private Player player;
    private String currentRoom;
    private String message;
    private boolean gameOver;

    public Game(Player player) {
        this.player = player;
        this.currentRoom = "start";  // Начальная комната
        this.message = "Вы находитесь в комнате 'начало'.";
        this.gameOver = false; // Игра не завершена
    }

    public Player getPlayer() {
        return player;
    }

    public String getCurrentRoom() {
        return currentRoom;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void moveToRoom(String room) {
        if (gameOver) {
            message = "Игра завершена. Вы проиграли.";
            return;
        }
        this.currentRoom = room;
        switch (room) {
            case "start":
                message = "Вы находитесь в комнате 'начало'.";
                break;
            case "forest":
                message = "Вы вошли в лес. Здесь темно и жутко, вы встретили стаю Волков!";
                break;
            case "cave":
                message = "Вы в пещере. Стены покрыты мхом, перед вами Медведь!";
                break;
            default:
                message = "Комната не найдена.";
                break;
        }
    }

    public String getMessage() {
        return message;
    }

    public void attack() {
        if (gameOver) {
            message = "Игра завершена. Вы проиграли.";
            return;
        }
        player.takeDamage(10);
        if (player.getHealth() <= 0) {
            gameOver = true;
            message = "Вы атаковали врага, но получили смертельный урон. Игра окончена.";
        } else {
            message = "Вы атаковали врага и получили 10 урона.";
        }
    }

    public void heal() {
        if (gameOver) {
            message = "Игра завершена. Вы проиграли.";
            return;
        }
        player.heal(20);  // Лечим игрока на 20 здоровья
        message = "Вы использовали лечебное зелье и восстановили 20 здоровья.";
    }

    public void addPoints() {
        if (gameOver) {
            message = "Игра завершена. Вы проиграли.";
            return;
        }
        player.addScore(10); // Добавляем 10 очков за успешное действие
        message = "Вы нашли спрятанный сундук и получили 10 очков.";
    }
}