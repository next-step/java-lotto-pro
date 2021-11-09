package study.lotto.auto;

import static study.lotto.auto.MessageUtil.*;

public class OutputView {

    public static void requestInputMoney() {
        System.out.println(REQUEST_MONEY_INPUT_MSG);
    }

    public static void printPurchaseCount(int count) {
        System.out.println(String.format(PURCHASE_COUNT_OUPUT_MSG, count));
    }

    public static void printLottoNumbersGroup(LottoNumbersGroup group) {
        for(LottoNumbers lottoNumbers : group.getLottoNumbersList()){
            System.out.println(lottoNumbers.makeLottoNumberPrintFormat());
        }
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
