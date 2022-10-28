package lotto.domain;

import java.util.Set;

public class LottoNumbers {
    public static final int LOTTO_LOTTERY_NUMBER_SIZE = 6;

    private Set<LottoNumber> lottoNumbers;

    public LottoNumbers(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumbers = lottoNumberGenerator.generate();
        validSize();
    }

    private void validSize() {
        if (this.lottoNumbers.size() != LOTTO_LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }
}