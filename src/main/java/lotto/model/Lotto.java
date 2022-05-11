package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<Integer> numbers = new HashSet<>();

    public Lotto() {
        numbers.addAll(LottoNumbers.pick());
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
