package lotto.lotto;

import lotto.Purchasable;
import lotto.money.Money;
import lotto.util.CollectionUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto implements Purchasable {

    static final int SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    protected Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = validated(lottoNumbers);
    }

    public static Lotto of(Integer... numbers) {
        return of(Arrays.asList(numbers));
    }

    public static Lotto of(List<Integer> numbers) {
        final List<LottoNumber> lottoNumbers = toLottoNumbers(numbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto of(String... maybeNumbers) {
        final List<LottoNumber> lottoNumbers = Arrays.stream(maybeNumbers)
                                                     .map(LottoNumber::new)
                                                     .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    @Override
    public Money price() {
        return Money.ONE_THOUSAND;
    }

    public int countMatches(Lotto other) {
        int count = 0;
        for (LottoNumber lottoNumber : other.lottoNumbers) {
            count += matches(lottoNumber);
        }
        return count;
    }

    private int matches(LottoNumber lottoNumber) {
        if (this.lottoNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private static List<LottoNumber> validated(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicated(lottoNumbers);
        Collections.sort(lottoNumbers);
        return Collections.unmodifiableList(lottoNumbers);
    }

    private static void validateSize(List<LottoNumber> lottoNumbers) {
        if (CollectionUtils.isEmpty(lottoNumbers)) {
            throw new IncorrectLottoNumberSizeException(lottoNumbers);
        }
        if (lottoNumbers.size() != SIZE) {
            throw new IncorrectLottoNumberSizeException(lottoNumbers);
        }
    }

    private static void validateDuplicated(List<LottoNumber> lottoNumbers) {
        if (hasDuplicate(lottoNumbers)) {
            throw new AlreadyExistsLottoNumberException(lottoNumbers);
        }
    }

    private static boolean hasDuplicate(List<LottoNumber> lottoNumbers) {
        final Set<LottoNumber> set = new HashSet<>(lottoNumbers);
        return set.size() != lottoNumbers.size();
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        if (CollectionUtils.isEmpty(numbers)) {
            return Collections.emptyList();
        }
        return numbers.stream()
                      .map(LottoNumber::new)
                      .collect(Collectors.toList());
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
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
