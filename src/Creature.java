public class Creature {
    private int attack;
    private int defense;
    private int health;
    private Damage damage;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) throws IllegalArgumentException {
        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("Атака не может быть меньше 1 и больше 30");
        }
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }
}
