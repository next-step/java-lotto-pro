package lotto.domain;

import lotto.dto.LottoNumberDto;

import java.util.*;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final Map<Integer,LottoNumber> lottoNumbers = new HashMap<>();
    private static final List<LottoNumber> lottoNumberList = new ArrayList<>();

    private final int lottoNumber;

    static {
        for (int number = LOTTO_MIN_NUMBER; number <= LOTTO_MAX_NUMBER; number++) {
            LottoNumber lottoNumber = new LottoNumber(number);
            lottoNumbers.put(number, lottoNumber);
            lottoNumberList.add(lottoNumber);
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number) {
        if (number < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException("숫자는 " + LOTTO_MIN_NUMBER + "이상이여야 합니다.");
        }
        if (number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("숫자는 " + LOTTO_MAX_NUMBER + "이하여야 합니다.");
        }
        return lottoNumbers.get(number);
    }

    public static List<LottoNumber> lottoNumberMinToMax() {
        return lottoNumberList;
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
    public int compareTo(LottoNumber that) {
        return Integer.compare(this.lottoNumber, that.lottoNumber);
    }

    public LottoNumberDto getLottoNumberDto() {
        return new LottoNumberDto(lottoNumber);
    }

}
