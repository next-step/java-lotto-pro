package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Price price) {
        lottos = new ArrayList<>();
        for (int i = 0; i < price.getNumberOfLotto(); i++)
            lottos.add(createLotto());
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

    private Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        return new Lotto(numbers);
    }
}
