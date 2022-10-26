package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    public static final Integer LottoPrice = 1000;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        validate(uniqueNumbers);
        this.lottoNumbers = uniqueNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private void validate(final HashSet<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개가 필요 합니다.");
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
