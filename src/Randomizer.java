public class Randomizer {
    private Randomizer(){}
    public static int getRandIntInRange(int m, int n) {
        return Math.min(m, n) + (int) (Math.random() * (Math.max(m, n) - Math.min(m, n) + 1));
    }
}
