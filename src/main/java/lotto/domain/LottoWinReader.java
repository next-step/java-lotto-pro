package lotto.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinReader {

    private final Lotto winLotto;
    private LottoNumber bonusNumber;

    public LottoWinReader(List<Integer> numbers, int bonus) {
        this.winLotto = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonus, true);
    }

    public LottoStatistic distinguish(Lottos lottos) {
        Map<Winnings, Integer> statistic = new EnumMap<>(Winnings.class);
        for(Lotto lotto : lottos)
        {
            statistic.merge(lotto.acquireWinnings(winLotto, bonusNumber), 1, (oldValue, newValue) -> oldValue + 1);
        }
        return new LottoStatistic(statistic);
    }

}
