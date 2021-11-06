package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers from(List<Integer> lottoNumbers) {
        return new LottoNumbers(lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
