package lotto.domain.winningnumber.bonus.validation;

public class RangeValidator implements BonusValidator {

    private static final String ERROR_BONUS_RANGE_MESSAGE = "[ERROR] 보너스 볼이 1 ~ 45 사이의 수가 아닙니다";
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    @Override
    public void validate(String bonus) {
        int parseBonus = Integer.parseInt(bonus);
        if (parseBonus < MIN_RANGE || parseBonus > MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_BONUS_RANGE_MESSAGE);
        }
    }
}
