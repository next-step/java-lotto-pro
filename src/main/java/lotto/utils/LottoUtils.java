package lotto.utils;

import static lotto.constants.LottoConstants.MAX;
import static lotto.constants.LottoConstants.MIN;

public class LottoUtils {

    public static boolean isLottoNumberSize(int number) {
        return number > MAX || number < MIN;
    }
}
