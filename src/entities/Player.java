package entities;

public class Player extends Creature {
    private int healsAmount = 4;
    public void heal() {
        if (healsAmount > 0) {
            int newPlayerHealth = getCurrentHealth() + (int) (getMaxHealth() * 0.3d);
            setCurrentHealth(Math.min(newPlayerHealth, getMaxHealth()));
            healsAmount--;
            System.out.println("Player just have gained health");
        } else {
            System.out.println("Player have no more heals!");
        }
        System.out.println(this);
        System.out.println();
    }

    public void hitMonster(Monster monster) {
        if (!this.isAlive()) {
            System.out.println("Player is dead");
            return;
        }
        if (!monster.isAlive()) {
            System.out.println("Monster is dead");
            return;
        }
        System.out.println("Player is trying to attack the monster...");
        if (super.hit(monster)) {
            System.out.println("The player hit the monster");
        } else {
            System.out.println("The player missed the monster!");
        }
    }

    @Override
    public String toString() {
        return "Player: health = " + getCurrentHealth() + "/" + getMaxHealth();
    }
}
