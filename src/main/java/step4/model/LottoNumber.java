package step4.model;

import step4.constant.ErrorMessageConstant;
import step4.constant.LottoConstant;
import step4.exception.LottoFormatException;

import java.util.*;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        IntStream.rangeClosed(LottoConstant.LOTTO_MIN_NUM, LottoConstant.LOTTO_MAX_NUM)
                .forEach(num ->
                        lottoNumbers.put(num, new LottoNumber(num))
                );
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (lottoNumber == null) {
            throw new LottoFormatException(ErrorMessageConstant.OUT_OF_SIZE_LOTTO_NUMBER);
        }
        return lottoNumber;
    }

    public static LottoNumber valueOf(String text) {
        return valueOf(convertNumber(text));
    }

    private static int convertNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new LottoFormatException(ErrorMessageConstant.NOT_NUMBER);
        }
    }

    public static List<LottoNumber> getLottoCandidateNumbers() {
        return new ArrayList<>(lottoNumbers.values());
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
