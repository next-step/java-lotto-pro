package lotto.controller.validator;

import lotto.domain.LottoFactory;
import lotto.domain.LottoHelper;
import lotto.domain.LottoNumbers;

public class LottoValidator {

    public void validateCountPurchasableLotto(int amount) {
        if (amount < LottoHelper.LOTTO_PER_PRICE) {
            throw new IllegalArgumentException("구입 금액은 " + LottoHelper.LOTTO_PER_PRICE + "보다 커야합니다. (입력값: " + amount + ")");
        }
    }

    public void validateCountWinningNumber(LottoNumbers winningLottoNumbers, LottoNumbers myLottoNumbers) {
        validateWLottoNumbersEmpty(winningLottoNumbers, "지난 주 당첨 번호가 존재하지 않습니다.");
        validateWLottoNumbersEmpty(myLottoNumbers, "구입한 로또 번호가 존재하지 않습니다.");

        validateLottoNumbersSize(winningLottoNumbers, "지난 주 당첨 번호가 ");
        validateLottoNumbersSize(myLottoNumbers, "구입한 로또 번호가 ");
    }

    private void validateLottoNumbersSize(LottoNumbers lottoNumbers, String message) {
        int lottoNumbersSize = lottoNumbers.getLottoNumbers().size();
        if (lottoNumbersSize != LottoFactory.LOTTO_SIZE) {
            throw new IllegalArgumentException(message + LottoFactory.LOTTO_SIZE + "개가 아닙니다. (입력된 갯수: " + lottoNumbersSize);
        }
    }

    private void validateWLottoNumbersEmpty(LottoNumbers lottoNumbers, String message) {
        if (lottoNumbers == null || lottoNumbers.getLottoNumbers() == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public void validateGetRateOfReturn(int purchaseCount, int winningAmount) {
        if (purchaseCount <= 0) {
            new IllegalArgumentException("구입한 로또 갯수는 0보다 커야합니다. (입력값: " + purchaseCount);
        }

        if (winningAmount < 0) {
            new IllegalArgumentException("당첨 금액은 음수일 수 없습니다. (입력값: " + winningAmount);
        }
    }
}
