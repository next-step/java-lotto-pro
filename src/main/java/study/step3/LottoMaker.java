package study.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static study.step3.constants.CommonConstants.*;

public class LottoMaker {
    public static Lottos makeLottos(Money inputMoney) {
        List<Lotto> lottoList = new ArrayList<>();
        int num = inputMoney.dividedBy(PRICE_PER_LOTTO);
        for (int i = 0; i < num; i++) {
            lottoList.add(makeLotto());
        }
        return new Lottos(lottoList);
    }

    private static Lotto makeLotto() {
        List<Integer> numbers = new ArrayList<>(LottoNumberRange.shuffledNumbers()
                .subList(SUB_LIST_START_INDEX, SUB_LIST_END_INDEX));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
