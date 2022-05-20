package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SIZE = 6;

    private final List<LottoNumber> lottoNumber;

    public Lotto(List<Integer> numbers) {
        this.validateLotto(numbers);
        this.lottoNumber = numbers.stream()
                .map((number) -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumber() {
        return new ArrayList(this.lottoNumber);
    }

    private void validateLotto(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != SIZE) {
            throw new IllegalArgumentException("로또 각 번호는 중복될수 없습니다.");
        }
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개로 구성되어 있어야합니다.");
        }
    }

    public int getMatchCount(WinLotto winLotto) {
        return (int) lottoNumber.stream()
                .filter(winLotto.getLotto().lottoNumber::contains)
                .count();
    }

    public boolean isMatchedBonus(WinLotto winLotto) {
        return lottoNumber.contains(winLotto.getBonus());
    }
}
