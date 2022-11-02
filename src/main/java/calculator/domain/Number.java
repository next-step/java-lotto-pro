package calculator.domain;

public class Number {

    private static final String ILLEGAL_ELEMENT_MESSAGE = "계산기의 연산 대상은 양의 정수여야 합니다. 입력값을 확인하세요";
    private int element;

    public Number(String str) {
        int num = parseStrToInt(str);
        isNegative(num);
        this.element = num;
    }

    private int parseStrToInt(String str) {

        int num = 0;

        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            handleIllegalArgument();
        }

        return num;
    }

    private void isNegative(int num) {
        if (num < 0) {
            handleIllegalArgument();
        }
    }

    private void handleIllegalArgument() {
        throw new RuntimeException(ILLEGAL_ELEMENT_MESSAGE);
    }

    public int getElement() {
        return element;
    }

}
