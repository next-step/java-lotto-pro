package lotto.ui;

public class ResultView {

    private static final String NEWLINE = "\n";

    public static void printPlayslips(final int numberOfPlayslips, final String playslips) {
        System.out.println(numberOfPlayslips + "개를 구매했습니다.");
        System.out.println(playslips + NEWLINE);
    }

    public static void printStats(final String result) {
        System.out.println(NEWLINE + result);
    }
}
