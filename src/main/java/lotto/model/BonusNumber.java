package lotto.model;

import lotto.exception.InvalidInputException;

import java.util.List;

public class BonusNumber extends LottoNumber {

    private static final String INVALID_DUPLICATE_MESSAGE = "당첨번호와 중복된 보너스번호를 입력할 수 없습니다.";

    public BonusNumber(String value, LottoNumbers winningNumbers) {
        super(Integer.parseInt(value));
        validateDuplicated(winningNumbers.getValues());
    }

    /**
     * 보너스번호 값 중복 유효성검사
     * 당첨번호와 중복되면 예외처리를 합니다.
     *
     * @param numbers 당첨번호
     */
    private void validateDuplicated(List<LottoNumber> numbers) {
        boolean hasDuplicatedNumber = numbers.stream()
                .anyMatch(winningNumber -> winningNumber.getValue() == this.getValue());

        if (hasDuplicatedNumber) {
            throw new InvalidInputException(String.format(INVALID_DUPLICATE_MESSAGE));
        }
    }

}
