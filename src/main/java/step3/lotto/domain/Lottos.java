package step3.lotto.domain;

import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/05/17 1:52 오후
 */
public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public MatchStatistic match(Lotto winningLotto) {
        MatchStatistic matchStatistic = new MatchStatistic();
        for (Lotto lotto : lottos) {
            matchStatistic.add(lotto.match(winningLotto));
        }
        return matchStatistic;
    }
}
