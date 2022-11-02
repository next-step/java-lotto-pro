package study.step4.helper;

import study.step4.models.Lotto;
import study.step4.models.Lottos;
import study.step4.models.Money;
import study.step4.models.Numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
    public static Lottos makeLottos(Money inputMoney) {
        List<Lotto> lottoList = new ArrayList<>();
        int num = inputMoney.dividedBy(Money.PRICE_PER_LOTTO);
        for (int i = 0; i < num; i++) {
            lottoList.add(makeLotto());
        }
        return new Lottos(lottoList);
    }

    private static Lotto makeLotto() {
        List<Integer> numbers = new ArrayList<>(LottoNumbersRule.shuffledNumbers()
                .subList(Lotto.SUB_LIST_START_INDEX, Lotto.SUB_LIST_END_INDEX));
        Collections.sort(numbers);
        return new Lotto(new Numbers(numbers));
    }
}
