package lotto.model;

import java.util.Objects;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRoleConst;

public class LottoNumber {

    private final int number;

    public LottoNumber(String numberWord) {
        this.number = parseLottoNumber(numberWord);
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    private int parseLottoNumber(String numberWord){
        return validateLottoNumber(parseNumber(numberWord));
    }
    private int parseNumber(String numberWord) {
        if (!numberWord.matches("\\p{Digit}+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
        return Integer.parseInt(numberWord);
    }
    private int validateLottoNumber(int number) {
        if (number < LottoRoleConst.LOW_NUMBER || number > LottoRoleConst.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER);
        }
        return number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
