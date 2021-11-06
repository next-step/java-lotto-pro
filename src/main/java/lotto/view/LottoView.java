package lotto.view;

import lotto.domain.LottoBundle;

public class LottoView {
    private LottoView() {
        throw new UnsupportedOperationException();
    }

    public static void printLottoBundleStatus(LottoBundle lottoBundle) {
        System.out.printf("%d개를 구매했습니다.%n", lottoBundle.getLottoCount());
        System.out.println(lottoBundle.getStatus());
    }
}
