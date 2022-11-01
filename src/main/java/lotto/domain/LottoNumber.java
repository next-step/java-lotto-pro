package lotto.domain;

import lotto.dto.LottoNumberDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber implements Comparable<LottoNumber>{

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(String lottoNumberString) {
        this(Optional.ofNullable(lottoNumberString)
                .filter(str -> str.trim().matches("\\d+"))
                .map(str -> Integer.parseInt(str.trim()))
                .orElseThrow(()->new IllegalArgumentException("자연수 형식이 아닙니다.")));
    }

    public LottoNumber(int lottoNumber) {
        if(lottoNumber < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException("숫자는 "+ LOTTO_MIN_NUMBER +"이상이여야 합니다.");
        }
        if(lottoNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("숫자는 "+ LOTTO_MAX_NUMBER +"이하여야 합니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    public static List<LottoNumber> lottoNumberMinToMax() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(int number = LOTTO_MIN_NUMBER; number < LOTTO_MAX_NUMBER; number++) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }


    @Override
    public int compareTo(LottoNumber o) {
        return -1 * o.compareTo(this.lottoNumber);
    }

    public int compareTo(int lottoNumber) {
        return Integer.compare(this.lottoNumber, lottoNumber);
    }

    public LottoNumberDto getLottoNumberDto() {
        return new LottoNumberDto(lottoNumber);
    }
}
