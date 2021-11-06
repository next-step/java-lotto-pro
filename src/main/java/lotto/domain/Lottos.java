package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final int BASE_NUMBER = 0;

    private final List<Lotto> lottos;

    public Lottos(int count, Numbers numbers) {
        this.lottos = IntStream.range(BASE_NUMBER, count)
                .mapToObj(number -> new Lotto(numbers))
                .collect(Collectors.toList());
    }

    public Lottos(Money money, Numbers numbers) {
        this(money.buy(), numbers);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public List<Rank> match(Lotto winningLotto, Bonus bonus) {
        return lottos.stream()
                .map(lotto -> Rank.rank(winningLotto, lotto, bonus))
                .collect(Collectors.toList());
    }
}
