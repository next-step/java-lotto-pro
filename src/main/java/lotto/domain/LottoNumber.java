package lotto.domain;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        if (isRangeLottoNumber(number)) {
            throw new IllegalArgumentException("로또 번호는 1~45 까지만 입력 가능합니다.");
        }
        this.number = number;
    }


    private boolean isRangeLottoNumber(int number) {
        return number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number;
    }


    // TODO: 들어온 숫자가 올바른 범위에 들어있는지 확인
}
