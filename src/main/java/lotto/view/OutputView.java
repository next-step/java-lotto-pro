package lotto.view;

public class OutputView {
    private static final String SIZE_FORMAT = "%s개를 구매했습니다.";

    public static void printLottoCount(int count) {
        System.out.println(String.format(SIZE_FORMAT, count));
    }

    public static void printLottos(String text) {
        System.out.println(text);
    }

    public static void printStatistic(String text) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(text);
    }


}
