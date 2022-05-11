package lotto.model;

public class LottoNumber {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if(MIN_LOTTO_NUMBER > number || MAX_LOTTO_NUMBER < number){
            throw new IllegalArgumentException("1~45 숫자만 유효합니다.");
        }
    }
}
