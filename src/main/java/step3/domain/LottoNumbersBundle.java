package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import step3.domain.constance.LottoConstant;

public class LottoNumbersBundle {
    private final List<LottoNumbers> lottoNumbersBundle;

    private LottoNumbersBundle(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbersBundle = lottoNumbers;
    }

    public static LottoNumbersBundle of(List<LottoNumbers> lottoNumbers) {
        return new LottoNumbersBundle(lottoNumbers);
    }

    public void merge(LottoNumbersBundle buyLottoNumbersBundle) {
        this.lottoNumbersBundle.addAll(buyLottoNumbersBundle.getLottoNumbersBundle());
    }

    public int getTotalPrise() {
        return LottoConstant.LOTTO_MINIMUM_PRICE * lottoNumbersBundle.size();
    }

    public int countOf(BuyType buyType) {
        return (int)lottoNumbersBundle.stream()
            .filter(lottoNumbers -> lottoNumbers.isBuyType(buyType))
            .count();
    }

    public List<String> numbersForResults() {
        List<String> result = new ArrayList<>();
        for (LottoNumbers lottoNumbers : lottoNumbersBundle) {
            result.add(lottoNumbers.toCommaSerialize());
        }

        return Collections.unmodifiableList(result);
    }

    public int getLottoMatchCountOf(LottoRank matchLottoRank, WinningLotto winningLotto) {
        return (int)lottoNumbersBundle.stream()
            .map(lottoNumbers -> LottoRank.valueOf(winningLotto.containCount(lottoNumbers),
                winningLotto.bonusMatch(lottoNumbers)))
            .filter(lottoRank -> lottoRank == matchLottoRank)
            .count();
    }

    private List<LottoNumbers> getLottoNumbersBundle() {
        return lottoNumbersBundle;
    }
}
