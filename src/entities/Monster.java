package entities;

public class Monster extends Creature {
    public void hitPlayer(Player player) {
        if (!this.isAlive()) {
            System.out.println("Monster is dead");
            return;
        }
        System.out.println("Monster is trying to attack the player...");
        if (super.hit(player)) {
            System.out.println("The monster hit the player");
        } else {
            System.out.println("The monster missed the player!");
        }
    }

    @Override
    public String toString() {
        return "Monster: health = " + getCurrentHealth() + "/" + getMaxHealth();
    }
}
