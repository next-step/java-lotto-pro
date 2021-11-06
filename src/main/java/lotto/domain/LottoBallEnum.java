package lotto.domain;

public enum LottoBallEnum {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_BALLS_SIZE(6);

    private int number;

    LottoBallEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
