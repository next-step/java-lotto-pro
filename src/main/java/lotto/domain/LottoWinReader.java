package lotto.domain;

import java.util.List;

public class LottoWinReader {

    private Lotto winLotto;

    public LottoWinReader(List<Integer> numbers) {
        this.winLotto = new Lotto(numbers);
    }

    public StatisticResult win(Lottos lottos) {
        StatisticResult statistic = new StatisticResult();
        for(Lotto lotto : lottos)
        {
            statistic.report(lotto.correspondCount(winLotto));
        }
        return statistic;
    }
}
