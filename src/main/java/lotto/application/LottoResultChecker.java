package lotto.application;

import lotto.domain.Number;
import lotto.domain.PickedNumbers;
import lotto.domain.Playslips;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;

public class LottoResultChecker {

    public static LottoResultResponse check(
        final Playslips playslips,
        final String pastWinningNumbers,
        final String bonusNumber
    ) {
        final WinningNumbers winningNumbers = new WinningNumbers(
            PickedNumbers.of(pastWinningNumbers),
            new Number(bonusNumber)
        );
        final Result result = playslips.checkResult(winningNumbers);
        return new LottoResultResponse(result);
    }
}
