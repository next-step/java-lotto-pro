package lotto.view;

import java.util.List;

import lotto.domain.LottoNumber;

public class ResultView {

    public static void printPurchaseNumbers(List<LottoNumber> purchaseLottoList) {
        for (LottoNumber lottoNumber : purchaseLottoList) {
            System.out.println(lottoNumber);
        }
        System.out.println();
    }
}
