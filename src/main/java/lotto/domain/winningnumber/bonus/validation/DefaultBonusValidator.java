package lotto.domain.winningnumber.bonus.validation;

import java.util.Arrays;
import java.util.Set;

public class DefaultBonusValidator implements BonusValidator {

    private static final String ERROR_BONUS_DUPLICATE_MESSAGE = "[ERROR] 당첨번호와 중복 된 값이 입력되었습니다.";
    private Set<Integer> winningNumber;

    public DefaultBonusValidator(Set<Integer> winningNumber) {
        this.winningNumber = winningNumber;

    }

    @Override
    public void validate(String bonus) {
        Arrays.asList(new NumberValidator(), new RangeValidator())
                .forEach(validator -> validator.validate(bonus));
        isDuplicateThenThrow(Integer.parseInt(bonus));
    }

    private void isDuplicateThenThrow(int bonus) {
        int defaultSize = winningNumber.size();
        winningNumber.add(bonus);
        if (defaultSize == winningNumber.size()) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE_MESSAGE);
        }
    }
}
