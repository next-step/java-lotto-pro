package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLotto {
    private List<Lotto> lottoList;

    public PurchasedLotto() {
    }

    public PurchasedLotto(final List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (Lotto lotto : lottoList) {
            sb.append(lotto.toString() + "\r\n");
        }
        return sb.toString();
    }

    public LottoResult matchLottoNumbers(Lotto lastWinningLotto, LottoNo bonusNumber) {
        List<Ranking> rankings = compareLottos(lastWinningLotto, bonusNumber);
        return new LottoResult(rankings);
    }

    public List<Ranking> compareLottos(Lotto target, LottoNo bonusNumber) {
        List<Ranking> result = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            result.add(lotto.compareLotto(target, bonusNumber));
        }
        return result;
    }
}
