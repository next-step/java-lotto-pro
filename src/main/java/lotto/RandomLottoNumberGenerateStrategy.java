package lotto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerateStrategy implements LottoNumberGenerateStrategy {

    private static final int START_INCLUSIVE = 1;
    private static final int END_EXCLUSIVE = 46;
    private static final LinkedList<Integer> candidateLottoNumbers =
        IntStream.range(START_INCLUSIVE, END_EXCLUSIVE)
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));
    private static final String NO_LOTTO_NUMBER = "생성에 사용할 수 있는 로또 번호가 없습니다.";

    @Override
    public LottoNumber generate() {
        if (candidateLottoNumbers.size() < 1) {
            throw new RuntimeException(NO_LOTTO_NUMBER);
        }
        Collections.shuffle(candidateLottoNumbers);
        return LottoNumber.valueOf(candidateLottoNumbers.removeFirst());
    }
}
