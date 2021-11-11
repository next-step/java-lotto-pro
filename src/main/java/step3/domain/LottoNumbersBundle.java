package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public int size() {
        return lottoNumbersBundle.size();
    }

    private List<LottoNumbers> getLottoNumbersBundle() {
        return lottoNumbersBundle;
    }
}
