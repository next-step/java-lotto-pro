package lotto.domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    public static final int SIZE = 6;
    private final List<LottoNumber> numbers;
    private LottoNumber bonusNumber;

    protected Lotto(List<LottoNumber> numbers) {
        validateLottoSize(numbers);
        this.numbers = numbers;
    }

    protected Lotto(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        this(numbers);
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(LottoNumber bonusNumber) {
        if (isContainsBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호에 보너스 번호가 포함될 수 없습니다.");
        }
    }

    private boolean isContainsBonusNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validateLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개여야 합니다.", SIZE));
        }
    }

    public static Lotto of(String winningLottoNumber, int bonusNumber) {
        return new Lotto(LottoNumber.parse(winningLottoNumber), new LottoNumber(bonusNumber));
    }

    public static Lotto from(String numbers) {
        return new Lotto(LottoNumber.parse(numbers));
    }

    public static Lotto from(LottoNumberStrategy lottoNumberStrategy) {
        return new Lotto(lottoNumberStrategy.create());
    }

    public Rank match(Lotto winningLotto) {
        Set<LottoNumber> collect = new HashSet<>(winningLotto.numbers);

        int matchCount = (int) this.numbers.stream()
                .filter(collect::contains)
                .count();

        return Rank.matchResult(matchCount, isContainsBonusNumber(winningLotto.bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        numbers.sort(Comparator.comparingInt(LottoNumber::getValue));
        return numbers.toString();
    }
}

