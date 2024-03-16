import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    protected String name;
    protected String username;
    protected int id;
    protected int gold;
    protected int xp;
    // protected HomeGround homeGround;
    protected Army army;
    GameName game = new GameName();

    static DataBase db = new DataBase();
    static List<String> players = new ArrayList<>();

    // static String players[] = { null, null };
    private static int nextId = 1;

    // global variable to store usernames
    public boolean isUsernameTaken(String username) {
        for (String player : players) {
            if (player == username) {
                return true;
            }
        }
        return false;
    }

    public void addUsername(String username) {
        players.add(username);
    }

    public int generateUniqueId() {
        return nextId++;
    }

    public Player(String name, String username) {

        if (isUsernameTaken(username)) {
            game.animatePrint("Username '" + username + "' is already taken. Please choose another username.",
                    GameName.ANSI_BLINK);
            // Handle the case where the username already exists, you can throw an exception
            // or handle it accordingly.
        } else {
            this.name = name;
            this.username = username;
            this.id = generateUniqueId();
            this.gold = 500;
            this.xp = 0;
            addUsername(username); // Add the player to the system
        }

    }

    public Player(String name, String username, int gold, int xp) {
        // this.players = new ArrayList<>();

        if (isUsernameTaken(username)) {
            game.animatePrint("Username '" + username + "' is already taken. Please choose another username.",
                    GameName.ANSI_BLINK);

        } else {
            this.name = name;
            this.username = username;
            this.id = generateUniqueId();
            this.gold = 500;
            this.xp = 0;
            addUsername(username); // Add the player to the system
        }
    }

    public void createArmy(String[] troops) {
        this.army = new Army(troops);
    }

    public boolean buyArcher(String name) {
        Soldier Obj1 = new Soldier("Archer", name);

        if (gold < Obj1.price) {
            game.animatePrint("OOPS!!!--Insufficient gold to buy an Archer.Recreate the Army", game.ANSI_RED);
            return false; // Exit the method if there's not enough gold
        } else {
            this.gold -= Obj1.price; // reduce the gold After buying the Archer

            // Create a new Archer soldier and assign it to the player's army
            if (army == null) {
                army = new Army(); // Initialize the army if it's not already initialized
            }

            this.army.archer = new Soldier("Archer", name);
            return true;
        }

    }

    public void sellArcher() {
        if (army != null && army.archer != null) { // Check if the player has an Archer
            int sellValue = (int) (army.archer.price * 0.9); // Calculate sell value (90% of the price)

            // Add the sell value to the player's gold
            this.gold += sellValue;

            // Remove the Archer from the player's army
            this.army.archer = null;

            System.out.println("Archer sold successfully for " + sellValue + " gold.");
        } else {
            System.out.println("You don't have an Archer to sell.");
        }
    }

    public boolean buyKnight(String name) {
        Soldier Obj2 = new Soldier("Knight", name);

        if (gold < Obj2.price) {
            game.animatePrint("OOPS!!!--Insufficient gold to buy an Archer.Recreate the Army", game.ANSI_RED);
            return false;
        } else {
            this.gold -= Obj2.price;

            if (army == null) {
                army = new Army();
            }

            this.army.knight = new Soldier("Knight", name);
            return true;
        }
    }

    public void sellKnight() {
        if (army != null && army.knight != null) {
            int sellValue = (int) (army.knight.price * 0.9);
            this.gold += sellValue;
            this.army.knight = null;
            System.out.println("Knight sold successfully for " + sellValue + " gold.");
        } else {
            System.out.println("You don't have a Knight to sell.");
        }
    }

    public boolean buyMage(String name) {
        Soldier Obj3 = new Soldier("Mage", name);

        if (gold < Obj3.price) {
            game.animatePrint("OOPS!!!--Insufficient gold to buy an Mage.Recreate the Army", game.ANSI_RED);
            return false;
        } else {
            this.gold -= Obj3.price;

            if (army == null) {
                army = new Army();
            }

            this.army.mage = new Soldier("Mage", name);
            return true;
        }
    }

    public void sellMage() {
        if (army != null && army.mage != null) {
            int sellValue = (int) (army.mage.price * 0.9);
            this.gold += sellValue;
            this.army.mage = null;
            System.out.println("Mage sold successfully for " + sellValue + " gold.");
        } else {
            System.out.println("You don't have a Mage to sell.");
        }
    }

    public boolean buyHealer(String name) {
        Soldier Obj4 = new Soldier("Healer", name);

        if (gold < Obj4.price) {
            game.animatePrint("OOPS!!!--Insufficient gold to buy an Healer.Recreate the Army", game.ANSI_RED);
            return false;
        } else {
            this.gold -= Obj4.price;

            if (army == null) {
                army = new Army();
            }

            this.army.healer = new Soldier("Healer", name);
            return true;
        }
    }

    public void sellHealer() {
        if (army != null && army.healer != null) {
            int sellValue = (int) (army.healer.price * 0.9);
            this.gold += sellValue;
            this.army.healer = null;
            System.out.println("Healer sold successfully for " + sellValue + " gold.");
        } else {
            System.out.println("You don't have a Healer to sell.");
        }
    }

    public boolean buyMythicalCreature(String name) {
        Soldier Obj5 = new Soldier("Mythical", name);

        if (gold < Obj5.price) {
            game.animatePrint("OOPS!!!--Insufficient gold to buy an Archer.Recreate the Army", game.ANSI_RED);
            return false;
        } else {
            this.gold -= Obj5.price;

            if (army == null) {
                army = new Army();
            }

            this.army.mythical = new Soldier("Mythical", name);
            return true;
        }
    }

    public void sellMythicalCreature() {
        if (army != null && army.mythical != null) {
            int sellValue = (int) (army.mythical.price * 0.9);
            this.gold += sellValue;
            this.army.mythical = null;
            System.out.println("MythicalCreature sold successfully for " + sellValue + " gold.");
        } else {
            System.out.println("You don't have a MythicalCreature to sell.");
        }
    }

    // whitewolf.buyEquipment("knight", "name")
    public void buyEquipment(String soldier, String equipment) {
        int[] data = db.getEquipmentData(equipment);

        if (gold < data[0]) { // check if the gold is enough for the purchase
            game.animatePrint("Insufficient gold to buy an " + equipment, GameName.ANSI_RED); // if not print a error
                                                                                              // message
            return;
        } else {
            this.gold -= data[0]; // else reduce the gold
            if (soldier == "Archer") {

                this.army.archer.setEquipment(equipment);

            }

            else if (soldier == "Knight") {

                this.army.knight.setEquipment(equipment);

            }

            else if (soldier == "Mage") {

                this.army.mage.setEquipment(equipment);

            }

            else if (soldier == "Healer") {

                this.army.healer.setEquipment(equipment);

            }

            else if (soldier == "Mythical") {

                this.army.mythical.setEquipment(equipment);

            }
            game.animatePrint("Successfully added", GameName.ANSI_RED);
        }
    }
}