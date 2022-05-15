package lotto.model;

import generator.InputLottoNumberGenerator;
import generator.RandomLottoNumberGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos buy(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int count = money.maxLottoCount();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.draw(new RandomLottoNumberGenerator()));
        }
        return new Lottos(lottos);
    }

    public static Lottos buy(String[] input) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            lottos.add(Lotto.draw(new InputLottoNumberGenerator(input[i])));
        }
        return new Lottos(lottos);
    }

    public List<Lotto> readOnlyLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int size() {
        return lottos.size();
    }
}
