package attributes;

import utils.Randomizer;

public class Damage {
    private final int m;
    private final int n;

    public Damage(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int getRandomDamage() {
        return Randomizer.getRandIntInRange(m, n);
    }
}
