package study.lottoAuto;

import static study.lottoAuto.MessageUtil.*;

public class OutputView {

    public static void requestInputMoney() {
        System.out.println(REQUEST_MONEY_INPUT_MSG);
    }

    public static void printPurchaseCount(int count) {
        System.out.println(String.format(PURCHASE_COUNT_OUPUT_MSG, count));
    }

    public static void printLottoNumberGroup(LottoNumbers group) {
        System.out.println(group.makeLottoNumberPrintFormat());
    }

    public static void requestLastLottoNumberGroup() {
        System.out.println(REQUEST_LAST_WEEK_LOTTO_NUMBER_INPUT_MSG);
    }

    public static void printStatics(Statics statics) {
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println(statics.makeStaticPrintFormat());
        System.out.println(statics.makeProfitPrintFormat());
    }
}
