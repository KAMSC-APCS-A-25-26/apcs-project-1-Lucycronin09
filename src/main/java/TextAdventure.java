import java.util.Scanner;
import java.util.Random;

// player class for ease of making new characters
class Player
{
    // attributes of a character
    String name;
    int health = 20;
    String dndClass;
    String race;

    public Player()
    {
        // introductory dialogue to create a new Player Character
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello there traveler, Welcome to our world. What is your name?: ");
        name = sc.nextLine();
        System.out.println("Ahh, fine name for a fine... what are you exactly? (race): ");
        race = sc.next();
        System.out.println("Just as expected. Now, what would you like to specialize in? (Rogue, Wizard, Barbarian, Druid, or Ranger)");
        dndClass = sc.next();
        System.out.println("Great! Let's get started.");
        System.out.println();
    }
}

// enemy class to help easily make new foes
class Enemy
{

    int rollNSidedDice(int sides)
    {
        Random rand = new Random();
        return rand.nextInt(sides) + 1;
    }

    Random rand = new Random();
    // enemy attributes
    String type;
    int health;
    int baseDamage;
    int damageDealt = 0;
    public Enemy(String type, int health, int baseDamage)
    {
        this.type = type;
        this.health = health;
        this.baseDamage = baseDamage;
    }

    void encounter()
    {
        System.out.println("You have encountered a " + type);
    }

    void attack()
    {
        damageDealt += baseDamage + (int) (baseDamage * (rollNSidedDice(20) / 10));
    }

    void flea()
    {

    }
}

public class TextAdventure
{
    public static void main(String[] args)
    {
        Player play = new Player();
        Enemy goblin = new Enemy("Goblin", 20, 3);
        goblin.encounter();
    }
}


