package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> sell(int count) {
        return generateLottoList(count);
    }

    private List<Lotto> generateLottoList(int purchasedLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchasedLottoCount; i++) {
            Lotto lotto = generateLotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private Lotto generateLotto() {
        List<Integer> values = LottoNumber.getValues().subList(0, Lotto.LOTTO_NUMBER_COUNT);
        int[] numbers = values.stream()
                .mapToInt(value -> Integer.parseInt(String.valueOf(value)))
                .toArray();
        return new Lotto(numbers);
    }
}
