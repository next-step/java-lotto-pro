package lotto.auto.common;

public class LottoAutoUtils {
    public int stringToNumber(String number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
        number = number.trim();
        if (number.chars().allMatch(Character::isDigit)) {
            return Integer.parseInt(number);
        }
        throw new IllegalArgumentException();
    }
}
