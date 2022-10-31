package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int getHasLottoSize() {
        return lottoList.size();
    }

    public Rewards check(final LottoNumbers winningNumbers, final LottoNumber bonusNumber) {
        return this.lottoList.stream()
                .map(lotto -> Rank.of(lotto.compareNumbers(winningNumbers), lotto.isBonusWin(bonusNumber)))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Rewards::new));
    }

    @Override
    public String toString() {
        return lottoList.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
