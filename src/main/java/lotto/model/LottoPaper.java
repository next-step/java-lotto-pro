package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoPaper {

    private final List<LottoNumber> lottoNumbers;

    public LottoPaper(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean isContainsLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int matchLottoPaper(LottoPaper winningLottoPaper) {
        return (int) this.lottoNumbers.stream()
                .filter(winningLottoPaper::isContainsLottoNumber)
                .count();

    }

}
