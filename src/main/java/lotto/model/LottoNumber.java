package lotto.model;

public class LottoNumber implements Comparable<LottoNumber> {
    public final static int MIN_LOTTO_NUMBER = 1;
    public final static int MAX_LOTTO_NUMBER = 45;

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

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if(lottoNumber.number < this.number) {
            return 1;
        }

        return -1;
    }
}
