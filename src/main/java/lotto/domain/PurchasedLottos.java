package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLottos {
    private List<Lotto> lottoList;

    public PurchasedLottos() {
    }

    public PurchasedLottos(final List<Lotto> lottoList) {
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

    public List<Ranking> compareLottos(Lotto target) {
        List<Ranking> result = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            result.add(lotto.compareLotto(target));
        }
        return result;
    }
}
