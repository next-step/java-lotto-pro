package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constant.Config.*;

public class LottoMachine {
    private static final List<Integer> lottoNumber =
            IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());

    private List<Integer> generateRandomNumbers() {
        Collections.shuffle(lottoNumber);
        List<Integer> pickedNumber = new ArrayList<>();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            pickedNumber.add(lottoNumber.get(i));
        }

        Collections.sort(pickedNumber);

        return pickedNumber;
    }

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
        return lottos;
    }

    public List<Lotto> purchase(int money) {
        if (money < LOTTO_PRICE || money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
        return generateLottos(money / LOTTO_PRICE);
    }
}
