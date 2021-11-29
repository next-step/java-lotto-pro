package lotto.domain;

import lotto.exception.DuplicateLottoNumberException;

public class BonusNumber extends LottoNumber {

    public BonusNumber(Integer number, Lotto winningLotto) {
        super(number);
        checkDuplicate(number, winningLotto);
    }

    private void checkDuplicate(Integer number, Lotto winningLotto) {
        for (LottoNumber winningNumber : winningLotto.getLottoNumbers()) {
            checkDuplicate(number, winningNumber);
        }
    }

    private void checkDuplicate(Integer number, LottoNumber winningNumber) {
        if (number.equals(winningNumber.getNumber())) {
            throw new DuplicateLottoNumberException();
        }
    }
}
