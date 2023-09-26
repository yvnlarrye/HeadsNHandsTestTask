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
        if (defense < 1 || defense > 30) {
            throw new IllegalArgumentException("Атака не может быть меньше 1 и больше 30");
        }
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int m, int n) throws IllegalArgumentException {
        if (n < 1 || m < 1) {
            throw new IllegalArgumentException("Диапазон урона должен ограничиваться натуральными числами");
        }
        this.damage = new Damage(m, n);
    }

    public Damage getDamage() {
        return damage;
    }

    public void hit(Creature creature) {
        int attackModifier = this.attack - creature.defense + 1;

        if (attackModifier <= 0) {
            attackModifier = 1;
        }

        for (int i = 0; i < attackModifier; i++) {
            int score = Randomizer.getRandIntInRange(1,6);
            if (score == 5 || score == 6) {
                int attackerDamage = this.damage.getRandomDamage();
                creature.health -= attackerDamage;
            }
        }
    }

}
