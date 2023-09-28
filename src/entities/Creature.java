package entities;

import utils.Randomizer;
import attributes.Damage;

public class Creature {
    private boolean isAlive;
    private int attack;
    private int defense;
    private int maxHealth;
    private int currentHealth;
    private Damage damage;

    public Creature() {
        this.isAlive = true;
    }

    public void setAttack(int attack) throws IllegalArgumentException {
        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("Атака не может быть меньше 1 и больше 30!");
        }
        this.attack = attack;
    }

    public void setDefense(int defense) throws IllegalArgumentException {
        if (defense < 1 || defense > 30) {
            throw new IllegalArgumentException("Атака не может быть меньше 1 и больше 30!");
        }
        this.defense = defense;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) throws IllegalArgumentException {
        if (currentHealth < 1) {
            throw new IllegalArgumentException("Здоровье должно быть натуральным числом!");
        }
        this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setDamage(int m, int n) throws IllegalArgumentException {
        if (n < 1 || m < 1) {
            throw new IllegalArgumentException("Диапазон урона должен ограничиваться натуральными числами!");
        }
        this.damage = new Damage(m, n);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void die() {
        this.isAlive = false;
    }

    protected boolean hit(Creature creature) {

        int attackModifier = this.attack - creature.defense + 1;

        if (attackModifier <= 0) {
            attackModifier = 1;
        }

        for (int i = 0; i < attackModifier; i++) {
            int score = Randomizer.getRandIntInRange(1,6);
            if (score == 5 || score == 6) {
                int attackerDamage = this.damage.getRandomDamage();
                creature.currentHealth -= attackerDamage;
                System.out.println("Hit damage = " + attackerDamage);
                if (creature.currentHealth <= 0) {
                    creature.currentHealth = 0;
                    creature.die();
                }
                return true;
            }
        }
        return false;
    }
}
