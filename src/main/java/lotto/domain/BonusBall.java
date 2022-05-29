package lotto.domain;

import lotto.LottoNumberValidator;

import java.util.List;

public class BonusBall {
    private final int value;

    public BonusBall(int value, List<Integer> numbers) {
        validBonusBall(value, numbers);
        this.value = value;
    }

    public int value() {
        return value;
    }

    private void validBonusBall(int value, List<Integer> numbers) {
        LottoNumberValidator.validLottoNumber(value);
        if (numbers.contains(value)) {
            throw new IllegalArgumentException("bonusBall은 당첨번호와 중복되선 안됩니다.");
        }
    }
}
