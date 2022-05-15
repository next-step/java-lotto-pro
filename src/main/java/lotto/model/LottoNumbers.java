package lotto.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(List<LottoNumber> firstLottoNumbers, List<LottoNumber> secondLottoNumbers) {
        this.lottoNumbers = Stream.concat(firstLottoNumbers.stream(), secondLottoNumbers.stream())
                .collect(toList());
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
