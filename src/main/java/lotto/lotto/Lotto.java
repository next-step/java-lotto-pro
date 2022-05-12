package lotto.lotto;

import lotto.Purchasable;
import lotto.money.Money;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto implements Purchasable {

    private static final int SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    protected Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = validated(lottoNumbers);
    }

    public static Lotto of(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IncorrectLottoNumberSizeException();
        }
        final List<LottoNumber> lottoNumbers = toLottoNumbers(numbers);
        return new Lotto(lottoNumbers);
    }

    @Override
    public Money price() {
        return Money.ONE_THOUSAND;
    }

    public int countMatches(Lotto other) {
        int count = 0;
        for (LottoNumber lottoNumber : other.lottoNumbers) {
            count += this.lottoNumbers.contains(lottoNumber) ? 1 : 0;
        }
        return count;
    }

    List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private static List<LottoNumber> validated(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new IncorrectLottoNumberSizeException();
        }
        if (lottoNumbers.size() != SIZE) {
            throw new IncorrectLottoNumberSizeException();
        }
        if (hasDuplicate(lottoNumbers)) {
            throw new AlreadyExistsLottoNumberException();
        }
        Collections.sort(lottoNumbers);
        return Collections.unmodifiableList(lottoNumbers);
    }

    private static boolean hasDuplicate(List<LottoNumber> lottoNumbers) {
        final Set<LottoNumber> set = new HashSet<>(lottoNumbers);
        return set.size() != lottoNumbers.size();
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .map(LottoNumber::new)
                      .collect(Collectors.toList());
    }
}
