package lotto.domain;

import lotto.constant.LottoRank;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private final List<Lotto> purchasedLottos;

    public LottoBundle(List<Lotto> lottos) {
        this.purchasedLottos = lottos;
    }

    public int getLottoCount() {
        return purchasedLottos.size();
    }

    public List<List<String>> getStatus() {
        List<List<String>> lottoBundleStatus = new ArrayList<>();

        for (Lotto purchasedLotto : purchasedLottos) {
            lottoBundleStatus.add(purchasedLotto.getStatus());
        }

        return lottoBundleStatus;
    }

    public LottoResult getLottoResult(Lotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto purchasedLotto : purchasedLottos) {
            LottoRank lottoRank = winningLotto.checkMatchRank(purchasedLotto);
            lottoResult.addResult(lottoRank);
        }

        return lottoResult;
    }
}
