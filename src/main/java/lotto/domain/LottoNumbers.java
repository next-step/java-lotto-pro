package lotto.domain;

import lotto.service.CreateShuffledLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private List<String> lottoNumbers = new ArrayList<>();

    public LottoNumbers(List<String> lottoNumbers) {
        validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumbers(List<String> lottoNumbers) {
        lottoNumbers.stream()
                .filter(l -> Integer.parseInt(l) < CreateShuffledLottoNumbers.LOTTO_START_NUMBER || Integer.parseInt(l) > CreateShuffledLottoNumbers.LOTTO_END_NUMBER)
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
