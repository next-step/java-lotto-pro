package camp.nextstep.edu.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers() {
        final int START_NUMBER = 1;
        final int END_NUMBER = 45;
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public boolean isContains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public Lotto extract(Consumer<List<LottoNumber>> consumer)  {
        consumer.accept(lottoNumbers);
        return new Lotto(lottoNumbers.subList(0, 6).toArray(new LottoNumber[0]));
    }
}
