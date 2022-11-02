package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> list) {
        this.lottoList = Collections.unmodifiableList(list);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Rewards check(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return this.lottoList.stream()
            .map(lotto -> Rank.valueOf(lotto.matchedNumbersCount(winningNumbers), lotto.matchBonus(bonusNumber)))
            .collect(Collectors.collectingAndThen(Collectors.toList(), Rewards::new));
    }
}
