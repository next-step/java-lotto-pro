package lotto.domain.winningnumber.bonus.validation;

public class RangeValidator implements BonusValidator {

    public static final String ERROR_BONUS_RANGE_MESSAGE = "[ERROR] 보너스 볼이 1 ~ 45 사이의 수가 아닙니다";

    @Override
    public void validate(String bonus) {
        int parseBonus = Integer.parseInt(bonus);
        if (parseBonus < 1 || parseBonus > 45) {
            throw new IllegalArgumentException(ERROR_BONUS_RANGE_MESSAGE);
        }
    }
}
