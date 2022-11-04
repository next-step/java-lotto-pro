package lotto.domain;

import lotto.dto.LottoNumberDto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static Map<Integer,LottoNumber> lottoNumbers = new HashMap<>();
    private int lottoNumber;

    static {
        for (int number = LOTTO_MIN_NUMBER; number <= LOTTO_MAX_NUMBER; number++) {
            lottoNumbers.put(number, new LottoNumber(number));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(String text) {
        return of(Optional.ofNullable(text)
                .filter(str -> str.trim().matches("\\d+"))
                .map(str -> Integer.parseInt(str.trim()))
                .orElseThrow(() -> new IllegalArgumentException("자연수 형식이 아닙니다.")));
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
        return lottoNumbers.keySet().stream().map(lottoNumbers::get).collect(Collectors.toList());
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