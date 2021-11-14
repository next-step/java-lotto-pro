package lotto.domain;

import lotto.consts.LottoNumberConst;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Price price) {
        lottos = new ArrayList<>();
        List<Integer> numbers = IntStream.rangeClosed(LottoNumberConst.START_NUMBER, LottoNumberConst.END_NUMBER).boxed().collect(Collectors.toList());

        for (int i = 0; i < price.getNumberOfLotto(); i++) {
            Collections.shuffle(numbers);
            lottos.add(new Lotto(new ArrayList<>(numbers.subList(0, LottoNumberConst.LOTTO_NUMBER_SIZE))));
        }
    }

    /**
     * Constructor for test
     */
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
