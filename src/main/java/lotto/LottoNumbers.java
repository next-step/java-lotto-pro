package lotto;

import static java.util.stream.Collectors.joining;
import static util.ListUtils.distinct;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumbers {
    private static final int PICK_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    protected LottoNumbers(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
    }

    public static LottoNumbers pickNumbers(List<LottoNumber> lottoNumbers) {
        validatePickNumbers(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private static void validatePickNumbers(final List<LottoNumber> lottoNumbers) {
        final int count = distinct(lottoNumbers).size();
        if (count != PICK_COUNT) {
            throw new IllegalArgumentException("로또 번호들이 6개가 이닙니다.(" + count +")개");
        }
    }

    public boolean isPicked() {
        return this.lottoNumbers.size() == PICK_COUNT;
    }

    public int compareCount(final LottoNumbers lottoNumbers) {
        int count = 0;
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            count += lottoNumbers.containsToOne(lottoNumber);
        }

        return count;
    }

    public int containsToOne(final LottoNumber lottoNumber) {
        if (contains(lottoNumber)) {
            return 1;
        }

        return 0;
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public String toStringPickNumbers() {
        return this.lottoNumbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .collect(joining(", "));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumbers)) {
            return false;
        }
        final LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
