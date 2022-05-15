package lotto.view;

import lotto.model.LottoNumbers;

public class ResultView {
    private static final String PURCHASE_COUNT_OUTPUT_MESSAGE = "%d개를 구매했습니다.";

    public static void printPurchaseCountOutput(int count) {
        System.out.printf(PURCHASE_COUNT_OUTPUT_MESSAGE + "\n", count);
    }

    public static void printLottoNumbers(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers);
    }
}
