public class Combact {
    GameName game = new GameName();

    public void showStat(String attackingPlayer, Soldier attacker, Soldier defender) {
        // Print winner
        // System.out.println("Winner: " + attackingPlayer);
        System.out.println("Name Of Attacking Player:  " + attackingPlayer);

        // Print attacker's attack on defender
        game.blinkText(attacker.name + " attacks " + defender.name, 2, 300, GameName.ANSI_RED);

        // Print health before attack

        game.animatePrint("Defence of Players:", GameName.ANSI_BLUE);
        System.out.println("+----------------+----------------+");
        System.out.println("|    Attacker's Defence    |    Defender's Defence    |");
        System.out.println("+----------------+----------------+");
        System.out.printf("|%10.2f          |%10.2f            |%n", attacker.defence, defender.defence);
        System.out.println("+----------------+----------------+");

        // Check if defender's health is zero or negative

        // Print health after attack

        game.animatePrint("Health after attack:", GameName.ANSI_BLUE);
        System.out.println("+----------------+----------------+");
        System.out.println("|    Attacker's Health    |    Defender's Health    |");
        System.out.println("+----------------+----------------+");
        System.out.printf("|%10.2f      |%10.2f      |%n", attacker.health, defender.health);
        game.animatePrint("+----------------+----------------+", GameName.ANSI_RED);
        game.blinkText("", 3, 300, GameName.ANSI_BLUE);
        if (defender.health <= 0) {
            game.blinkText(defender.name + " Died", 3, 300, GameName.ANSI_RED);
        }

    }

    public void showWinner(boolean winner) {
        if (winner) {
            String wonstate = " _____                             _         _       _   _                 _ _ _  __   __                                _ _ _ \n"
                    +
                    "/  __ \\                           | |       | |     | | (_)               | | | | \\ \\ / /                               | | | |\n"
                    +
                    "| /  \\/ ___  _ __   __ _ _ __ __ _| |_ _   _| | __ _| |_ _  ___  _ __  ___| | | |  \\ V /___  _   _  __      _____  _ __ | | | |\n"
                    +
                    "| |    / _ \\| '_ \\ / _` | '__/ _` | __| | | | |/ _` | __| |/ _ \\| '_ \\/ __| | | |   \\ // _ \\| | | | \\ \\ /\\ / / _ \\| '_ \\| | | |\n"
                    +
                    "| \\__/\\ (_) | | | | (_| | | | (_| | |_| |_| | | (_| | |_| | (_) | | | \\__ \\_|_|_|   | | (_) | |_| |  \\ V  V / (_) | | | |_|_|_|\n"
                    +
                    " \\____/\\___/|_| |_|\\__, |_|  \\__,_|\\__|\\__,_|_|\\__,_|\\__|_|\\___/|_| |_|___(_|_|_)   \\_/\\___/ \\__,_|   \\_/\\_/ \\___/|_| |_(_|_|_)\n"
                    +
                    "                    __/ |                                                                                                      \n"
                    +
                    "                   |___/                                                                                                       \n";
            game.animatePrint(wonstate, GameName.ANSI_BLUE);
        } else {
            String loststatus = "░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░      ░▒▓██████▓▒░ ░▒▓███████▓▒░▒▓████████▓▒░ \n"
                    +
                    "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░        \n"
                    +
                    "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░        \n"
                    +
                    " ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓██████▓▒░   \n"
                    +
                    "   ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░        \n"
                    +
                    "   ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░        \n"
                    +
                    "   ░▒▓█▓▒░    ░▒▓██████▓▒░ ░▒▓██████▓▒░       ░▒▓████████▓▒░▒▓██████▓▒░░▒▓███████▓▒░░▒▓████████▓▒░ \n"
                    +
                    "                                                                                                   \n"
                    +
                    "                                                                                                   \n";
            game.animatePrint(loststatus, GameName.ANSI_RED);
        }

    }

    public void drawBattle() {
        String draw = "\n" +
                "███╗   ███╗ █████╗ ████████╗ ██████╗██╗  ██╗    ██████╗ ██████╗  █████╗ ██╗    ██╗\n" +
                "████╗ ████║██╔══██╗╚══██╔══╝██╔════╝██║  ██║    ██╔══██╗██╔══██╗██╔══██╗██║    ██║\n" +
                "██╔████╔██║███████║   ██║   ██║     ███████║    ██║  ██║██████╔╝███████║██║ █╗ ██║\n" +
                "██║╚██╔╝██║██╔══██║   ██║   ██║     ██╔══██║    ██║  ██║██╔══██╗██╔══██║██║███╗██║\n" +
                "██║ ╚═╝ ██║██║  ██║   ██║   ╚██████╗██║  ██║    ██████╔╝██║  ██║██║  ██║╚███╔███╔╝\n" +
                "╚═╝     ╚═╝╚═╝  ╚═╝   ╚═╝    ╚═════╝╚═╝  ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚══╝╚══╝ \n" +
                "                                                                                  \n";
        game.animatePrint(draw, GameName.ANSI_BLUE);
    }

}