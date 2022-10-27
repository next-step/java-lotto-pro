package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> integers = Collections.unmodifiableList(numbers);
        this.numbers = integers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        Collections.sort(this.numbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public String print(){
        return String.format("[%s]", String.join(",", convertToStringNumbers()));
    }

    private List<String> convertToStringNumbers() {
        return this.numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.toList());
    }

    public int check(List<Integer> winningNumbers) {
        return (int)winningNumbers.stream()
                .map(w -> numbers.contains(LottoNumber.of(w)))
                .filter(r -> r.equals(true)).count();
    }
}
