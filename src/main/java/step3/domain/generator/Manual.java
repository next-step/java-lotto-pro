package step3.domain.generator;

import step3.domain.lotto.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class Manual implements LottoFactory {

    private final List<Integer> list;

    public Manual(List<Integer> asList) {
        this.list = asList;
    }

    @Override
    public List<LottoNumber> create() {
        return list.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
