package lotto.domain;

import lotto.util.Constants;
import lotto.util.IntUtil;
import lotto.util.RegexUtil;
import lotto.util.Validator;

public class Money {
    private static final String ERR_MORE_THAN_1000 = "1000 이상의 숫자를 입력해 주세요.";
    private static final String REGEX_NUMBER = "^[0-9]+$";
    
    public final int amount;

    public Money(String amount) {
        this.amount = generate(amount);
    }
    
    public Money(int amount) {
        this.amount = amount;
    }

    private int generate(String amount) {
        Validator.validateIsEmpty(amount);
        validateIsNumber(amount);

        int result = IntUtil.parseInt(amount);

        validateIsMoreThanThousand(result);

        return result;
    }
    
    private void validateIsNumber(String amount) {
        if (!RegexUtil.match(REGEX_NUMBER, amount)) {
            throw new IllegalArgumentException(Constants.ERR_VALUE_NOT_VALID);
        } 
    }
    
    private void validateIsMoreThanThousand(int result) {
        if (result < 1000) {
            throw new IllegalArgumentException(ERR_MORE_THAN_1000);
        }
    }
}
