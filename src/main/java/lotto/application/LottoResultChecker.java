package lotto.application;

import lotto.domain.Number;
import lotto.domain.PickedNumbers;
import lotto.domain.Playslips;
import lotto.domain.Result;

public class LottoResultChecker {

    public static LottoResultResponse check(
        final Playslips playslips,
        final String pastWinningNumbers,
        final String bonusNumber
    ) {
        final PickedNumbers winningNumbers = PickedNumbers.of(pastWinningNumbers);
        final Number bonus = new Number(bonusNumber);
        validateNumbers(winningNumbers, bonus);
        final Result result = playslips.checkResult(winningNumbers, bonus);
        return new LottoResultResponse(result);
    }

    private static void validateNumbers(
        final PickedNumbers pastWinningNumbers,
        final Number bonusNumber
    ) {
        if (pastWinningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 볼은 일치할 수 없습니다.");
        }
    }
}
