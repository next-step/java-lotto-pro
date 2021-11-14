package lotto.ui;

public class ResultView {

    private static final String NEWLINE = "\n";

    public static void printPlayslips(final String playslips) {
        System.out.println(playslips);
    }

    public static void printStats(final String result) {
        System.out.println(NEWLINE + result);
    }
}
