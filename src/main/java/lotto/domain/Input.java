package lotto.domain;

import lotto.util.Constants;
import lotto.util.IntUtil;
import lotto.util.RegexUtil;
import lotto.util.StringUtil;

public class Input {
    private static final String ERR_MORE_THAN_1000 = "1000 이상의 숫자를 입력해 주세요.";
    private static final String REGEX_NUMBER = "^[0-9]+$";
    
    public final int amount;

    public Input(String amount) {
        this.amount = validate(amount);
    }

    private int validate(String amount) {
        if (StringUtil.isNullOrEmpty(amount)) {
            throw new IllegalArgumentException(Constants.ERR_NULL_VALUE);
        }
        if (!RegexUtil.match(REGEX_NUMBER, amount)) {
            throw new IllegalArgumentException(Constants.ERR_VALUE_NOT_VALID);
        }

        int result = IntUtil.parseInt(amount);

        if (result < 1000) {
            throw new IllegalArgumentException(ERR_MORE_THAN_1000);
        }

        return result;
    }


}
