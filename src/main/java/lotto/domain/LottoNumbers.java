package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(List<String> lottoNumbers) {
        validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                                .map(l -> new LottoNumber(Integer.parseInt(l)))
                                .collect(Collectors.toList());
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

    private boolean isContainNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<String> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(l -> l.getValue())
                .collect(Collectors.toList());
    }

    public boolean isContainBonusNumber(WinningLottoNumbers winningNumbers) {
        return isContainNumber(winningNumbers.getBonusNumber());
    }
}
