package lotto;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static util.ListUtils.distinct;
import static util.ListUtils.randomPickCount;
import static util.ListUtils.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    public static final LottoNumbers ALL_NUMBERS = new LottoNumbers(totalLottoNumberList());
    private static final int DEFAULT_PICK_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    protected LottoNumbers(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = sort(lottoNumbers, comparing(LottoNumber::getNumber));
    }

    public static LottoNumbers pickNumbers(List<LottoNumber> lottoNumbers) {
        validatePickNumbers(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private static void validatePickNumbers(final List<LottoNumber> lottoNumbers) {
        final int count = distinct(lottoNumbers).size();
        if (count != DEFAULT_PICK_COUNT) {
            throw new IllegalArgumentException("당첨 번호 숫자들이 6개가 이닙니다.(" + count +")개");
        }
    }

    public LottoNumbers pickNumbersRandom() {
        return new LottoNumbers(randomPickCount(this.lottoNumbers, DEFAULT_PICK_COUNT));
    }

    private static List<LottoNumber> totalLottoNumberList() {
        List<LottoNumber> allNumbers = new ArrayList<>();
        for (int i = LottoNumber.START_NUM; i <= LottoNumber.LAST_NUM; i++) {
            allNumbers.add(LottoNumber.valueOf(i));
        }
        return allNumbers;
    }

    public boolean isPicked() {
        return this.lottoNumbers.size() == DEFAULT_PICK_COUNT;
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
