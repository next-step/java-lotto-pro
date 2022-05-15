package lotto.view;

import lotto.domain.LottoNumber;

import java.util.List;

public class ResultView {
    private final static String PURCHASE_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public void printPurchaseLottoCount(int purchaseCount) {
        System.out.printf(PURCHASE_LOTTO_COUNT_MESSAGE, purchaseCount);
    }

    public void printIssuedLottoNumber(List<LottoNumber> lottoNumbers) {
        lottoNumbers.forEach(lottoNumber -> {
            System.out.println(lottoNumbers);
        });
    }
}
