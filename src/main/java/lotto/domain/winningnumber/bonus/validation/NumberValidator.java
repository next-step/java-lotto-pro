package lotto.domain.winningnumber.bonus.validation;

import java.util.regex.Pattern;

public class NumberValidator implements BonusValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    private static final String ERROR_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스볼은 숫자만 입력할 수 있습니다.";

    @Override
    public void validate(String bonus) {
        if (!NUMBER_PATTERN.matcher(bonus).matches()) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_MESSAGE);
        }
    }

}
