package lotto.domain;

public class LottoNumber {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    private String lottoNumber;

    public LottoNumber(String lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(String lottoNumber) {
        if (Integer.parseInt(lottoNumber) < LottoNumber.LOTTO_START_NUMBER || Integer.parseInt(lottoNumber) > LottoNumber.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또 번호 범위는 1 ~ 45 입니다.");
        }
    }

    public String getValue() {
        return lottoNumber;
    }
}
