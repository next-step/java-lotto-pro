package calculator.domain;

public class Num {

    private static final String ILLEGAL_ELEMENT_MESSAGE = "계산기의 연산 대상은 양의 정수여야 합니다. 입력값을 확인하세요";
    int element;

    public Num(String str) {
        int num = isNumberType(str);
        isNegative(num);
        this.element = num;
    }

    private int isNumberType(String str) {

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
        System.out.println(ILLEGAL_ELEMENT_MESSAGE);
        throw new RuntimeException();
    }

    public int getElement() {
        return element;
    }

}
