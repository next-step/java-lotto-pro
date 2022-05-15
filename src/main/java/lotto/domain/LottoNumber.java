package lotto.domain;

import java.util.Objects;
import lotto.constants.LottoConstants;

public class LottoNumber {

    private static final String ERROR_MESSAGE_NUMBER_IS_NULL = "[ERROR] This number is null.";
    private static final String ERROR_MESSAGE_NUMBER_OUT_OF_RANGE = "[ERROR] This number is out of range.";

    private final Integer number;

    public LottoNumber(final Integer number) {
        validate(number);

        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private void validate(final Integer number) {
        if(number == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_IS_NULL);
        }

        validateNumberRange(number);
    }

    private void validateNumberRange(final Integer number) {
        if (number < LottoConstants.MIN_LOTTO_NUMBER || number > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_OUT_OF_RANGE);
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof LottoNumber)) {
            return false;
        }
        return this.number.equals(((LottoNumber) obj).getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }
}
