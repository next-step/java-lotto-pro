package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private static final Integer LOTTO_START_NUMBER = 1;
    private static final Integer LOTTO_END_NUMBER = 45;
    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumbers(List<Integer> lottoNumbers) {
        validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumbers(List<Integer> lottoNumbers) {
        lottoNumbers.stream()
                .filter(l -> l < LOTTO_START_NUMBER || l > LOTTO_END_NUMBER)
                .forEach(l -> {
                    throw new IllegalArgumentException("");
                });
    }

    public long compare(LottoNumbers winningNumbers) {
        return  lottoNumbers.stream()
                        .filter(l -> winningNumbers.containNumber(l))
                        .count();
    }

    private boolean containNumber(Integer lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
