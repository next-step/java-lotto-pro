package study.lotto.automatic.domain;

public class LottoNumber {
    static final int MINIMUM_NUMBER = 1;
    static final int MAXIMUM_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (validate(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자만 허용합니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    private boolean validate(int lottoNumber) {
        return lottoNumber < MINIMUM_NUMBER || lottoNumber > MAXIMUM_NUMBER;
    }
}
