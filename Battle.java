
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Battle {

    Combact showResult = new Combact();

    public void Challenge(Player challenger, Player accepter, String ground) {
        switch (ground) {
            case "Desert" -> Desert(challenger, accepter);
            case "MarshLand" -> MarshLand(challenger, accepter);
            case "HilCrest" -> HilCrest(challenger, accepter);
            case "Arcane" -> Arcane(challenger, accepter);
        }
    }

    ArrayList<String> Highlanders = new ArrayList<String>();
    ArrayList<String> Marshlanders = new ArrayList<String>();
    ArrayList<String> Sunchildren = new ArrayList<String>();
    ArrayList<String> Mystics = new ArrayList<String>();

    // Constructor
    public Battle() {

        Highlanders.add("Shooter");
        Highlanders.add("Ranger");
        Highlanders.add("Cavalier");
        Highlanders.add("Zoro");
        Highlanders.add("Enchanter");
        Highlanders.add("Conjurer");
        Highlanders.add("Medic");

        Marshlanders.add("Squire");
        Marshlanders.add("Swiftblade");
        Marshlanders.add("Warlock");
        Marshlanders.add("Alchemist");
        Marshlanders.add("Basilisk");
        Marshlanders.add("Hydra");

        Sunchildren.add("Sunfire");
        Sunchildren.add("Zing");
        Sunchildren.add("Templar");
        Sunchildren.add("Soother");
        Sunchildren.add("Lightbringer");
        Sunchildren.add("Dragon");
        Sunchildren.add("Phoenix");

        Mystics.add("Saggitarius");
        Mystics.add("Illusionist");
        Mystics.add("Eldritch");
        Mystics.add("Saint");
        Mystics.add("Pegasus");

    }

    // private void UpdatePlayers(Player player, List<String> highlanders,
    // List<String> marshlanders,
    // List<String> sunchildren, List<String> mystics,String ground){
    // if(ground.equals("Hilcrest")){
    //
    //
    //
    // applyModifiersHilCrest(player.army.archer, Highlanders, Marshlanders,
    // Sunchildren, Mystics);
    // applyModifiersHilCrest(player.army.knight, Highlanders, Marshlanders,
    // Sunchildren, Mystics);
    // applyModifiersHilCrest(player.army.mage, Highlanders, Marshlanders,
    // Sunchildren, Mystics);
    // applyModifiersHilCrest(player.army.healer, Highlanders, Marshlanders,
    // Sunchildren, Mystics);
    // applyModifiersHilCrest(player.army.mythical, Highlanders, Marshlanders,
    // Sunchildren, Mystics);}
    //
    //
    // }

    public void HilCrest(Player challenger, Player accepter) {
        // Apply modifiers for each soldier type
        applyModifiersHilCrest(challenger.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);

        applyModifiersHilCrest(accepter.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(accepter.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(accepter.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(accepter.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(accepter.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);

        Fight(challenger, accepter, "Hilcrest");
    }

    private void applyModifiersHilCrest(Soldier soldier, List<String> highlanders, List<String> marshlanders,
            List<String> sunchildren, List<String> mystics) {
        // Apply attack and defense modifiers for Highlanders
        if (highlanders.contains(soldier.name)) {

            soldier.attack += 1;
            soldier.defence += 1;

        }
        // Apply speed modifier for Marshlanders and Sunchildren
        if (marshlanders.contains(soldier.name) || sunchildren.contains(soldier.name)) {

            soldier.speed -= 1;

        }
    }

    public void MarshLand(Player challenger, Player accepter) {
        // Apply modifiers for each soldier type
        applyModifiersMarshLand(challenger.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);

        applyModifiersMarshLand(accepter.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(accepter.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(accepter.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(accepter.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(accepter.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);
        Fight(challenger, accepter, "MarshLand");

    }

    private void applyModifiersMarshLand(Soldier soldier, List<String> highlanders, List<String> marshlanders,
            List<String> sunchildren, List<String> mystics) {
        if (marshlanders.contains(soldier.name)) {

            soldier.defence += 2;

        }
        // Apply speed modifier for Marshlanders and Sunchildren
        if (sunchildren.contains(soldier.name)) {

            soldier.attack -= 1;

        }

        if (mystics.contains(soldier.name)) {

            soldier.speed -= 1;

        }
    }

    public void Desert(Player challenger, Player accepter) {

        applyModifiersDesert(challenger.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);

        applyModifiersDesert(accepter.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(accepter.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(accepter.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(accepter.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(accepter.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);
        Fight(challenger, accepter, "Desert");

    }

    private void applyModifiersDesert(Soldier soldier, List<String> highlanders, List<String> marshlanders,
            List<String> sunchildren, List<String> mystics) {
        if (marshlanders.contains(soldier.name)) {

            soldier.health -= 1;
        }
        // Apply speed modifier for Marshlanders and Sunchildren
        if (sunchildren.contains(soldier.name)) {

            soldier.attack += 1;

        }
    }

    public void Arcane(Player challenger, Player accepter) {
        System.out.println("Battle in Arcane");

        // Apply modifiers for each soldier type
        applyModifiersArcane(challenger.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(challenger.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(challenger.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(challenger.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(challenger.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);

        applyModifiersArcane(accepter.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(accepter.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(accepter.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(accepter.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(accepter.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);
        Fight(challenger, accepter, "Arcane");

    }

    private void applyModifiersArcane(Soldier soldier, List<String> highlanders, List<String> marshlanders,
            List<String> sunchildren, List<String> mystics) {
        if (highlanders.contains(soldier.name)) {

            soldier.speed -= 1;
            soldier.defence -= 1;

        }

        if (Marshlanders.contains(soldier.name)) {

            soldier.speed -= 1;
            soldier.defence -= 1;

        }
        // Apply speed modifier for Marshlanders and Sunchildren
        if (mystics.contains(soldier.name)) {

            soldier.speed += 2;

        }
    }

    private void Fight(Player challenger, Player accepter, String ground) {
        Soldier[] challengerArmy = { challenger.army.archer, challenger.army.knight, challenger.army.mage,
                challenger.army.healer, challenger.army.mythical };
        Soldier[] accepterArmy = { accepter.army.archer, accepter.army.knight, accepter.army.mage, accepter.army.healer,
                accepter.army.mythical };

        ArrayList<Integer> terminatedSoldiersChallenger = new ArrayList<>();
        ArrayList<Integer> terminatedSoldiersAcceptor = new ArrayList<>();

        int army1Size = challengerArmy.length;
        int army2Size = accepterArmy.length;
        int turns = 0;

        int challengersIndex;
        int acceptorsIndex;

        while (army1Size > 0 && army2Size > 0 && turns < 20) {

            if (terminatedSoldiersChallenger.size() == challengerArmy.length) {
                terminatedSoldiersChallenger.clear();
            }

            if (terminatedSoldiersAcceptor.size() == accepterArmy.length) {
                terminatedSoldiersAcceptor.clear();
            }

            // challenger attacks acceptor
            acceptorsIndex = LowestDefense(accepterArmy);
            challengersIndex = FastestPlayer(challengerArmy, terminatedSoldiersAcceptor);
            terminatedSoldiersChallenger.add(challengersIndex);

            if (Objects.equals(challengerArmy[challengersIndex].category, "Healer")) {
                int lowestChallengerHealth = LowestHealth(challengerArmy);
                challengerArmy[lowestChallengerHealth].health += 0.1 * challengerArmy[challengersIndex].attack;
                // if (Objects.equals(ground, "Arcane")){
                //
                // }
            } else {
                accepterArmy[acceptorsIndex].health -= 0.5 * challengerArmy[challengersIndex].attack
                        - 0.1 * accepterArmy[acceptorsIndex].defence;

            }

            turns++;
            System.out.println("Turn no--" + turns);
            showResult.showStat(challenger.name, challengerArmy[challengersIndex], accepterArmy[acceptorsIndex]);
            // any key

            accepterArmy = RemoveDeadSoldiers(accepterArmy);
            army1Size = accepterArmy.length;

            if (accepterArmy.length == 0) {
                showResult.showWinner(false);
                return;
            }

            // acceptor attacks challenger
            challengersIndex = LowestDefense(challengerArmy);
            acceptorsIndex = FastestPlayer(accepterArmy, terminatedSoldiersChallenger);
            terminatedSoldiersAcceptor.add(acceptorsIndex);

            if (accepterArmy[acceptorsIndex].category.equals("Healer")) {
                int lowestAcceptorHealth = LowestHealth(accepterArmy);
                accepterArmy[lowestAcceptorHealth].health += 0.1 * accepterArmy[acceptorsIndex].attack;
            } else {
                challengerArmy[challengersIndex].health -= 0.5 * accepterArmy[acceptorsIndex].attack
                        - 0.1 * challengerArmy[challengersIndex].defence;

            }
            turns++;
            System.out.println(turns);
            showResult.showStat(accepter.name, accepterArmy[acceptorsIndex], challengerArmy[challengersIndex]);
            // any key

            challengerArmy = RemoveDeadSoldiers(challengerArmy);
            army2Size = challengerArmy.length;

            showResult.showStat(accepter.name, accepterArmy[acceptorsIndex], challengerArmy[challengersIndex]);
            challengerArmy = RemoveDeadSoldiers(challengerArmy);
            army2Size = challengerArmy.length;

            if (challengerArmy.length == 0) {
                showResult.showWinner(true);
                return;
            }
        }

        showResult.drawBattle();

    }

    private int FastestPlayer(Soldier[] army, ArrayList<Integer> terminated) {
        int n = army.length;
        int m = terminated.size();
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            boolean exists = false;

            for (int j = 0; j < m; j++) {
                if (terminated.get(j) == i) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                continue;
            }
            if (army[i].speed > army[maxIndex].speed) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private int LowestDefense(Soldier[] army) {
        int n = army.length;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            if (army[i].defence < army[minIndex].defence) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int LowestHealth(Soldier[] army) {
        int n = army.length;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            if (army[i].health < army[minIndex].health) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private Soldier[] RemoveDeadSoldiers(Soldier[] army) {
        Soldier[] temp = new Soldier[army.length]; // Initialize temp array with the same size as army
        int count = 0; // Initialize a counter for the valid soldiers in temp

        for (int i = 0; i < army.length; i++) {
            if (army[i].health <= 0) {
                continue; // Skip dead soldiers
            }
            temp[count] = army[i]; // Add alive soldiers to temp
            count++; // Increment the count of valid soldiers in temp
        }

        // Resize the temp array to contain only the valid soldiers
        Soldier[] result = new Soldier[count];
        System.arraycopy(temp, 0, result, 0, count);

        return result;
    }

}
