package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final String ERROR_MESSAGE_MUST_BE_SIX_NUMBER = "로또는 서로 다른 6개의 숫자여야 합니다.";
    private final Set<Integer> numbers = new HashSet<>();

    public Lotto() {
        this(LottoNumbers.pick());
    }

    public Lotto(List<Integer> numbers) {
        this.numbers.addAll(numbers);
        if (this.numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MUST_BE_SIX_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
