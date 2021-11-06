package lotto.domain;

import lotto.constant.LottoRank;

import java.util.List;

public class LottoBundle {
    private final List<Lotto> purchasedLottos;

    public LottoBundle(List<Lotto> lottos) {
        this.purchasedLottos = lottos;
    }

    public int getLottoCount() {
        return purchasedLottos.size();
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();

        for (Lotto purchasedLotto : purchasedLottos) {
            sb.append(purchasedLotto.getStatus());
            sb.append("\n");
        }

        return sb.toString();
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
