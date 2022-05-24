package lotto.constant;

import static lotto.constant.LottoConstant.LOTTO_LINE_LENGTH;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_UPPER_BOUND;
import static lotto.constant.LottoConstant.LOTTO_PRICE_EACH;

public final class Message {

    private Message(){}

    public static final String ERROR_NUMBER_RANGE_VIOLATION = "[ERROR] 로또번호는 " + LOTTO_NUMBER_LOWER_BOUND
            + "부터 " + LOTTO_NUMBER_UPPER_BOUND + "까지로 한정됩니다.";
    public static final String ERROR_LOTTO_LINE_LENGTH_NOT_MATCH = "[ERROR] 각 로또는 " + LOTTO_LINE_LENGTH + "개의 숫자로 구성되어야 합니다.";
    public static final String ERROR_LOTTO_DUPLICATE_NUMBER = "[ERROR] 중복된 숫자가 존재합니다.";
    public static final String ERROR_LOTTO_TOTAL_PAYMENT_MIN = "[ERROR] 로또 1개의 가격은 " + LOTTO_PRICE_EACH +"원 입니다. " + LOTTO_PRICE_EACH + "원 이상의 금액을 입력해주세요.";
    public static final String ERROR_LOTTO_WINNER_STRING_FORMAT = "[ERROR] 지난 주 당첨 번호는 \", \"로 구분하여 숫자로만 입력해주세요.";

}
