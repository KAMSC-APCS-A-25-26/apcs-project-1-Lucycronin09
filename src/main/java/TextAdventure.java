import java.util.Scanner;
import java.util.Random;

// player class for ease of making new characters
class Player {
    // attributes of a character
    String name;
    int health;
    String dndClass;
    String race;
    int baseAttack;
    String weapon;
    int stealth;
    int playerDamageDealt = 0;

    // player dice
    int rollNSidedDice(int sides) {
        Random rand = new Random();
        return rand.nextInt(sides) + 1;
    }

    // player attack
    void attack() {
        playerDamageDealt += baseAttack + (int) (baseAttack * (rollNSidedDice(20)) / 10);
    }

    // player constructor
    public Player() {
        // introductory dialogue to create a new Player Character
        Scanner sc = new Scanner(System.in);
        System.out.println("You awake feeling startled, realizing you passed out at the bar again.");
        System.out.println("\"Hello there traveler, Welcome to our world. What is your name?\": ");
        name = sc.nextLine();
        System.out.println("\"Ahh, fine name for a fine... what are you exactly? (race)\": ");
        race = sc.next();
        System.out.println("\"Just as expected. Now, what would you like to specialize in? (Rogue, Wizard, Barbarian, Druid, or Ranger)\":");
        dndClass = sc.next();
        System.out.println();


        // class stats
        switch (dndClass.toLowerCase()) {
            case ("rogue"):
            {
                baseAttack = 6;
                health = 15;
                stealth = 10;
                weapon = "dagger";
                break;
            }

            case ("wizard"):
            {
                baseAttack = 5;
                health = 18;
                stealth = 4;
                weapon = "staff";
                break;
            }

            case ("barbarian"):
            {
                baseAttack = 7;
                health = 20;
                stealth = 1;
                weapon = "axe";
                break;
            }

            case ("druid"):
            {
                baseAttack = 3;
                health = 25;
                stealth = 6;
                weapon = "magic";
                break;
            }

            case ("ranger"):
            {
                baseAttack = 10;
                health = 10;
                stealth = 7;
                weapon = "bow";
                break;
            }

            default:
            {
                dndClass = "Average Joe";
                baseAttack = 1;
                health = 10;
                stealth = 3;
                break;
            }



        }
    }


}

// enemy class to help easily make new foes
class Enemy {

    // enemy dice
    int rollNSidedDice(int sides) {
        Random rand = new Random();
        return rand.nextInt(sides) + 1;
    }

    // enemy variable declarations
    Random rand = new Random();
    // enemy attributes
    String type;
    int health;
    int baseDamage;
    int enemyDamageDealt = 0;
    boolean status = true;

    public Enemy(String type, int health, int baseDamage) {
        this.type = type;
        this.health = health;
        this.baseDamage = baseDamage;
    }

    void encounter() {
        System.out.println("You have encountered a " + type);
    }

    void attack() {
        enemyDamageDealt += baseDamage + (int) (baseDamage * (rollNSidedDice(20)) / 10);

    }

    void flea() {
        status = false;
    }
}

public class TextAdventure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player play = new Player();
        Enemy goblin = new Enemy("Goblin", 20, 3);
        System.out.println("\"Now that we know a little bit about my good fellow, " + play.name + " why don't we dive in and get you familiar with our world.\"");
        System.out.println("\"Around here, we call our humble little town Langthwaite, characterized by its loooooong stretch of empty land.\"");
        System.out.println("\"Things seem to stay rather calm around here... or at least, until right around the time you showed up.\"");
        System.out.println("How would you like to respond?: ");
        System.out.println("1. \"The hell you mean by that?\"");
        System.out.println("2. \"Makes sense.\"");
        System.out.println("3. \"Trying to accuse me of something there, buddy?\"");
        System.out.println("4. \"I've got a knife, and I'm not afraid to use it if you keep throwing around accusations like that.\"");
        int input = sc.nextInt();

    }
}


