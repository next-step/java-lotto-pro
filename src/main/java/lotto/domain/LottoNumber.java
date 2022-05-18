package lotto.domain;

import lotto.message.InputMessage;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        this(Integer.parseInt(lottoNumber));
    }

    public LottoNumber(int lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(InputMessage.INVALID_LOTTO_NUMBER);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LottoNumber)) {
            return false;
        }

        return this.lottoNumber == ((LottoNumber) obj).getLottoNumber();
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.lottoNumber, o.getLottoNumber());
    }

    @Override
    public String toString() {
        return Integer.toString(this.lottoNumber);
    }
}
