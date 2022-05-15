package lotto.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getQuantity() {
        return lottoNumbers.size();
    }

    public LottoRanks resultLottoRanks(WinningLottoNumber winningLottoNumber) {
        return lottoNumbers.stream()
                .map(winningLottoNumber::matchLottoRank)
                .collect(collectingAndThen(toList(), LottoRanks::of));
    }
}
