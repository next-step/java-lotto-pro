package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int getHasLottoSize() {
        return lottoList.size();
    }

    public Rewards check(final WinningLottoNumber winningLottoNumber) {
        return this.lottoList.stream()
                .map(winningLottoNumber::check)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Rewards::new));
    }

    public Lottos merge(final Lottos otherLottos) {
        List<Lotto> mergeLottoList = Stream.concat(this.lottoList.stream(), otherLottos.lottoList.stream())
                .collect(Collectors.toList());
        return new Lottos(mergeLottoList);
    }

    @Override
    public String toString() {
        return lottoList.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
