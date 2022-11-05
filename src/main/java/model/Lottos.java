package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<LottoNumber> lotto;

    public Lottos(List<LottoNumber> autoLottoNumber, List<LottoNumber> manualLottoNumber) {
        this.lotto = new ArrayList<>();
        lotto.addAll(autoLottoNumber);
        lotto.addAll(manualLottoNumber);
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
        boolean isMatchBonusNumber = lottoNumber.isMatchBonusNumber(bonusNumber);

        return LottoRankType.convertRank(countOfContain, isMatchBonusNumber);
    }
}
