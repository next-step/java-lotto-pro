package lotto.domain.number;

import lotto.domain.ticket.*;

public class WinningNumbers extends LottoNumbers {
    private static final String BONUS_NUMBER_IS_CONTAINED_IN_LOTTO_NUMBERS = "보너스 번호가 로또 번호에 포함되었습니다.";

    private final LottoNumber bonusNumber;

    private WinningNumbers(LottoNumbers lottoNumbers, int lottoNumber) {
        super(lottoNumbers);
        validate(lottoNumbers, lottoNumber);
        this.bonusNumber = LottoNumber.from(lottoNumber);
    }

    public static WinningNumbers of(LottoNumbers lottoNumbers, int lottoNumber) {
        return new WinningNumbers(lottoNumbers, lottoNumber);
    }

    private void validate(LottoNumbers lottoNumbers, int lottoNumber) {
        if (lottoNumbers.contains(LottoNumber.from(lottoNumber))) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_CONTAINED_IN_LOTTO_NUMBERS);
        }
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }

}
