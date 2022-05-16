package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Lotto {
    public static final Money PRICE = new Money(1_000L);
    public static final int LOTTO_SELECTABLE_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(Set<LottoNumber> numbers) {
        if(numbers.size() != LOTTO_SELECTABLE_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개 보다 작거나 클수 없습니다.");
        }
    }

    public Reward compareTo(Lotto other) {
        Set<LottoNumber> copy = new HashSet<>(numbers);
        copy.retainAll(other.numbers);
        return Reward.of(copy.size());
    }

    public List<LottoNumber> getSortedNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }
}
