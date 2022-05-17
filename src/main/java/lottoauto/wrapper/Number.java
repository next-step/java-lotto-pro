package lottoauto.wrapper;

import java.util.List;

public class Number {

    private int number;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private final static String INVALID_VALUE = "1~45만 입력 가능합니다.";

    public Number(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new NumberFormatException(INVALID_VALUE);
        }
        this.number = number;
    }


    public int getNumber() {
        return this.number;
    }
}
