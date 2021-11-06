package calculator;

public class StringParseNumber {

    private static final int MIN_VALUE = 0;

    public static int parseNumber(String number) {
        try {
            int parseNumber = Integer.parseInt(number);
            if (parseNumber < MIN_VALUE) {
                throw new IllegalArgumentException ("문자열에 음수 값이 포함되어 있습니다.");
            }
            return parseNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException ("숫자만 입력이 가능합니다.");
        }
    }
}
