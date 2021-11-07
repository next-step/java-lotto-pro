package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinReader {

    private final Lotto winLotto;

    public LottoWinReader(List<Integer> numbers) {
        this.winLotto = new Lotto(numbers);
    }

    public LottoStatistic distinguish(Lottos lottos) {
        Map<Integer, Integer> statistic = new HashMap<>();
        for(Lotto lotto : lottos)
        {
            statistic.merge(lotto.correspondCount(winLotto), 1, (oldValue, newValue) -> oldValue + 1);
        }
        return new LottoStatistic(statistic);
    }

}
