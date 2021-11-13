package lotto.ui;

public class ResultView {

    public static void printPlayslips(final int numberOfPlayslips, final String playslips) {
        System.out.println(numberOfPlayslips + "개를 구매했습니다.");
        System.out.println(playslips);
    }

    public static void printStats(final String prizes, final double returnOnInvestment) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(prizes);
        System.out.println("총 수익률은 " + returnOnInvestment + " 입니다.");
    }
}
