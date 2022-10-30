package step3.model.lotto;

import java.util.Objects;
import step3.model.util.InputValidation;

public class LottoNumber {
    private final int number;
    public LottoNumber(final String input) {
        this.number = validatedLottoNumber(input);
    }
    public LottoNumber(final int input) {
        this.number = input;
    }

    private int validatedLottoNumber(String input) {
        InputValidation.validateEmpty(input);
        InputValidation.validateNumber(input);
        int number = Integer.parseInt(input);
        InputValidation.validateIntRange(number);
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
