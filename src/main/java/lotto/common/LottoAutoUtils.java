package lotto.common;

public class LottoAutoUtils {
    public int stringToNumber(String number) {
        if (number == null) {
            throw new IllegalArgumentException("입력하신 숫자는 null 입니다.");
        }
        number = number.trim();
        if (number.chars().allMatch(Character::isDigit)) {
            return Integer.parseInt(number);
        }
        throw new IllegalArgumentException("입력하신 문자는 숫자가 아닙니다.");
    }
}
