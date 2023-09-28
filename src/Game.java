import entities.Monster;
import entities.Player;

public class Game {
    public Player createPlayer(int health, int attack, int defense, int damageM, int damageN) {
        Player p = new Player();
        try {
            p.setCurrentHealth(health);
            p.setMaxHealth(health);
            p.setAttack(attack);
            p.setDefense(defense);
            p.setDamage(damageM, damageN);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    public Monster createMonster(int health, int attack, int defense, int damageM, int damageN) {
        Monster monster = new Monster();
        try {
            monster.setCurrentHealth(health);
            monster.setMaxHealth(health);
            monster.setAttack(attack);
            monster.setDefense(defense);
            monster.setDamage(damageM, damageN);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return monster;
    }

    public static void main(String[] args) {
        Game game = new Game();

        //checking incorrect attack input reaction
        try {
            game.createPlayer(20, 0, 3, 1, 6);
        } catch (Exception e) {
            System.out.println("Error occurred while creating creature\n" + e.getMessage());
        }

        //checking incorrect defense input checking
        try {
            game.createPlayer(20, 5, 31, 1, 6);
        } catch (Exception e) {
            System.out.println("Error occurred while creating creature\n" + e.getMessage());
        }

        //checking incorrect health input reaction
        try {
            game.createPlayer(-3, 5, 3, 1, 6);
        } catch (Exception e) {
            System.out.println("Error occurred while creating creature\n" + e.getMessage());
        }

        //checking incorrect attack input reaction
        try {
            game.createPlayer(20, 5, 3, -6, 0);
        } catch (Exception e) {
            System.out.println("Error occurred while creating creature\n" + e.getMessage());
        }

        System.out.println();


        Player player = game.createPlayer(20, 5, 3, 1, 6);
        System.out.println(player);
        Monster monster = game.createMonster(50, 3, 2, 1, 10);
        System.out.println(monster);
        System.out.println();

        while (player.isAlive() && monster.isAlive()) {
            player.hitMonster(monster);
            System.out.println(monster);
            System.out.println();

            monster.hitPlayer(player);
            System.out.println(player);
            System.out.println();

            if (player.getCurrentHealth() <= 10) {
                player.heal();
            }
        }
        if (player.isAlive()) {
            System.out.println("Player won! Health = " + player.getCurrentHealth());
        }
        if (monster.isAlive()) {
            System.out.println("Monster won! Health = " + monster.getCurrentHealth());
        }
    }
}
