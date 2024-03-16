
public class main {
    public static void main(String[] args) {
        GameName game = new GameName();
        game.gameStart();
        Interface test = new Interface();

        // register user as a player
        test.registerPlayer();
        Player player = test.player;
        test.createArmy(player);
        test.doYouWantBuyEquipment(player);

        test.printArmy(player);
        Player challenger = test.selectPlayer();
        boolean challengeAccepted = test.defaultPlayer(challenger);
        String ground = test.selectHomeLand();

        Battle battleField = new Battle();
        if (challengeAccepted) {
            battleField.Challenge(challenger, player, ground);
            test.sellSoldiers(player);
        } else {
            game.animatePrint("You Left the Battle", GameName.ANSI_RED);
        }

    }
}
