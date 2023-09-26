public class Player extends Creature {
    private int healsAmount = 4;
    public void heal() throws Exception {
        if (healsAmount > 0) {
            int playerHealth = getHealth();
            int newPlayerHealth = (int) (playerHealth + playerHealth * 0.3d);
            setHealth(newPlayerHealth);
            healsAmount--;
        } else {
            throw new Exception("У игрока закончились хилки");
        }
    }
}
