
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {

    List<List<Object>> equipmentList;
    List<List<Object>> soldiersData;

    // Constructor to initialize the equipment list with data
    public DataBase() {
        equipmentList = new ArrayList<>();
        soldiersData = new ArrayList<>();

        // Add data to the equipment list
        equipmentList.add(Arrays.asList("Chainmail", 70, 0, 1, 0, -1));
        equipmentList.add(Arrays.asList("Excalibur", 150, 2, 0, 0, 0));
        equipmentList.add(Arrays.asList("Regalia", 105, 0, 1, 0, 0));
        equipmentList.add(Arrays.asList("Amulet", 200, 1, -1, 1, 1));
        equipmentList.add(Arrays.asList("Fleece", 150, 0, 2, 1, -1));
        equipmentList.add(Arrays.asList("Crystal", 210, 2, 1, -1, -1));

        // Add data to the soldier list

        soldiersData.add(Arrays.asList("Shooter", "Archer", 80, 11, 4, 6, 9));
        soldiersData.add(Arrays.asList("Squire", "Knight", 85, 8, 9, 7, 8));
        soldiersData.add(Arrays.asList("Warlock", "Mage", 100, 12, 7, 10, 12));
        soldiersData.add(Arrays.asList("Soother", "Healer", 95, 10, 8, 9, 6));
        soldiersData.add(Arrays.asList("Dragon", "Mythical", 120, 12, 14, 15, 8));
        soldiersData.add(Arrays.asList("Ranger", "Archer", 115, 14, 5, 8, 10));
        soldiersData.add(Arrays.asList("Cavalier", "Knight", 110, 10, 12, 7, 10));
        soldiersData.add(Arrays.asList("Illusionist", "Mage", 120, 13, 8, 12, 14));
        soldiersData.add(Arrays.asList("Medic", "Healer", 125, 12, 9, 10, 7));
        soldiersData.add(Arrays.asList("Basilisk", "Mythical", 165, 15, 11, 10, 12));
        soldiersData.add(Arrays.asList("Sunfire", "Archer", 160, 15, 5, 7, 14));
        soldiersData.add(Arrays.asList("Templar", "Knight", 155, 14, 16, 12, 12));
        soldiersData.add(Arrays.asList("Enchanter", "Mage", 160, 16, 10, 13, 16));
        soldiersData.add(Arrays.asList("Alchemist", "Healer", 150, 13, 13, 13, 13));
        soldiersData.add(Arrays.asList("Hydra", "Mythical", 205, 12, 16, 15, 11));
        soldiersData.add(Arrays.asList("Zing", "Archer", 200, 16, 9, 11, 14));
        soldiersData.add(Arrays.asList("Zoro", "Knight", 180, 17, 16, 13, 14));
        soldiersData.add(Arrays.asList("Conjurer", "Mage", 195, 18, 15, 14, 12));
        soldiersData.add(Arrays.asList("Saint", "Healer", 200, 16, 14, 17, 9));
        soldiersData.add(Arrays.asList("Phoenix", "Mythical", 275, 17, 13, 17, 19));
        soldiersData.add(Arrays.asList("Saggitarius", "Archer", 230, 18, 7, 12, 17));
        soldiersData.add(Arrays.asList("Swiftblade", "Knight", 250, 18, 20, 17, 13));
        soldiersData.add(Arrays.asList("Eldritch", "Mage", 270, 19, 17, 18, 14));
        soldiersData.add(Arrays.asList("Lightbringer", "Healer", 260, 17, 15, 19, 12));
        soldiersData.add(Arrays.asList("Pegasus", "Mythical", 340, 14, 18, 20, 20));
    }

    // Method to get soldier data by name
    public int[] getEquipmentData(String name) {
        for (List<Object> soldier : equipmentList) {
            if (name.equals(soldier.get(0))) {
                int price = (int) soldier.get(1);
                int attack = (int) soldier.get(2);
                int defence = (int) soldier.get(3);
                int health = (int) soldier.get(4);
                int speed = (int) soldier.get(5);

                int[] data = { price, attack, defence, health, speed };
                return data;
            }
        }
        return null; // Return null if no match found
    }

    public Object[] getSoldierData(String name) {
        for (List<Object> soldier : soldiersData) {

            if (name.equals(soldier.get(0))) {
                int price = (int) soldier.get(2);
                int attack = (int) soldier.get(3);
                int defence = (int) soldier.get(4);
                int health = (int) soldier.get(5);
                int speed = (int) soldier.get(6);
                String category = (String) soldier.get(1);
                Object[] data = { price, attack, defence, health, speed, category };
                return data;
            }
        }
        return null; // Return null if no match found
    }

    public void getCategoryData(String category) {
        System.out.println("Soldiers in category: " + category);
        System.out.println("Index  Name          Price      Attack    Defence   Health    Speed");
        int index = 1; // Start index from 1
        for (List<Object> soldier : soldiersData) {
            String soldierCategory = (String) soldier.get(1); // Get the category of the soldier
            if (category.equalsIgnoreCase(soldierCategory)) {
                // If the soldier belongs to the given category, print its data
                String name = (String) soldier.get(0);
                int price = (int) soldier.get(2);
                int attack = (int) soldier.get(3);
                int defence = (int) soldier.get(4);
                int health = (int) soldier.get(5);
                int speed = (int) soldier.get(6);

                // Print soldier data with index
                System.out.printf("%-6d %-13s %-10d %-10d %-10d %-10d %-10d%n", index, name, price, attack, defence,
                        health, speed);
                index++; // Increment index by 1
            }
        }

    }

    public void getEquipmentDataList() {
        System.out.println("Equipment in category: ");
        System.out.println("Index  Name          Price      Attack    Defence   Health    Speed");
        int index = 1; // Start index from 1
        for (List<Object> equipment : equipmentList) {
            String equipmentCategory = (String) equipment.get(0); // Get the category of the equipment (in this case,
                                                                  // the name)

            // If the equipment belongs to the given category, print its data
            String name = (String) equipment.get(0);
            int price = (int) equipment.get(1);
            int attack = (int) equipment.get(2);
            int defence = (int) equipment.get(3);
            int health = (int) equipment.get(4);
            int speed = (int) equipment.get(5);

            // Print equipment data with index
            System.out.printf("%-6d %-13s %-10d %-10d %-10d %-10d %-10d%n", index, name, price, attack, defence, health,
                    speed);
            index++; // Increment index by 1

        }

    }

}
