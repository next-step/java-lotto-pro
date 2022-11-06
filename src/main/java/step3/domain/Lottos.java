package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> list) {
        this.lottoList = Collections.unmodifiableList(list);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getHasLottoSize() {
        return lottoList.size();
    }

    public Rewards check(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return this.lottoList.stream()
            .map(lotto -> Rank.valueOf(lotto.matchedNumbersCount(winningNumbers), lotto.matchBonus(bonusNumber)))
            .collect(Collectors.collectingAndThen(Collectors.toList(), Rewards::new));
    }

    public Lottos merge(Lottos otherLottos) {
        List<Lotto> mergeLottoList = Stream.concat(this.lottoList.stream(), otherLottos.lottoList.stream())
            .collect(Collectors.toList());
        return new Lottos(mergeLottoList);
    }
}
