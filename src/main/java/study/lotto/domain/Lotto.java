package study.lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Lotto {
    static final int LOTTO_NUMBER_SIZE = 6;

    private static final String DELIMITER = ",";
    private static final Pattern LOTTO_PATTERN = Pattern.compile(
            "^(\\d|\\s)*,(\\d|\\s)*,(\\d|\\s)*,(\\d|\\s)*,(\\d|\\s)*,(\\d|\\s)*$");

    private final List<LottoNumber> values;

    public Lotto(Lotto lotto) {
        this(lotto.values);
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateNumberCount(lottoNumbers);
        validateDuplicates(lottoNumbers);
        this.values = copy(lottoNumbers);
    }

    public static Lotto from(String lottoString) {
        if (!LOTTO_PATTERN.matcher(lottoString).find()) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자가 쉼표로 연결되어 있는 형태여야 합니다.");
        }
        return new Lotto(Arrays.stream(lottoString.split(DELIMITER))
                .map(String::trim)
                .map(Integer::new)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public List<LottoNumber> get() {
        return copy(values);
    }

    public boolean has(LottoNumber number) {
        return values.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(number));
    }

    public int matchCount(Lotto lotto) {
        return findDuplicates(lotto).size();
    }

    private List<LottoNumber> findDuplicates(Lotto lotto) {
        List<LottoNumber> duplicates = copy(values);
        duplicates.retainAll(lotto.values);
        return duplicates;
    }

    private List<LottoNumber> copy(final List<LottoNumber> original) {
        return original.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateNumberCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateDuplicates(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumberSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("중복된 로또 번호를 가질 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(values, lotto.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
