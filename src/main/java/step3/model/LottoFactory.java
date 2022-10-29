package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {

    private static final String NONE_POSITIVE_MESSAGE = "로또 개수는 한개 이상만 허용됩니다";

    public static List<Lotto> createLottos(int size) {
        if (size <= 0) throw new IllegalArgumentException(NONE_POSITIVE_MESSAGE);
        List<Lotto> lottos = new ArrayList();
        for (int i = 0; i < size; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private static Lotto createLotto() {

        List<LottoNumber> lottoNumbers = LottoNumber.getLottoNumbers();
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> randomLottoNumbers = lottoNumbers
                .stream()
                .limit(Lotto.getNumberSize())
                .collect(Collectors.toList());
        return new Lotto(randomLottoNumbers);
    }
}
