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
        final Result result = playslips.checkResult(
            PickedNumbers.of(pastWinningNumbers),
            new Number(bonusNumber)
        );
        return new LottoResultResponse(result);
    }
}
