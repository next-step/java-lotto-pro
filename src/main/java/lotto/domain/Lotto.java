package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.constants.ExceptionConstants.*;

public class Lotto {
    private static final int BEGIN_NUMBER = 1;
    private static final int END_NUMBER = 46;
    private static final int LIMIT_LOTTO = 6;
    private static final Lotto INSTANCE = new Lotto();
    private static final String PRINT_DELIMITER = ",";
    private static final String PRINT_PREFIX = "[";
    private static final String PRINT_SUFFIX = "]";

    private final List<LottoNumber> lotto;

    public static Lotto ofAnswer(final String lottoNumbers) {
        return new Lotto(
                Stream.of(lottoNumbers.split(PRINT_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList())
        );
    }

    public Lotto(final List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lotto = lottoNumbers;
    }

    private Lotto() {
        lotto = IntStream.range(BEGIN_NUMBER, END_NUMBER)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static Lotto auto() {
        shuffle();
        return new Lotto(generateAuto());
    }

    private static List<LottoNumber> generateAuto() {
        return INSTANCE.lotto.stream()
                .limit(LIMIT_LOTTO)
                .collect(Collectors.toList());
    }

    private static void shuffle() {
        Collections.shuffle(INSTANCE.lotto);
    }

    public String printLotto() {
        return lotto.stream()
                .map(LottoNumber::getLottoNumber)
                .map(Objects::toString)
                .collect(Collectors.joining(PRINT_DELIMITER, PRINT_PREFIX, PRINT_SUFFIX));
    }

    public long matchCount(final Lotto answer) {
        return answer.lotto.stream()
                .filter(this::contains)
                .count();
    }

    private boolean contains(final LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    private void validate(final List<LottoNumber> lottoNumbers) {
        validateLength(lottoNumbers);
        validateOverlap(lottoNumbers);
    }

    private void validateLength(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LIMIT_LOTTO) {
            throw new IllegalArgumentException(LOTTO_LENGTH_EXCEPTION);
        }
    }

    private void validateOverlap(List<LottoNumber> lottoNumbers) {
        long count = lottoNumbers.stream().distinct().count();

        if (count != LIMIT_LOTTO) {
            throw new IllegalArgumentException(LOTTO_OVERLAP_EXCEPTION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return "Lotto{" + "lotto=" + lotto + '}';
    }
}
