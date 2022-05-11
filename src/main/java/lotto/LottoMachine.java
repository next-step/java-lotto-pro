package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    private final int count;
    private List<AutomaticNumber> lottoList;

    public LottoMachine(int repeatNumber) {
        count = repeatNumber;
        generateLotto(count);
    }

    private void generateLotto(int count) {
        lottoList = Stream.generate(AutomaticNumber::new)
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<AutomaticNumber> getLottoList() {
        return lottoList;
    }
}
