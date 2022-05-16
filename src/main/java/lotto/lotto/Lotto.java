package lotto.lotto;

import lotto.Purchasable;
import lotto.money.Money;
import lotto.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto implements Purchasable {

    public static final Money PRICE = Money.ONE_THOUSAND;
    static final int SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    protected Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = validate(lottoNumbers);
    }

    public static Lotto of(Integer... numbers) {
        return of(Arrays.asList(numbers));
    }

    static Lotto of(List<Integer> numbers) {
        final List<LottoNumber> lottoNumbers = toLottoNumbers(numbers);
        return new Lotto(lottoNumbers);
    }

    static Lotto of(String... maybeNumbers) {
        final List<LottoNumber> lottoNumbers = Arrays.stream(maybeNumbers)
                                                     .map(LottoNumber::of)
                                                     .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    @Override
    public Money price() {
        return PRICE;
    }

    public int countMatches(Lotto other) {
        int count = 0;
        for (LottoNumber lottoNumber : other.lottoNumbers) {
            count = increaseIfMatches(lottoNumber, count);
        }
        return count;
    }

    private int increaseIfMatches(LottoNumber lottoNumber, int count) {
        if (this.lottoNumbers.contains(lottoNumber)) {
            return count + 1;
        }
        return count;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    private static Set<LottoNumber> validate(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicated(lottoNumbers);
        return Collections.unmodifiableSet(new TreeSet<>(lottoNumbers));
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
                      .map(LottoNumber::of)
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
