import java.util.Objects;

public class Army {
    String[] troops;

    Soldier archer;
    Soldier knight;
    Soldier mage;
    Soldier healer;
    Soldier mythical;

    public Army(String[] troops) {
        this.archer = new Soldier("Archer", troops[0]);
        this.knight = new Soldier("Knight", troops[1]);
        this.mage = new Soldier("Mage", troops[2]);
        this.healer = new Soldier("Healer", troops[3]);
        this.mythical = new Soldier("MythicalCreature", troops[4]);
    }

    public Army() {
    }

}