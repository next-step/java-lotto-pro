package lotto;

import java.util.Iterator;
import java.util.List;

public class ManualLottoNumberGenerateStrategy implements LottoNumberGenerateStrategy {

    private final Iterator<Integer> numbersIterator;
    private static final String NO_LOTTO_NUMBER = "생성에 사용할 수 있는 로또 번호가 없습니다.";

    public ManualLottoNumberGenerateStrategy(List<Integer> numbers) {
        this.numbersIterator = numbers.iterator();
    }

    @Override
    public LottoNumber generate() {
        if (!this.numbersIterator.hasNext()) {
            throw new RuntimeException(NO_LOTTO_NUMBER);
        }
        return LottoNumber.valueOf(this.numbersIterator.next());
    }
}
