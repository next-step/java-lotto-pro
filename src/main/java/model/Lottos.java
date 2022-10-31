package model;

import model.strategy.NumberStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<LottoNumber> lotto;

    public Lottos(Money money, NumberStrategy strategy) {
        int count = money.availableBuyLottoCount();
        this.lotto = new Seller().buy(count, strategy);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    public List<LottoRankType> getLottoRank(List<Integer> winNumber, int bonusNumber) {
        return lotto.stream()
                .map(lottoNumber -> getRank(lottoNumber, winNumber, bonusNumber))
                .filter(rankType -> !rankType.isFail())
                .collect(Collectors.toList());
    }

    private LottoRankType getRank(LottoNumber lottoNumber, List<Integer> winNumber, int bonusNumber) {
        int countOfContain = lottoNumber.getCountOfContain(winNumber);
        boolean isContainBonusNumber = lottoNumber.isContainBonusNumber(bonusNumber);

        return LottoRankType.convertRank(countOfContain, isContainBonusNumber);
    }
}
