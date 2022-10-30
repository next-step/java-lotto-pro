package domain;

public class LottoNumber {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    int number;

    public LottoNumber(int number) {
        isValidNumber(number);
        this.number = number;
    }

    private void isValidNumber(int number){
        isValidRangeNumber(number);

    }

    private void isValidRangeNumber(int number){
        if( number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER ){
            throw new IllegalArgumentException("로또번호는 1~45까지 가능합니다.");
        }
    }
}
