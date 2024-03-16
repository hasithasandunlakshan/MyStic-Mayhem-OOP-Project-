
public class GameName {
    public static final String ANSI_RESET = "\u001B[0m";
    public final static String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLINK = "\u001B[5m";

    public void animatePrint(String text, String color) {
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

    /*
     * private void animatePrintSlow(String text, String color) {
     * System.out.print(color);
     * for (char c : text.toCharArray()) {
     * System.out.print(c);
     * try {
     * Thread.sleep(50); // Adjust the delay as needed
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * }
     * }
     * System.out.print(ANSI_RESET); // Reset color after printing
     * System.out.println();
     * }
     */

    public void blinkText(String text, int repeat, int durationMillis, String color) {
        try {
            for (int i = 0; i < repeat; i++) {
                System.out.print(ANSI_BLINK + color + text + ANSI_RESET + "\r"); // Blinking text
                Thread.sleep(durationMillis);
                System.out.print(" ".repeat(text.length()) + "\r"); // Erase the text
                Thread.sleep(durationMillis);
            }
            // Print the text without blinking after the blinking effect finishes
            System.out.println(color + text + ANSI_RESET);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void gameStart() {

        String ANSI_LIGHT_BLUE = "\u001B[94m";
        GameName gameName = new GameName();
        String k = "  ╔███╗   █████╗   ███████████████████╗██████╗    ███╗   ███╗█████╗██╗   ████╗  ████████████╗   ███╗\n"
                +
                "  ║████╗ ████╚██╗ ██╔██╔════╚══██╔══████╔════╝    ████╗ ██████╔══██╚██╗ ██╔██║  ████╔════████╗ ████║\n"
                +
                "  ║██╔████╔██║╚████╔╝███████╗  ██║  ████║         ██╔████╔█████████║╚████╔╝████████████╗ ██╔████╔██║\n"
                +
                "  ║██║╚██╔╝██║ ╚██╔╝ ╚════██║  ██║  ████║         ██║╚██╔╝████╔══██║ ╚██╔╝ ██╔══████╔══╝ ██║╚██╔╝██║\n"
                +
                "  ║██║ ╚═╝ ██║  ██║  ███████║  ██║  ██╚██████╗    ██║ ╚═╝ ████║  ██║  ██║  ██║  ███████████║ ╚═╝ ██║\n"
                +
                "   ╚═╝     ╚═╝  ╚═╝  ╚══════╝  ╚═╝  ╚═╝╚═════╝    ╚═╝     ╚═╚═╝  ╚═╝  ╚═╝  ╚═╝  ╚═╚══════╚═╝     ╚═╝\n"
                +
                "                                                                                                   \n"
                +
                "\n";
        // System.out.println( ANSI_LIGHT_BLUE+k);

        animatePrint(k, ANSI_BLUE);

        blinkText(" ................................LET'S Play...................................", 3, 500, ANSI_RED);
    }

}