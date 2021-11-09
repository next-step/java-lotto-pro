package lotto.domain;

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
                .filter(l -> Integer.parseInt(l) < LottoNumber.LOTTO_START_NUMBER || Integer.parseInt(l) > LottoNumber.LOTTO_END_NUMBER)
                .findAny()
                .ifPresent(l -> {
                    throw new IllegalArgumentException("로또 번호 범위는 1 ~ 45 입니다.");
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

    public boolean isContainBonusNumber(WinningLottoNumbers winningNumbers) {
        return isContainNumber(winningNumbers.getBonusNumber());
    }
}
