package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;
    private final NumberPickStrategy randomNumberPickStrategy;

    public Lottos(NumberPickStrategy randomNumberPickStrategy) {
        lottos = new ArrayList<>();
        this.randomNumberPickStrategy = randomNumberPickStrategy;
    }

    public void buyRandomNumberLottos(int count) {
        IntStream.iterate(0, i -> i + 1)
                .limit(count)
                .mapToObj(i -> new Lotto(randomNumberPickStrategy.pick()))
                .forEach(lottos::add);
    }

    public LottoResultStat checkResultStat(WinningLotto winningLotto) {
        LottoResultStat lottoResultStat = new LottoResultStat();

        lottos.stream()
                .map(winningLotto::checkResult)
                .forEach(lottoResultStat::report);

        return lottoResultStat;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
