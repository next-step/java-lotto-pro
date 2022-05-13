package study.lotto.dto;

import java.util.List;

public class PurchasedLottos {

    private final List<PurchasedLotto> lottoList;

    public PurchasedLottos(List<PurchasedLotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<PurchasedLotto> getLottoList() {
        return lottoList;
    }
}
