package lotto.view;

import lotto.model.LottoPaperList;

public class ResultView {

    public static void printBuyCountOutput(long buyCount) {
        System.out.printf("%d %s%n", buyCount, GameMessage.BUY_COUNT_OUTPUT);
    }

    public static void printLottoPaperList(LottoPaperList lottoPaperList) {
        lottoPaperList.getLottoPaperList().forEach( lottoPaper -> System.out.println(lottoPaper.getLottoNumber()) );
    }
    public static String invalidInputMsg(String msg) {
        return String.format("%s %s", GameMessage.ERR_MSG, msg);
    }


}
