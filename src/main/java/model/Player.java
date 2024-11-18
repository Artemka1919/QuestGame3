package model;

public class Player {
    private String name;
    private int health;
    private int score;

    public Player(String name) {
        this.name = name;
        this.health = 100;  // Изначальное здоровье
        this.score = 0;     // Изначальный счет
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0; // Защита от отрицательного здоровья
    }

    public void heal(int amount) {
        this.health += amount;
        if (this.health > 100) this.health = 100; // Здоровье не может превышать 100
    }

    public void addScore(int points) {
        this.score += points;
    }
}
