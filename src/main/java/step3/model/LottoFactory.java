package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.model.Lotto.NUMBER_SIZE;
import static step3.model.LottoNumber.LOTTO_MAX_VALUE;
import static step3.model.LottoNumber.LOTTO_MIN_VALUE;

public class LottoFactory {

    private static final List<Integer> CANDIDATE_NUMBERS;
    private static final String NONE_POSITIVE_MESSAGE = "로또 개수는 한개 이상만 허용됩니다";

    static {
        CANDIDATE_NUMBERS = IntStream
                .rangeClosed(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE)
                .boxed().collect(Collectors.toList());
    }

    public static List<Lotto> createLottos(int size) {
        if (size <= 0) throw new IllegalArgumentException(NONE_POSITIVE_MESSAGE);
        List<Lotto> lottos = new ArrayList();
        for (int i = 0; i < size; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private static Lotto createLotto() {
        Collections.shuffle(CANDIDATE_NUMBERS);
        List<LottoNumber> lottoNumbers = CANDIDATE_NUMBERS
                .stream()
                .limit(NUMBER_SIZE)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers,true);
    }
}
