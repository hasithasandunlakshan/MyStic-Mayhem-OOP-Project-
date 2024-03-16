public class Equipment {

    String name;
    int price;
    double attack;
    double defence;
    double health;
    double speed;
    public static DataBase database = new DataBase();

    public Equipment(String name) {
        int[] equipmentData = database.getEquipmentData(name);

        // Check if equipment data is found
        if (equipmentData != null) {

            this.name = name;
            this.price = equipmentData[0];

            // Check if attack value is non-zero
            if (equipmentData[1] != 0) {
                this.attack = equipmentData[1];
            }

            // Check if defence value is non-zero
            if (equipmentData[2] != 0) {
                this.defence = equipmentData[2];
            }

            // Check if health value is non-zero
            if (equipmentData[3] != 0) {
                this.health = equipmentData[3];
            }

            // Check if speed value is non-zero
            if (equipmentData[4] != 0) {
                this.speed = equipmentData[4];
            }
        }
    }

}