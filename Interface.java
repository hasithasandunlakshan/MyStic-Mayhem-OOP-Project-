
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Interface extends GameName {
    // Colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    Player player;
    DataBase db = new DataBase();

    public int registerPlayer() {
        int k = 0;
        Scanner scanner = new Scanner(System.in);
        animatePrintFast("Welcome to the Mystic-MayhemS", ANSI_YELLOW);

        // Animation: Printing each line with a slight delay
        animatePrint("-----------------------------", ANSI_RED);
        animatePrint("Enter your Username: ", ANSI_YELLOW);

        String name = scanner.nextLine();

        animatePrint("Enter a Unique Username:", ANSI_YELLOW);
        String username = scanner.nextLine();

        if (!Player.players.contains(username)) {
            this.player = new Player(name, username); // Creating a new Player object
            blinkText("Registation Successfull!!!!!!", 5, 400, ANSI_GREEN);
            k = 1;
        } else {
            System.out.println("Sorry, the username '" + username + "' is already taken. Please choose another.");
        }
        return k;
    }

    // Method to print text with a slight delay
    public void animatePrint(String text, String color) {
        System.out.print(color);
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(20); // Adjust the delay as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(ANSI_RESET); // Reset color after printing
        System.out.println();
    }

    private void animatePrintFast(String text, String color) {
        System.out.print(color);
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(2); // Adjust the delay as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(ANSI_RESET); // Reset color after printing
        System.out.println();
    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public void createArmy(Player player) {

        Scanner x = new Scanner(System.in);
        try {
            while (true) {

                db.getCategoryData("Archer");

                animatePrint("Select Your Archer....(Give index)", ANSI_GREEN);
                boolean res = false;

                int archer = x.nextInt();
                if (archer == 1) {
                    res = player.buyArcher("Shooter");

                } else if (archer == 2) {
                    res = player.buyArcher("Ranger");
                } else if (archer == 3) {
                    res = player.buyArcher("Sunfire");
                } else if (archer == 4) {
                    res = player.buyArcher("Zing");

                } else if (archer == 5) {
                    res = player.buyArcher("Saggitarius");

                } else {
                    animatePrint("Invalid index. Please enter a valid index.Recreate Army", ANSI_RED);
                    res = false;

                }
                if (!res) {
                    player.gold = 500;
                    player.army = null;
                    createArmy(player);
                    break;
                }

                db.getCategoryData("Knight");
                animatePrint("Select Your Knight....(Give index)", ANSI_GREEN);

                int knight = x.nextInt();
                if (knight == 1) {
                    res = player.buyKnight("Squire");
                } else if (knight == 2) {
                    res = player.buyKnight("Cavalier");
                } else if (knight == 3) {
                    res = player.buyKnight("Templar");
                } else if (knight == 4) {
                    res = player.buyKnight("Zoro");
                } else if (knight == 5) {
                    res = player.buyKnight("Swiftblade");
                } else {
                    animatePrint("Invalid index. Please enter a valid index.Recreate Army", ANSI_RED);

                    res = false;
                }
                if (!res) {
                    player.gold = 500;
                    player.army = null;
                    createArmy(player);

                    break;

                }

                db.getCategoryData("Mage");
                animatePrint("Select Your Mage....(Give index)", ANSI_GREEN);
                int mage = x.nextInt();
                if (mage == 1) {
                    res = player.buyMage("Warlock");
                } else if (mage == 2) {
                    res = player.buyMage("Illusionist");
                } else if (mage == 3) {
                    res = player.buyMage("Enchanter");
                } else if (mage == 4) {
                    res = player.buyMage("Conjurer");
                } else if (mage == 5) {
                    res = player.buyMage("Eldritch");
                } else {
                    animatePrint("Invalid index. Please enter a valid index.Recreate Army", ANSI_RED);
                    res = false;
                }
                if (!res) {
                    player.gold = 500;
                    player.army = null;
                    createArmy(player);

                    break;

                }

                db.getCategoryData("Healer");
                animatePrint("Select Your Healer....(Give index)", ANSI_GREEN);
                int healer = x.nextInt();
                if (healer == 1) {
                    res = player.buyHealer("Soother");
                } else if (healer == 2) {
                    res = player.buyHealer("Medic");
                } else if (healer == 3) {
                    res = player.buyHealer("Alchemist");

                } else if (healer == 4) {
                    res = player.buyHealer("Saint");
                } else if (healer == 5) {
                    res = player.buyHealer("Lightbringer");
                } else {

                    animatePrint("Invalid index. Please enter a valid index.Recreate Army", ANSI_RED);
                    res = false;
                }
                if (!res) {
                    player.gold = 500;
                    player.army = null;
                    createArmy(player);

                    break;

                }

                db.getCategoryData("Mythical");

                animatePrint("Select Your Mythical....(Give index)", ANSI_GREEN);
                int mythical = x.nextInt();
                if (mythical == 1) {
                    res = player.buyMythicalCreature("Dragon");
                } else if (mythical == 2) {
                    res = player.buyMythicalCreature("Basilisk");
                } else if (mythical == 3) {
                    res = player.buyMythicalCreature("Hydra");
                } else if (mythical == 4) {
                    res = player.buyMythicalCreature("Phoenix");
                } else if (mythical == 5) {
                    res = player.buyMythicalCreature("Pegasus");
                } else {
                    animatePrint("Invalid index. Please enter a valid index.Recreate Army", ANSI_RED);
                    res = false;
                }
                if (!res) {
                    player.gold = 500;
                    player.army = null;
                    createArmy(player);

                    break;

                } else {
                    break;
                }

            }

        } catch (Exception e) {
            animatePrint("An error occurred ReCreate the Army ", ANSI_RED);
            // Reset player's gold and army
            player.gold = 500;
            player.army = null;
            // Recursively call createArmy(player)
            createArmy(player);

        }
    }

    public void printArmySupportFunction(Player player) {
        System.out.println();

        animatePrintFast("╔═══════════════════════════════════════════╗", ANSI_CYAN);
        animatePrintFast("        " + player.username + " 's ARMY  ", ANSI_YELLOW);
        animatePrintFast("╚═══════════════════════════════════════════╝", ANSI_CYAN);

        animatePrintFast("┌───────────────┬───────────────────────────┐", ANSI_GREEN);
        animatePrintFast("│  Unit Type    │          Name             │", ANSI_GREEN);
        animatePrintFast("├───────────────┼───────────────────────────┤", ANSI_GREEN);
        animatePrintFast("│    Archer     │ " + padRight(player.army.archer.name, 25) + " │", ANSI_RED);
        animatePrintFast("│    Knight     │ " + padRight(player.army.knight.name, 25) + " │", ANSI_RED);
        animatePrintFast("│     Mage      │ " + padRight(player.army.mage.name, 25) + " │", ANSI_RED);
        animatePrintFast("│    Healer     │ " + padRight(player.army.healer.name, 25) + " │", ANSI_RED);
        animatePrintFast("│   Mythical    │ " + padRight(player.army.mythical.name, 25) + " │", ANSI_RED);
        animatePrintFast("└───────────────┴───────────────────────────┘", ANSI_GREEN);
    }

    public void printArmy(Player player, boolean creating) {
        if (creating) {
            animatePrint("Creating Your Army..........", ANSI_PURPLE);
        }
        printArmySupportFunction(player);
    }

    public void printArmy(Player player) {
        printArmySupportFunction(player);
    }

    public String selectHomeLand() {
        String[] Homelands = { "Desert", "MarshLand", "HilCrest", "Arcane" };
        System.out.println("Select your homeland:");
        System.out.println("Index  Name");
        int index = 1; // Start index from 1
        for (String homeland : Homelands) {
            // Print index and homeland
            System.out.printf("%-6d %-13s%n", index, homeland);
            index++; // Increment index by 1
        }
        Scanner x = new Scanner(System.in);
        int selectedHomeLand = x.nextInt();
        String setSelectedHomeGround;
        if (selectedHomeLand == 1) {
            setSelectedHomeGround = "Desert";
        } else if (selectedHomeLand == 2) {
            setSelectedHomeGround = "MarshLand";
        } else if (selectedHomeLand == 3) {
            setSelectedHomeGround = "HilCrest";
            System.out.println("dfsdfsdfsdfsf");
        } else {
            setSelectedHomeGround = "Arcane";
        }
        return setSelectedHomeGround;

    }

    public void doYouWantBuyEquipment(Player player) {
        Scanner x = new Scanner(System.in);
        blinkText("Do you want buy Equipment(y/n)???????", 3, 300, ANSI_GREEN);
        String state = x.nextLine();
        if (state.equals("y")) {

            blinkText("Available Gold Coins----" + player.gold, 2, 500, ANSI_BLUE);
            db.getEquipmentDataList();

            System.out.print("Enter the index of the Equipment: ");

            int inputEquipment = x.nextInt();
            showSoldiers();

            System.out.print("Enter the index of the soldier: ");
            int inputSoldier = x.nextInt();

            // Get the name of the soldier corresponding to the input index
            String selectedSoldier = null;
            String selectedEquipment;
            if (inputEquipment == 1) {
                selectedEquipment = "Chainmail";
                switch (inputSoldier) {
                    case 1:
                        selectedSoldier = "Archer";
                        break;
                    case 2:
                        selectedSoldier = "Knight";
                        break;
                    case 3:
                        selectedSoldier = "Mage";
                        break;
                    case 4:
                        selectedSoldier = "Healer";
                        break;
                    case 5:
                        selectedSoldier = "Mythical";
                        break;
                }
                System.out.println("You selected: " + selectedSoldier);
                System.out.println("You selected: " + selectedEquipment);

            } else if (inputEquipment == 2) {
                selectedEquipment = "Excalibur";
                switch (inputSoldier) {
                    case 1:
                        selectedSoldier = "Archer";
                        break;
                    case 2:
                        selectedSoldier = "Knight";
                        break;
                    case 3:
                        selectedSoldier = "Mage";
                        break;
                    case 4:
                        selectedSoldier = "Healer";
                        break;
                    case 5:
                        selectedSoldier = "Mythical";
                        break;
                }
                System.out.println("You selected: " + selectedSoldier);
                System.out.println("You selected: " + selectedEquipment);
            } else if (inputEquipment == 3) {
                selectedEquipment = "Regalia";
                switch (inputSoldier) {
                    case 1:
                        selectedSoldier = "Archer";
                        break;
                    case 2:
                        selectedSoldier = "Knight";
                        break;
                    case 3:
                        selectedSoldier = "Mage";
                        break;
                    case 4:
                        selectedSoldier = "Healer";
                        break;
                    case 5:
                        selectedSoldier = "Mythical";
                        break;
                }
                System.out.println("You selected: " + selectedSoldier);
                System.out.println("You selected: " + selectedEquipment);
            } else if (inputEquipment == 4) {
                selectedEquipment = "Amulet";
                switch (inputSoldier) {
                    case 1:
                        selectedSoldier = "Archer";
                        break;
                    case 2:
                        selectedSoldier = "Knight";
                        break;
                    case 3:
                        selectedSoldier = "Mage";
                        break;
                    case 4:
                        selectedSoldier = "Healer";
                        break;
                    case 5:
                        selectedSoldier = "Mythical";
                        break;
                }
                System.out.println("You selected: " + selectedSoldier);
                System.out.println("You selected: " + selectedEquipment);
            } else if (inputEquipment == 5) {
                selectedEquipment = "Fleece";
                switch (inputSoldier) {
                    case 1:
                        selectedSoldier = "Archer";
                        break;
                    case 2:
                        selectedSoldier = "Knight";
                        break;
                    case 3:
                        selectedSoldier = "Mage";
                        break;
                    case 4:
                        selectedSoldier = "Healer";
                        break;
                    case 5:
                        selectedSoldier = "Mythical";
                        break;
                }
                System.out.println("You selected: " + selectedSoldier);
                System.out.println("You selected: " + selectedEquipment);
            } else {
                selectedEquipment = "Crystal";
                switch (inputSoldier) {
                    case 1:
                        selectedSoldier = "Archer";
                        break;
                    case 2:
                        selectedSoldier = "Knight";
                        break;
                    case 3:
                        selectedSoldier = "Mage";
                        break;
                    case 4:
                        selectedSoldier = "Healer";
                        break;
                    case 5:
                        selectedSoldier = "Mythical";
                        break;
                }
                System.out.println("You selected: " + selectedSoldier);
                System.out.println("You selected: " + selectedEquipment);
            }
            player.buyEquipment(selectedSoldier, selectedEquipment);
            System.out.println(player.army.archer.attack);
        } else {
            System.out.println("Continue Your Battle");
        }

    }

    public void showSoldiers() {
        System.out.println("What is the soldier you add Equipments:");
        System.out.println("Index  Name");
        int index = 1; // Start index from 1
        String[] category = { "Archer", "Knight", "Mage", "Healer", "Mythical" };
        for (String x : category) {

            // Print index and name
            System.out.printf("%-6d %-13s%n", index, x);
            index++; // Increment index by 1
        }
    }

    public boolean defaultPlayer(Player player) {
        animatePrint(player.username + " is Challenging you!!! What are you gonna do?", ANSI_RED);

        System.out.println("Select an option:");
        System.out.println("1. Accept the challenge");
        System.out.println("2. View player army");
        System.out.println("3. Decline the challenge");

        Scanner x = new Scanner(System.in);
        boolean status = false;

        int choice = x.nextInt();
        switch (choice) {
            case 1:
                blinkText("You accept the challange", 3, 400, ANSI_GREEN);
                status = true;
                break;
            case 2:
                printArmy(player);
                defaultPlayer(player);

                break;
            case 3:
                status = false;
                break;
            default:
                blinkText("Invalid option. Please select again.", 3, 500, ANSI_RED);
                break;
        }
        return status;
    }

    public Player selectPlayer() {
        Player whiteWolf = new Player("GeraltofRivia", "whitewolf", 215, 32);

        String[] troops1 = { "Ranger", "Squire", "Warlock", "Medic", "Dragon" };
        whiteWolf.createArmy(troops1);
        Player code_x = new Player("code-x", "code-x", 200, 32);

        String[] troops2 = { "Zing", "Zoro", "Conjurer", "Saint", "Phoenix" };
        code_x.createArmy(troops2);
        animatePrintFast("Select Your Challenger??", ANSI_GREEN);
        Player challenger = null;
        blinkText("-----------Enemie's Details------------", 2, 300, ANSI_YELLOW);
        printArmy(whiteWolf);
        printArmy(code_x);
        System.out.println("Select a Player:");
        System.out.println("1. WhiteWolf");
        System.out.println("2. CODE-X");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int playerChoice = scanner.nextInt();
        if (playerChoice == 1) {
            challenger = whiteWolf;

        } else if (playerChoice == 2) {
            challenger = code_x;
        } else {
            System.out.println("Invalid choice!");
        }
        return challenger;

    }

    public void sellSoldiers(Player player) {
        Scanner x = new Scanner(System.in);
        blinkText("Do you want Sell Soldiers?(y/n)???????", 3, 300, ANSI_GREEN);
        String state = x.nextLine();
        if (state.equals("y")) {
            // Display available soldiers and their indices
            showSoldiers();
            System.out.print("Enter the index of the soldier you want to sell: ");
            int inputSoldier = x.nextInt();

            // Check which soldier is selected and call the corresponding sell function
            switch (inputSoldier) {
                case 1:
                    player.sellArcher();
                    createArmy(player);

                    break;
                case 2:
                    player.sellKnight();
                    createArmy(player);
                    break;
                case 3:
                    player.sellMage();
                    createArmy(player);
                    break;
                case 4:
                    player.sellHealer();
                    createArmy(player);
                    break;
                case 5:
                    player.sellMythicalCreature();
                    createArmy(player);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    sellSoldiers(player);
            }

        } else {
            System.out.println("Continue Your Battle");
        }

    }

}