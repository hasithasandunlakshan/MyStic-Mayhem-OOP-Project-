public class Soldier {

    String name;
    int price;
    double attack;
    double defence;
    double health;
    double speed;
    String category;
    Equipment equipment;
    private static final DataBase database = new DataBase();

    public Soldier(String category, String name) {
        Object[] soldierData = database.getSoldierData(name);

        if (soldierData != null) {
            this.name = name;
            this.category = (String) soldierData[5];
            this.price = (int) soldierData[0];
            this.attack = (int) soldierData[1];
            this.defence = (int) soldierData[2];
            this.health = (int) soldierData[3];
            this.speed = (int) soldierData[4];
        } else {
            System.out.println("WRONG CATEGORY ADD SOLDIER FOR CORRECT CATEGORY");
        }
    }

    public void setEquipment(String equipmentName) {

        this.equipment = new Equipment(equipmentName);
        this.attack = this.attack + this.equipment.attack;
        this.price = this.price + (this.equipment.price * 20) / 100;
        this.defence = this.defence + this.equipment.defence;
        this.health = this.health + this.equipment.health;
        this.speed = this.speed + this.equipment.speed;
    }

}