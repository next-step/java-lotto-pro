package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumber =
            IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());

    private List<Lotto> lottos = new LinkedList<>();

    public List<Lotto> getLottos() {
        return new ArrayList(this.lottos);
    }

    public List<Lotto> purchase(int money) {
        if (money < LOTTO_PRICE || money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액은 " + LOTTO_PRICE + "단위이어야 합니다.");
        }
        return generateLottos(money / LOTTO_PRICE);
    }

    private List<Lotto> generateLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
        return lottos;
    }

    private List<Integer> generateRandomNumbers() {
        Collections.shuffle(lottoNumber);
        List<Integer> pickedNumber = new ArrayList<>();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            pickedNumber.add(lottoNumber.get(i));
        }

        Collections.sort(pickedNumber);

        return pickedNumber;
    }

    public void purchaseManual(List<List<Integer>> manualLottos) {
        manualLottos.forEach(lottoNumber -> lottos.add(new Lotto(lottoNumber)));
    }
}
