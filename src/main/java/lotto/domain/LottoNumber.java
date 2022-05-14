package lotto.domain;

public class LottoNumber {
    private int number;

    public static final int LOTTO_NUMBER_MIN_VALUE = 1;
    public static final int LOTTO_NUMBER_MAX_VALUE = 45;

    public LottoNumber(int number) {
        if(number < LOTTO_NUMBER_MIN_VALUE || number > LOTTO_NUMBER_MAX_VALUE){
            throw new IllegalArgumentException(
                    String.format("[ERROR]LottoNumber는 %d 이상 %d 이하여야 합니다.",
                            LOTTO_NUMBER_MIN_VALUE, LOTTO_NUMBER_MAX_VALUE));
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
