package lotto.constant;

import static lotto.constant.LottoConstant.LOTTO_LINE_LENGTH;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_UPPER_BOUND;

public final class Message {

    private Message(){}

    public static final String ERROR_NUMBER_RANGE_VIOLATION = "[ERROR] 로또번호는 " + LOTTO_NUMBER_LOWER_BOUND
            + "부터 " + LOTTO_NUMBER_UPPER_BOUND + "까지로 한정됩니다.";
    public static final String ERROR_LOTTO_LINE_LENGTH_NOT_MATCH = "[ERROR] 각 로또는 " + LOTTO_LINE_LENGTH + "개의 숫자로 구성되어야 합니다.";


}
