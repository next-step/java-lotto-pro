package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private static final Integer LOTTO_START_NUMBER = 1;
    private static final Integer LOTTO_END_NUMBER = 45;
    private List<String> lottoNumbers = new ArrayList<>();

    public LottoNumbers(List<String> lottoNumbers) {
        validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumbers(List<String> lottoNumbers) {
        lottoNumbers.stream()
                .filter(l -> Integer.parseInt(l) < LOTTO_START_NUMBER || Integer.parseInt(l) > LOTTO_END_NUMBER)
                .forEach(l -> {
                    throw new IllegalArgumentException("");
                });
    }

    public long compare(LottoNumbers winningNumbers) {
        return  lottoNumbers.stream()
                        .filter(l -> winningNumbers.isContainNumber(l))
                        .count();
    }

    private boolean isContainNumber(String lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<String> getLottoNumbers() {
        return lottoNumbers;
    }
}
