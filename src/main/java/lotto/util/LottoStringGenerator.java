package lotto.util;

import static lotto.constant.LottoConstant.SEPARATOR;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.LottoLine;
import lotto.exception.LottoWinnerStringFormatException;

public class LottoStringGenerator {

    public static LottoLine toWinLottoLine(String winLottoLine) throws LottoWinnerStringFormatException {
        return new LottoLine(Arrays.stream(winLottoLine
            .split(SEPARATOR))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList()));
    }

}
