package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream()
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
}
