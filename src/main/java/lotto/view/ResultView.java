package lotto.view;

public class ResultView {
    private static final String BOUGHT  = "개를 구매했습니다.";

    public static void printBought(int count){
        System.out.println(count+BOUGHT);
    }

}
