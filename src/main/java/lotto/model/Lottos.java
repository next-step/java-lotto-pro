package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int count) {
        lottos = createLotto(count);
    }

    public Lottos(Lotto[] lottoArgs) {
        lottos = Arrays.asList(lottoArgs);
    }

    public List<Lotto> allGames() {
        return lottos;
    }

    private List<Lotto> createLotto(int count) {
        List<Lotto> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(new Lotto());
        }
        return results;
    }
}
