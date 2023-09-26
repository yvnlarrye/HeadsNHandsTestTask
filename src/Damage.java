public class Damage {
    private final int m;
    private final int n;

    public Damage(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int getRandomDamage() {
        return (int) Math.floor(m + Math.random() * (Math.abs(m - n) + 1));
    }

    public static void main(String[] args) {
        Damage damage = new Damage(3, 10);
        for (int i = 0; i < 50; i++) {
            System.out.println(damage.getRandomDamage());
        }
    }

}
