package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;
    private final LottoTypesCount lottoTypesCount;

    public LottoTicket(List<Lotto> lottos, LottoTypesCount lottoTypesCount) {
        this.lottos = lottos;
        this.lottoTypesCount = lottoTypesCount;
    }

    public List<Rank> createWinningRanks(WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(winningLotto.createWinningRank(lotto));
        }
        return ranks;
    }

    public int getCountOfLottoType(LottoType lottoType) {
        return lottoTypesCount.getCountOfType(lottoType);
    }

    @Override
    public String toString() {
        StringBuilder lottoStringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            lottoStringBuilder.append(lotto);
            lottoStringBuilder.append("\n");
        }
        return lottoStringBuilder.toString();
    }
}
