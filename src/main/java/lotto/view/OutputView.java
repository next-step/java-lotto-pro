package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class OutputView {

    public void purchaseLottoList(Lotto lotto) {
        int purchaseCount = lotto.getLottoNumbers().size();
        System.out.println(purchaseCount + "개를 구매했습니다.");
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            System.out.println(lottoNumber.toString());
        }
    }
}
