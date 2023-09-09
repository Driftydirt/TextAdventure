
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Player player;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Main main = new Main();

        List<Weapon> weaponList = new ArrayList<>();
        weaponList.add(new Weapon("Storm Bolter", 0, 2));
        weaponList.add(new Weapon("Power Fist", 2, 1));

        main.player = new Player("Space Marine", 10, 4, weaponList);

        System.out.println("Welcome Brother!");
        System.out.println("May the God-Emperor Bless You!");
        System.out.println("What is your name, brother?");
        String name = input.nextLine();
        System.out.println("Welcome to the chapter, " + name + "!");
        System.out.println("The mission is to breach a infernal space hulk and cleanse it of filthy xenos.");
        System.out.println("Good luck brother.");
        main.intro();
    }

    public void intro() {

        String[] directions = { "left", "right", "forward" };
        System.out.println("Upon boarding the space hulk, you emerge into a relatively familiar scene.");
        System.out.println("The corridor of a Gothic-class cruiser greets you.");
        System.out.println("A few paces ahead there is a crossroad in the path.");
        boolean missionOver = false;
        while (!missionOver) {
            String userInput = "";
            while (!Arrays.asList(directions).contains(userInput)) {
                System.out.println("You can continue forward, or turn either left, or right.");
                userInput = input.nextLine();
                switch (userInput.toLowerCase()) {
                    case "left":
                        System.out.println("You turn left");
                        missionOver = combat("Genestealer", 1);
                        break;
                    case "right":
                        System.out.println("You turn right");
                        missionOver = combat("Genestealer", 1);
                    case "forward":
                        System.out.println("You continue forward");
                        missionOver = combat("Genestealer", 1);
                    default:
                        break;
                }
            }
        }
    }

    public boolean combat(String enemyName, int quantity) {
        System.out.println("Your Auspex shows a blip ahead, 'Enemy detected!'");
        System.out.println("Charging towards you is " + quantity + " " + enemyName);
        List<Weapon> enemyWeapons = new ArrayList<Weapon>();
        enemyWeapons.add(new Weapon("Claws", 1, 1));
        Enemy enemy = new Enemy(enemyName, 2, 2, enemyWeapons);
        boolean combatOver = false;

        while (!combatOver) {
            System.out.println("Your Turn!");
            System.out.println("You can either shoot your storm bolter, or swing your power fist");

            String userInput = input.nextLine();

            for (Weapon weapon : this.player.getWeapons()) {
                if (userInput.equals(weapon.getName().toLowerCase())) {
                    combatOver = attack(player, enemy, weapon);
                }
            }

            if (combatOver)
                break;

            combatOver = attack(enemy, player, enemy.getWeapon(0));

            if (combatOver)
                return true;

        }
        return false;

    }

    public boolean attack(Character attacker, Character defender, Weapon weapon) {
        System.out.println(attacker.getName() + " attacks with " + weapon.getName() + ".");
        int attackRoll = (int) Math.round(Math.random() * 6);
        attackRoll += weapon.getAccuracy();
        boolean dead = false;
        if (attackRoll > defender.getAC()) {
            System.out.println(attacker.getName() + "'s attack lands and causes damage.");
            dead = defender.lowerHP(weapon.getDmg());
            if (dead) {
                System.out.println(defender.getName() + " falls down dead!");
            } else {
                System.out.println(defender.getName() + " has " + defender.getHP() + "HP left.");
            }
        } else {
            System.out.println(attacker.getName() + "'s attack misses.");
        }
        return dead;
    }
}